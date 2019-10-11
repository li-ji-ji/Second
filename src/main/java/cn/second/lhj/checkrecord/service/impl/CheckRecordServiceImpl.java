package cn.second.lhj.checkrecord.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.second.lhj.checkrecord.mapper.CheckRecordMapperExtends;
import cn.second.lhj.checkrecord.po.CheckRecord;
import cn.second.lhj.checkrecord.po.CheckRecordExample;
import cn.second.lhj.checkrecord.service.CheckRecordService;

@Service
public class CheckRecordServiceImpl implements CheckRecordService {

	@Autowired
	private CheckRecordMapperExtends crMapper;
	
	
/*-----------------------------------------查询---------------------------------------------*/
	//查询所有审核记录
	@Override
	public List<CheckRecord> getCheckRecordAll() throws Exception {
		return crMapper.selectByExample(null);
	}

	//根据ID查询审核记录
	@Override
	public CheckRecord getCheckRecordById(Integer id) throws Exception {
		return crMapper.selectByPrimaryKey(id);
	}
	//根据申请书编号查询审核记录
	@Override
	public List<CheckRecord> getCheckRecordByApplyId(String applyId) throws Exception {
		CheckRecordExample example=new CheckRecordExample();
		CheckRecordExample.Criteria criteria=example.createCriteria();
		criteria.andApplyIdEqualTo(applyId);
		return crMapper.selectByExample(example);
	}
	//根据审核者ID查询申请记录
	@Override
	public List<CheckRecord> getCheckRecordByCheckerId(String checkerId) throws Exception {
		CheckRecordExample example=new CheckRecordExample();
		CheckRecordExample.Criteria criteria=example.createCriteria();
		criteria.andCheckerIdEqualTo(checkerId);
		return crMapper.selectByExample(example);
	}
	//根据时间段查询申请记录
	@Override
	public List<CheckRecord> getCheckRecordByDateBetween(Date startTime, Date endTime) throws Exception {
		CheckRecordExample example=new CheckRecordExample();
		CheckRecordExample.Criteria criteria=example.createCriteria();
		criteria.andCheckTimeBetween(startTime, endTime);
		return crMapper.selectByExample(example);
	}

/*-----------------------------------------查询---------------------------------------------*/

/*-----------------------------------------添加--------------------------------------------*/
	//添加单条修改记录
	@Override
	public int addCheckRecordOne(CheckRecord record)throws Exception{
		record.setCheckTime(new Date());
		return crMapper.insertSelective(record);
	}
/*-----------------------------------------添加---------------------------------------------*/

/*-----------------------------------------修改---------------------------------------------*/
	//修改单条审核记录
	@Override
	public int setCheckRocordOne(CheckRecord record) throws Exception{
		record.setCheckTime(new Date());
		return crMapper.updateByPrimaryKeySelective(record);
	}
/*-----------------------------------------修改---------------------------------------------*/

/*-----------------------------------------删除---------------------------------------------*/
	//根据ID删除单条修改记录
	@Override
	public int delCheckRecordOneById(Integer id)throws Exception{
		return crMapper.deleteByPrimaryKey(id);
	}
/*-----------------------------------------删除---------------------------------------------*/
}
