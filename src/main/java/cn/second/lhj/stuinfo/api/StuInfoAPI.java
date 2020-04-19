package cn.second.lhj.stuinfo.api;

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
    	if(stu == null) {
    		result.put("code", "2");
    		result.put("msg", "账号异常");
    	}else {
    		if(stu.getPassword().equals(password)) {
    			stu.setWxopenid(msg.getString("openid"));
    			try {
    				stuInfoServ.setOne(stu);
				} catch (Exception e) {
		    		result.put("code", "2");
		    		result.put("msg", "绑定失败");
		    		return result;
				}
    			result.put("code", "1");
    			result.put("openid", msg.getString("openid"));
    			result.put("session_key", msg.getString("session_key"));
    			result.put("stuInfo", JSONObject.toJSONString(stu));
    			System.out.println(JSONObject.toJSONString(stu));
    		}else {
        		result.put("code", "2");
        		result.put("msg", "密码错误");
    		}
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
