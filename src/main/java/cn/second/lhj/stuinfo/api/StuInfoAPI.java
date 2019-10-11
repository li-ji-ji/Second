package cn.second.lhj.stuinfo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.second.lhj.stuinfo.po.StuInfo;
import cn.second.lhj.stuinfo.service.StuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api
public class StuInfoAPI {
	
	@Autowired
	private StuInfoService stuInfoServ;


/*-----------------------------------------查询---------------------------------------------*/
	//查询所有学生信息
    @ApiOperation(value="查询所有学生信息")
	@RequestMapping("/getStuInfoAll")
	public List<StuInfo> getStuInfoAll()throws Exception{
		return stuInfoServ.getAll();
	}
	
	//根据学号查询学生信息
    @ApiOperation(value="根据学号查询学生信息")
	@RequestMapping("/getStuInfoByStuId")
	 public StuInfo getStuInfoByStuId(@RequestParam("stuId")String stuId) throws Exception{
    	return stuInfoServ.getByStuId(stuId);
    }

/*-----------------------------------------查询---------------------------------------------*/

	
	
/*-----------------------------------------添加---------------------------------------------*/
	 //添加学生信息
    @ApiOperation(value="添加学生信息")
	@RequestMapping("/addStuInfoOne")
	 public int addStuInfoOne(@RequestBody StuInfo stuInfo)throws Exception{
    	return stuInfoServ.addOne(stuInfo);
    }

/*-----------------------------------------添加---------------------------------------------*/
	
	
	
/*-----------------------------------------修改---------------------------------------------*/
	 //修改单条学生信息
    @ApiOperation(value="修改单条学生信息")
	@RequestMapping("/setStuInfoOne")
	 public int setStuInfoOne(@RequestBody StuInfo stuInfo) throws Exception{
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
