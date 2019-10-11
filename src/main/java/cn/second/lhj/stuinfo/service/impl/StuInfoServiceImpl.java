package cn.second.lhj.stuinfo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.second.lhj.stuinfo.mapper.StuInfoMapperExtends;
import cn.second.lhj.stuinfo.po.StuInfo;
import cn.second.lhj.stuinfo.service.StuInfoService;

@Service
public class StuInfoServiceImpl implements StuInfoService {
	
	@Autowired
	private StuInfoMapperExtends stuInfoMap;

/*-----------------------------------------查询---------------------------------------------*/
	//查询所有学生信息
	@Override
	public List<StuInfo> getAll()throws Exception{
		return stuInfoMap.selectByExample(null);
	}
	
	//根据学号查询学生信息
	@Override
	 public StuInfo getByStuId(String stuId) throws Exception{
		return stuInfoMap.selectByPrimaryKey(stuId);
	}

/*-----------------------------------------查询---------------------------------------------*/

	
	
/*-----------------------------------------添加---------------------------------------------*/
	 //添加学生信息
	@Override
	 public int addOne(StuInfo stuInfo)throws Exception{
		Date now=new Date();
		stuInfo.setWriteTime(now);
		return stuInfoMap.insertSelective(stuInfo);
	}

/*-----------------------------------------添加---------------------------------------------*/
	
	
	
/*-----------------------------------------修改---------------------------------------------*/
	 //修改单条学生信息
	@Override
	 public int setOne(StuInfo stuInfo) throws Exception{
		return stuInfoMap.updateByPrimaryKeySelective(stuInfo);
	}
	 
	 
/*-----------------------------------------修改---------------------------------------------*/
	
	
	
	
/*-----------------------------------------删除---------------------------------------------*/

	 //根据学生学号删除单条学生信息
	@Override
	 public int delOneByStuId(String stuId)throws Exception{
		return stuInfoMap.deleteByPrimaryKey(stuId);
	}
/*-----------------------------------------删除---------------------------------------------*/

}
