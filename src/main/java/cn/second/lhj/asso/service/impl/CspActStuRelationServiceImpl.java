package cn.second.lhj.asso.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.second.lhj.asso.mapper.extend.ActStuRelationMapper;
import cn.second.lhj.asso.po.CspActStuRelation;
import cn.second.lhj.asso.po.CspActStuRelationExample;
import cn.second.lhj.asso.po.CspAssoActivity;
import cn.second.lhj.asso.service.CspActStuRelationService;
import cn.second.lhj.asso.service.CspAssoActivityService;
import cn.second.lhj.asso.service.CspAssoManagementService;
import cn.second.lhj.util.DateUtils;
@Service
public class CspActStuRelationServiceImpl implements CspActStuRelationService {

	@Autowired
	private ActStuRelationMapper actStuMapper;
	@Autowired
	private CspAssoActivityService assoAct;
	@Autowired
	private CspAssoManagementService assoManage;
	// TODO 调用学生接口
//	@Autowired
//	private StudentRemote stuRemote;
	
	//查询所有关系条数
	@Override
	public int countRelationAll() throws Exception {
		return actStuMapper.countByExample(null);
	}

	//根据活动编号查询关系条数
	@Override
	public int countRelationByActId(String actId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		return actStuMapper.countByExample(example);
	}

	//根据学生学号查询关系条数
	@Override
	public int countRelationByStuId(String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		return actStuMapper.countByExample(example);
	}
	
	//查询所有活动与学生关系
	@Override
	public List<CspActStuRelation> getActStuRelationAll() throws Exception {
		return actStuMapper.selectByExample(null);
	}

	//查询所有活动与学生关系（分页）
	@Override
	public List<CspActStuRelation> getActStuRelationAllLimit(Integer page, Integer count) throws Exception {
		PageHelper.startPage(page,count);
		return actStuMapper.selectByExample(null);
	}

	//根据ID查询活动与学生关系
	@Override
	public CspActStuRelation getActStuRelationById(Integer id) throws Exception {
		return actStuMapper.selectByPrimaryKey(id);
	}

	//根据活动ID查询所有活动与学生关系
	@Override
	public List<CspActStuRelation> getActStuRelationByActId(String actId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		return actStuMapper.selectByExample(example);
	}

	//根据活动ID查询所有活动与学生关系（分页）
	@Override
	public List<CspActStuRelation> getActStuRelationByActIdLimit(String actId, Integer page, Integer count)
			throws Exception {
		PageHelper.startPage(page,count);
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		return actStuMapper.selectByExample(example);
	}
	
	//根据学生ID查询所有活动与学生关系
	@Override
	public List<CspActStuRelation> getActStuRelationByStuId(String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		return actStuMapper.selectByExample(example);
	}

	//根据学生ID查询所有活动与学生关系（分页）
	@Override
	public List<CspActStuRelation> getActStuRelationByStuIdLimit(String stuId, Integer page, Integer count)
			throws Exception {
		PageHelper.startPage(page,count);
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		return actStuMapper.selectByExample(example);
	}
	
