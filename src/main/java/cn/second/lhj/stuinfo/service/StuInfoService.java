package cn.second.lhj.stuinfo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.second.lhj.stuinfo.po.StuInfo;

@Service
public interface StuInfoService {

/*-----------------------------------------查询---------------------------------------------*/
	//查询所有学生信息
	public List<StuInfo> getAll()throws Exception;
	
	//根据学号查询学生信息
	 public StuInfo getByStuId(String stuId) throws Exception;

/*-----------------------------------------查询---------------------------------------------*/

	
	
/*-----------------------------------------添加---------------------------------------------*/
	 //添加学生信息
	 public int addOne(StuInfo stuInfo)throws Exception;

/*-----------------------------------------添加---------------------------------------------*/
	
	
	
/*-----------------------------------------修改---------------------------------------------*/
	 //修改单条学生信息
	 public int setOne(StuInfo stuInfo) throws Exception;
	 
	 
/*-----------------------------------------修改---------------------------------------------*/
	
	
	
	
/*-----------------------------------------删除---------------------------------------------*/
	 //根据学生学号删除单条学生信息
	 public int delOneByStuId(String stuId)throws Exception;
/*-----------------------------------------删除---------------------------------------------*/
}
