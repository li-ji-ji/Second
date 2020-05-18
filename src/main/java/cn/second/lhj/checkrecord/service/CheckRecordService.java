package cn.second.lhj.checkrecord.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.second.lhj.checkrecord.po.CheckRecord;

@Service
public interface CheckRecordService {

/*-----------------------------------------查询---------------------------------------------*/
	//查询所有审核记录
	public List<CheckRecord> getCheckRecordAll()throws Exception;
	//根据ID查询审核记录
	public CheckRecord getCheckRecordById(Integer id) throws Exception;
	//根据申请书编号查询审核记录
	public List<CheckRecord> getCheckRecordByApplyId(String applyId) throws Exception;
	//根据审核者ID查询申请记录
	public List<CheckRecord> getCheckRecordByCheckerId(String checkerId) throws Exception;
	//根据时间段查询申请记录
	public List<CheckRecord> getCheckRecordByDateBetween(Date startTime,Date endTime) throws Exception;
	
/*-----------------------------------------查询---------------------------------------------*/

/*-----------------------------------------添加--------------------------------------------*/
	//添加单条审核记录
	public int addCheckRecordOne(CheckRecord record)throws Exception;
/*-----------------------------------------添加---------------------------------------------*/

/*-----------------------------------------修改---------------------------------------------*/
	//修改单条审核记录
	public int setCheckRocordOne(CheckRecord record) throws Exception;
/*-----------------------------------------修改---------------------------------------------*/

/*-----------------------------------------删除---------------------------------------------*/
	//根据ID删除单条修改记录
	public int delCheckRecordOneById(Integer id)throws Exception;
/*-----------------------------------------删除---------------------------------------------*/
}
