package cn.second.lhj.stuinfo.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.second.lhj.log.Log;
import cn.second.lhj.stuinfo.po.Student;
import cn.second.lhj.stuinfo.service.StuInfoService;
import cn.second.lhj.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api
@RequestMapping("/api/stu")
public class StuInfoAPI {
	
	@Autowired
	private StuInfoService stuInfoServ;


/*-----------------------------------------查询---------------------------------------------*/
	//查询所有学生信息
    @ApiOperation(value="查询所有学生信息")
	@RequestMapping("/getStuInfoAll")
	public List<Student> getStuInfoAll()throws Exception{
		return stuInfoServ.getAll();
	}
	
	//根据学号查询学生信息
    @ApiOperation(value="根据学号查询学生信息")
	@RequestMapping("/getStuInfoByStuId")
	 public Student getStuInfoByStuId(@RequestParam("stuId")String stuId) throws Exception{
    	return stuInfoServ.getByStuId(stuId);
    }
    //根据小程序端信息请求openID绑定用户
    @ApiOperation(value="根据小程序端信息请求openID绑定用户")
	@RequestMapping("/getOpenId")
    @Log(value="根据小程序端信息请求openID绑定用户")
  	public Map getOpenId(@RequestParam("code")String code,@RequestParam("sn")String sn,
  			@RequestParam("password")String password) throws Exception{
    	JSONObject msg = stuInfoServ.getOpenId(code);
    	Student stu = stuInfoServ.getBySn(sn);
    	Map<String, String> result = new HashMap<String, String>();
    	if(stu == null) { // 判断学生账号是否存在
    		result.put("code", "2");
    		result.put("msg", "账号异常");
    	}else {
    		// 判断用户密码是否正确
    		if(stu.getPassword().equals(password)) { // 用户密码正确
    			stu.setWxopenid(msg.getString("openid")); // 绑定openID
    			try {
    				stuInfoServ.setOne(stu);
				} catch (Exception e) {
		    		result.put("code", "2");
		    		result.put("msg", "绑定失败");
		    		return result;
				}
    			result.put("code", "1");
    			result.put("openid", msg.getString("openid"));
    			// 生成用于jwt校验的秘钥串
				String JWTString = JwtUtil.setJWT(stu.getName(), stu.getName(), 1000*60*2880);//1000*60*2880
    			result.put("session_key", JWTString);
    			result.put("stuInfo", JSONObject.toJSONString(stu));
    			System.out.println(JSONObject.toJSONString(stu));
    		}else { // 用户密码错误
        		result.put("code", "2");
        		result.put("msg", "密码错误");
    		}
    	}
  		return result;
  	}

    //根据小程序端信息请求openID绑定用户
    @ApiOperation(value="判断用户登录是否过期")
	@RequestMapping("/checkJWT")
    @Log(value="判断用户登录是否过期")
  	public Map checkJWT(@RequestParam("JWTString")String JWTString) throws Exception{
		Map<String,String> result = new HashMap<String, String>();
		try {
			Claims claims =Jwts.parser().setSigningKey("evil-scream").parseClaimsJws(JWTString).getBody();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");
			System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
			System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
			System.out.println("当前时间:"+sdf.format(new Date()) );
			result.put("msg","JWT验证通过");
			result.put("code", "true");
		} catch (ExpiredJwtException e) {
			e.printStackTrace();
			result.put("msg", "过期");
			result.put("code", "false");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "其他");
			result.put("code", "false");
		}
		return result;
  	}
/*-----------------------------------------查询---------------------------------------------*/

	
	
/*-----------------------------------------添加---------------------------------------------*/
	 //添加学生信息
    @ApiOperation(value="添加学生信息")
	@RequestMapping("/addStuInfoOne")
	 public int addStuInfoOne(@RequestBody Student stuInfo)throws Exception{
    	return stuInfoServ.addOne(stuInfo);
    }

/*-----------------------------------------添加---------------------------------------------*/
	
	
	
/*-----------------------------------------修改---------------------------------------------*/
	 //修改单条学生信息
    @ApiOperation(value="修改单条学生信息")
	@RequestMapping("/setStuInfoOne")
	 public int setStuInfoOne(@RequestBody Student stuInfo) throws Exception{
    	return stuInfoServ.setOne(stuInfo);
    }
	 
	 
/*-----------------------------------------修改---------------------------------------------*/
	
	
	
	
/*-----------------------------------------删除---------------------------------------------*/
	 //根据学生学号删除单条学生信息
    @ApiOperation(value="根据学生学号删除单条学生信息")
	@RequestMapping("/delStuInfoOneByStuId")
	public int delStuInfoOneByStuId(@RequestParam("stuId")String stuId)throws Exception{
    	return stuInfoServ.delOneByStuId(stuId);
    }
/*-----------------------------------------删除---------------------------------------------*/
}
