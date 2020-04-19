package cn.second.lhj.stuinfo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.second.lhj.stuinfo.po.Student;

@Service
public interface StuInfoService {

/*-----------------------------------------查询---------------------------------------------*/
	//查询所有学生信息
	public List<Student> getAll()throws Exception;
	
	//根据学号查询学生信息
	public Student getByStuId(String stuId) throws Exception;
	 
	//根据小程序端信息请求openID
	public JSONObject getOpenId(String code) throws Exception;
	
	// 根据主键查询学生信息
	public Student getBySn(String sn) throws Exception;

/*-----------------------------------------查询---------------------------------------------*/

	
	
/*-----------------------------------------添加---------------------------------------------*/
	 //添加学生信息
	 public int addOne(Student stuInfo)throws Exception;

/*-----------------------------------------添加---------------------------------------------*/
	
	
	
/*-----------------------------------------修改---------------------------------------------*/
	 //修改单条学生信息
	 public int setOne(Student stuInfo) throws Exception;
	 
	 
/*-----------------------------------------修改---------------------------------------------*/
	
	
	
	
/*-----------------------------------------删除---------------------------------------------*/
	 //根据学生学号删除单条学生信息
	 public int delOneByStuId(String stuId)throws Exception;
/*-----------------------------------------删除---------------------------------------------*/
}
