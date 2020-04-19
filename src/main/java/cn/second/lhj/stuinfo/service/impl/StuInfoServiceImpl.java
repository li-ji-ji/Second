package cn.second.lhj.stuinfo.service.impl;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.apache.HttpClientUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.second.lhj.apply.po.ApplyExample.Criteria;
import cn.second.lhj.stuinfo.mapper.StuInfoMapperExtends;
import cn.second.lhj.stuinfo.po.Student;
import cn.second.lhj.stuinfo.po.StudentExample;
import cn.second.lhj.stuinfo.service.StuInfoService;
import cn.second.lhj.util.HttpClientUtil;

@Service
public class StuInfoServiceImpl implements StuInfoService {
	
	@Autowired
	private StuInfoMapperExtends stuInfoMap;

/*-----------------------------------------查询---------------------------------------------*/
	//查询所有学生信息
	@Override
	public List<Student> getAll()throws Exception{
		return stuInfoMap.selectByExample(null);
	}
	
	//根据学号查询学生信息
	@Override
	 public Student getByStuId(String stuId) throws Exception{
		StudentExample example=new StudentExample();
		StudentExample.Criteria criteria=example.createCriteria();
		criteria.andSnEqualTo(stuId);
		List<Student> students=stuInfoMap.selectByExample(example);
		if(students.size()>0) {
			return students.get(0);
		}else {
			return null;
		}
	}

	// 根据主键查询学生信息
	public Student getBySn(String sn) throws Exception{
		StudentExample example = new StudentExample();
		StudentExample.Criteria criteria = example.createCriteria();
		criteria.andSnEqualTo(sn);
		List<Student> stus = stuInfoMap.selectByExample(example);
		Student stu = new Student();
		if(stus.size()==1) {
			stu = stus.get(0);
		}else {
			stu = null;
		}
		return stu;
	}
	//根据小程序端信息请求openID
	@Override
	public JSONObject getOpenId(String code) throws Exception {
		String secret = "f97dc2d0300b67108546d515052f7063";
		String appId = "wx5a7537799c6f4589";
		String url = "https://api.weixin.qq.com/sns/jscode2session"
					+"?appid="+appId
					+"&secret="+secret
					+"&js_code="+code
					+"&grant_type=authorization_code";
		return JSON.parseObject(HttpClientUtil.doGet(url));
	}
/*-----------------------------------------查询---------------------------------------------*/

	
	
/*-----------------------------------------添加---------------------------------------------*/
	 //添加学生信息
	@Override
	 public int addOne(Student stuInfo)throws Exception{
		StudentExample example=new StudentExample();
		StudentExample.Criteria criteria=example.createCriteria();
		criteria.andSnEqualTo(stuInfo.getSn());
		List<Student> students=stuInfoMap.selectByExample(example);
		if(students.size()>0) {
			return 0;
		}else {
			return stuInfoMap.insertSelective(stuInfo);
		}
	}

/*-----------------------------------------添加---------------------------------------------*/
	
	
	
/*-----------------------------------------修改---------------------------------------------*/
	 //修改单条学生信息
	@Override
	 public int setOne(Student stuInfo) throws Exception{
		return stuInfoMap.updateByPrimaryKeySelective(stuInfo);
	}
	 
	 
/*-----------------------------------------修改---------------------------------------------*/
	
	
	
	
/*-----------------------------------------删除---------------------------------------------*/

	 //根据学生学号删除单条学生信息
	@Override
	 public int delOneByStuId(String stuId)throws Exception{
		StudentExample example=new StudentExample();
		StudentExample.Criteria criteria=example.createCriteria();
		criteria.andSnEqualTo(stuId);
		return stuInfoMap.deleteByExample(example);
	}
/*-----------------------------------------删除---------------------------------------------*/



}
