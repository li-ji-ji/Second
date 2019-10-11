package cn.second.lhj.asso.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.second.lhj.asso.mapper.extend.ActRegisterMapper;
import cn.second.lhj.asso.po.CspActRegister;
import cn.second.lhj.asso.po.CspActRegisterExample;
import cn.second.lhj.asso.service.CspActRegisterService;
import cn.second.lhj.asso.service.CspAssoActivityService;


@Service
public class CspActRegisterServiceImpl implements CspActRegisterService {


	@Autowired
	private  ActRegisterMapper actReg;

	@Autowired
	private CspAssoActivityService assoAct;
	// TODO 调用学生接口
//	@Autowired
//	private StudentRemote stuRemote;
/*------------------------------------------查询---------------------------------------------------*/
	//查询所有签到记录
	@Override
	public List<CspActRegister> getActRegAll() throws Exception {
		return actReg.selectByExample(null);
	}

	//根据活动编号查询签到记录
	@Override
	public List<CspActRegister> getActRegByActId(String actId) throws Exception {
		CspActRegisterExample example=new CspActRegisterExample();
		CspActRegisterExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		return actReg.selectByExample(example);
	}

	//根据学生学号查询签到记录
	@Override
	public List<CspActRegister> getActRegByStuId(String stuId) throws Exception {
		CspActRegisterExample example=new CspActRegisterExample();
		CspActRegisterExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		return actReg.selectByExample(example);
	}

	//根据活动编号以及学生学号查询签到记录
	@Override
	public CspActRegister getActRegByActIdAndStuId(String actId, String stuId) throws Exception {
		CspActRegisterExample example=new CspActRegisterExample();
		CspActRegisterExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		criteria.andStuIdEqualTo(stuId);
		return actReg.selectByExample(example).get(0);
	}

/*------------------------------------------查询---------------------------------------------------*/
	

/*------------------------------------------删除---------------------------------------------------*/
	//根据ID删除签到记录
	@Override
	public int delActRegById(Integer id) throws Exception {
		return actReg.deleteByPrimaryKey(id);
	}

/*------------------------------------------删除---------------------------------------------------*/
	
	
/*------------------------------------------添加---------------------------------------------------*/
	//添加一条签到记录
	@Override
	public int addActRegOne(CspActRegister register) throws Exception {
		register.setActName(assoAct.getActivityByActId(register.getActId()).getActivityName());
		// TODO 获取学生姓名
		//register.setStuName(stuRemote.getStudentBySn(register.getStuId()).getName());
		Date now=new Date();
		register.setRegisterTime(now);
		return actReg.insertSelective(register);
	}



/*------------------------------------------添加---------------------------------------------------*/
	
	

/*------------------------------------------修改---------------------------------------------------*/
	//根据活动ID和学生学号修改签到状态
	@Override
	public int setRegStatusByActIdAndStuId(String actId, String stuId, Integer status) throws Exception {
		CspActRegister register=new CspActRegister();
		register.setActId(actId);
		register.setActName(assoAct.getActivityByActId(actId).getActivityName());
		register.setStuId(stuId);
		// TODO 获取学生姓名
//		register.setStuName(stuRemote.getStudentBySn(stuId).getName());
		register.setRegisterTime(new Date());
		register.setStatus(status);
		return actReg.updateByPrimaryKeySelective(register);
	}
/*------------------------------------------修改---------------------------------------------------*/
}