	//根据学生学号和活动编号查询所有关系
	@Override
	public List<CspActStuRelation> getActStuRelationByActIdAndStuId(String actId, String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		criteria.andStuIdEqualTo(stuId);
		return actStuMapper.selectByExample(example);
	}
	//根据学生学号和活动编号和状态查询关系
	@Override
	public List<CspActStuRelation> getActStuRelationByActIdAndStuIdAndStatus(String actId, String stuId, Integer Status)
			throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andActIdEqualTo(actId);
		criteria.andStuIdEqualTo(stuId);
		criteria.andStatusEqualTo(Status);
		return actStuMapper.selectByExample(example);
	}
	//根据学生学号查询已报名未开始记录
	@Override
	public List<CspActStuRelation> getActStuRelationSignedByStuId(String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		List<CspActStuRelation> getRelations=actStuMapper.selectByExample(example);
		List<CspActStuRelation> relations=new ArrayList();
		Date now=new Date();
		if(getRelations.size()>0) {
			for(CspActStuRelation relation:getRelations) {
				if(assoAct.getActivityByActId(relation.getActId()).getActivityStartTime().after(now)&&relation.getStatus()==1) {
					relations.add(relation);
				}
			}
		}
		return relations;
	}
	//根据学生学号查询已报名已开始未结束记录
	@Override
	public List<CspActStuRelation> getActStuRelationStartedByStuId(String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		List<CspActStuRelation> getRelations=actStuMapper.selectByExample(example);
		List<CspActStuRelation> relations=new ArrayList();
		Date now=new Date();
		if(getRelations.size()>0) {
			for(CspActStuRelation relation:getRelations) {
				if(assoAct.getActivityByActId(relation.getActId()).getActivityStartTime().before(now)&&assoAct.getActivityByActId(relation.getActId()).getActivityFinishTime().after(now)&&relation.getStatus()==1) {
					relations.add(relation);
				}
			}
		}
		return relations;
	}
	//根据学生学号查询已报名已结束记录
	@Override
	public List<CspActStuRelation> getActStuRelationFinishedByStuId(String stuId) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		List<CspActStuRelation> getRelations=actStuMapper.selectByExample(example);
		List<CspActStuRelation> relations=new ArrayList();
		Date now=new Date();
		if(getRelations.size()>0) {
			for(CspActStuRelation relation:getRelations) {
				if(assoAct.getActivityByActId(relation.getActId()).getActivityFinishTime().before(now)&&relation.getStatus()==1) {
					relations.add(relation);
				}
			}
		}
		return relations;
	}
	//添加单条活动与学生关系
	@Override
	public int addActStuRelationOne(CspActStuRelation relation) throws Exception {
		CspAssoActivity act=assoAct.getActivityByActId(relation.getActId()); // 查询活动
		// 判断活动报名人数是否已满
		if(act.getActivityNum()>act.getActivityPartNum()) {
			act.setActivityPartNum(act.getActivityPartNum()+1);
			//System.out.println("参加人数："+act.getActivityPartNum());
			assoAct.updateActivityOne(act);
		}
		else {
			return 0;
		}
		relation.setActName(act.getActivityName());
		// 查询报名记录是否存在
		List<CspActStuRelation> getRelation=getActStuRelationByActIdAndStuId(relation.getActId(),relation.getStuId()); 
		if(getRelation.size()==0) { // 报名记录不存在，添加报名记录
			Date now=new Date(); // 获取当前时间作为报名时间
			relation.setSignTime(now);
			actStuMapper.insertSelective(relation);
			return 1;
		}else if(getRelation.get(0).getStatus()==0){ // 报名记录存在，更改报名记录状态
			getRelation.get(0).setStatus(1);
			Date now=new Date();
			getRelation.get(0).setSignTime(now);
			actStuMapper.updateByPrimaryKeySelective(getRelation.get(0));
			return 1;
		}
		return 0;
	}

	//根据ID删除单条活动与学生关系
	@Override
	public int delActStuRelationOneById(Integer id) throws Exception {
		try {
			actStuMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据ID批量删除活动与学生关系
	@Override
	public int delActStuRelationListById(List<Integer> idList) throws Exception {
		try {
			for(Integer id:idList) {
				actStuMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//修改单条活动与学生关系
	@Override
	public int setActStuRelationOne(CspActStuRelation relation) throws Exception {
		try {
			actStuMapper.updateByPrimaryKeySelective(relation);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//修改单条活动与学生关系状态
	@Override
	public int setActStuRelationOneStatus(String actId, String stuId, Integer status) throws Exception {
		CspActStuRelation relation=getActStuRelationByActIdAndStuId(actId, stuId).get(0);
		relation.setStatus(status);
		return actStuMapper.updateByPrimaryKeySelective(relation);
	}

	//修改单条活动与学生关系状态为取消
	@Override
	public int setActStuRelationOneStatusCancel(String actId, String stuId) throws Exception {
		CspActStuRelation relation=getActStuRelationByActIdAndStuId(actId, stuId).get(0);
		relation.setStatus(0);
		CspAssoActivity act=assoAct.getActivityByActId(relation.getActId());
		if(actStuMapper.updateByPrimaryKeySelective(relation)==1) {
			if(act.getActivityPartNum()<=act.getActivityNum()&&act.getActivityPartNum()>0) {
				act.setActivityPartNum(act.getActivityPartNum()-1);
				return assoAct.updateActivityOne(act);
			}
		}
		return 0;
	}

	//根据时间查询已报名记录
	@Override
	public List<CspActStuRelation> getActStuRelationEnableByTime(Date begin, Date end) throws Exception {
		CspActStuRelationExample example=new CspActStuRelationExample();
		CspActStuRelationExample.Criteria criteria=example.createCriteria();
		criteria.andSignTimeLessThanOrEqualTo(begin);
		criteria.andSignTimeGreaterThanOrEqualTo(end);
		criteria.andStatusEqualTo(1);
		return actStuMapper.selectByExample(example);
	}

	//获取参加情况
	@Override
	public Map<String, Object> getActJoin() throws Exception{
		Date today = new Date();
		Map<String, Object> getActJoin = new HashMap<>();
		List<Integer> datas = new ArrayList<Integer>();
		List<String> labels = new ArrayList<String>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<=6;i++) {
			List<CspActStuRelation> relas  = getActStuRelationEnableByTime(today,DateUtils.yesterday(today));
			today=DateUtils.yesterday(today);
			labels.add(formatter.format(today));
			datas.add(relas.size());
//			System.out.println(getActJoin);
		}
		getActJoin.put("datas", datas);
		getActJoin.put("labels", labels);
		return getActJoin;
	}












}
