package cn.second.lhj.apply.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.second.lhj.apply.mapper.ApplyMapperExtends;
import cn.second.lhj.apply.po.Apply;
import cn.second.lhj.apply.po.ApplyExample;
import cn.second.lhj.apply.service.ApplyService;
import cn.second.lhj.checkrecord.po.CheckRecord;
import cn.second.lhj.checkrecord.service.CheckRecordService;

@Service
public class ApplyServiceImpl implements ApplyService {
	
	@Autowired
	private ApplyMapperExtends applyMapper;
	
	@Autowired
	private CheckRecordService crService;
	
	/*-----------------------------------------查询---------------------------------------------*/
	@Override
	public int countApplyAll()throws Exception{
		// TODO 查询所有申请记录条数
		return applyMapper.countByExample(null);
	}
	@Override
	public List<Apply> getApplyAll() throws Exception {
		// TODO 查询所有申请记录
		return applyMapper.selectByExample(null);
	}

	@Override
	public List<Apply> getApplyAllLimit(int page,int count) throws Exception{
		// TODO 查询所有申请记录（分页）
		PageHelper.startPage(page,count);
		return applyMapper.selectByExample(null);
	}
	
	@Override
	public Apply getApplyById(Integer id) throws Exception {
		//TODO 根据ID查询申请记录
		return applyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Apply> getApplyByKind(Integer kindId) throws Exception {
		// TODO 根据申请种类查询申请记录
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andKindIdEqualTo(kindId);
		return applyMapper.selectByExample(example);
	}

	@Override
	public List<Apply> getApplyByKindLimit(Integer kindId,int page,int count)throws Exception{
		// TODO 根据申请种类查询申请记录（分页）
		PageHelper.startPage(page,count);
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andKindIdEqualTo(kindId);
		return applyMapper.selectByExample(example);
	}
	
	@Override
	public List<Apply> getApplyByStuId(String stuId) throws Exception {
		// TODO 根据学生学号查询申请记录
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		return applyMapper.selectByExample(example);
	}

	@Override
	public List<Apply> getApplyByStuIdLimit(String stuId,int page,int count)throws Exception{
		// TODO 根据学生学号查询申请记录（分页）
		PageHelper.startPage(page,count);
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		return applyMapper.selectByExample(example);
	}

	//根据学生学号以及审核状态查询申请记录
	@Override
	public List<Apply> getApplyByStuIdAndCheckStatus(String stuId, Integer checkStatus) throws Exception {
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		criteria.andCheckStatusEqualTo(checkStatus);
		return applyMapper.selectByExample(example);
	}
	//根据学生学号以及审核状态查询申请记录（分页）
	@Override
	public List<Apply> getApplyByStuIdAndCheckStatusLimit(String stuId, Integer checkStatus, int page, int count)
			throws Exception {
		PageHelper.startPage(page,count);
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andStuIdEqualTo(stuId);
		criteria.andCheckStatusEqualTo(checkStatus);
		return applyMapper.selectByExample(example);
	}
	
	@Override
	public List<Apply> getApplyByStatus(Integer status) throws Exception {
		// TODO 根据申请状态查询申请
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andCheckStatusEqualTo(status);
		return applyMapper.selectByExample(example);
	}
	
	@Override
	public List<Apply> getApplyByStatusLimit(Integer status,int page,int count)throws Exception{
		//根据申请状态查询申请（分页）
		PageHelper.startPage(page,count);
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andCheckStatusEqualTo(status);
		return applyMapper.selectByExample(example);
	}
	@Override
	public List<Apply> getApplyByCheckStatus(Integer checkStatus) throws Exception {
		// TODO 根据审核情况查询申请记录
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andCheckStatusEqualTo(checkStatus);
		return applyMapper.selectByExample(example);
	}

	@Override
	public List<Apply> getApplyByCheckStatusLimit(Integer checkStatus,int page,int count) throws Exception{
		// TODO 根据审核情况查询申请记录（分页）
		PageHelper.startPage(page,count);
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andCheckStatusEqualTo(checkStatus);
		return applyMapper.selectByExample(example);
	}
	
	@Override
	public List<Apply> getApplyByDoc(String doc) throws Exception {
		// TODO 根据是否有佐证材料查询申请记录(待定)
		return null;
	}

	@Override
	public List<Apply> getApplyByFile(String file) throws Exception {
		// TODO 根据是否有附件查询申请记录(待定)
		return null;
	}

	@Override
	public List<Apply> getApplyByIntegralLimit(Double integral,int page,int count) throws Exception {
		// TODO 根据积分查询申请记录
		PageHelper.startPage(page,count);
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andIntegralEqualTo(integral);
		return applyMapper.selectByExample(example);
	}
	
	@Override
	public List<Apply> getApplyByIntegral(Double integral) throws Exception {
		// TODO 根据积分查询申请记录（分页）
		ApplyExample example=new ApplyExample();
		ApplyExample.Criteria criteria=example.createCriteria();
		criteria.andIntegralEqualTo(integral);
		return applyMapper.selectByExample(example);
	}
	/*-----------------------------------------查询---------------------------------------------*/
	
	
	/*-----------------------------------------添加---------------------------------------------*/
	@Override
	public int insertApplyOne(Apply apply) throws Exception {
		// TODO 添加申请记录
		return applyMapper.insertSelective(apply);
	}
	/*-----------------------------------------添加---------------------------------------------*/

	/*-----------------------------------------删除---------------------------------------------*/
	@Override
	public int deleteApplyOneById(Integer id) throws Exception {
		// TODO 根据ID删除单条申请记录
		try {
			applyMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteApplyListById(List<Integer> idList) throws Exception {
		// TODO 根据ID批量删除申请记录
		try {
			for(Integer id:idList) {
				applyMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteApplyListByStuId(String stuId) throws Exception {
		// TODO 根据学生学号批量删除申请记录
		try {
			ApplyExample example=new ApplyExample();
			ApplyExample.Criteria criteria=example.createCriteria();
			criteria.andStuIdEqualTo(stuId);
			applyMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteApplyListByKind(Integer kindId) throws Exception {
		// TODO 根据申请分类批量删除申请记录
		try {
			ApplyExample example=new ApplyExample();
			ApplyExample.Criteria criteria=example.createCriteria();
			criteria.andKindIdEqualTo(kindId);
			applyMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//根据时间段查询已审核申请记录
	@Override
	public List<Apply> getApplyCheckedByDateBetween(Date startTime,Date endTime)throws Exception{
		List<CheckRecord> recordList=crService.getCheckRecordByDateBetween(startTime, endTime);
		List<Apply> applyList=new ArrayList();
		for(CheckRecord record:recordList) {
			Apply apply=applyMapper.selectByPrimaryKey(Integer.valueOf(record.getApplyId())); 
			applyList.add(apply);
		}
		return applyList;
	}
	/*-----------------------------------------删除---------------------------------------------*/

	/*-----------------------------------------修改---------------------------------------------*/
	@Override
	public int updateApplyOne(Apply apply) throws Exception {
		// TODO 修改单条申请记录
		try {
			Apply getApplyLast=applyMapper.selectByPrimaryKey(apply.getId());
//			System.out.println(getApplyLast.getCheckStatus());
//			System.out.println(apply.getCheckStatus());
			applyMapper.updateByPrimaryKeySelective(apply);
			if(getApplyLast.getCheckStatus()!=apply.getCheckStatus()) {
				CheckRecord record=new CheckRecord();
				record.setCheckStatus(apply.getCheckStatus());
				record.setApplyId(String.valueOf(apply.getId()));
				crService.addCheckRecordOne(record);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int checkApplyOneById(Integer id) throws Exception {
		//根据ID通过单条申请记录审核
		CheckRecord record=new CheckRecord();
		Apply apply=applyMapper.selectByPrimaryKey(id);
		//判断申请是否已通过
		if(apply.getCheckStatus()==1) {
			return 1;
		}else {
			apply.setCheckStatus(1);
		}
		//申请未通过则继续更新申请并添加审核记录
		try {
			record.setApplyId(String.valueOf(id));
			record.setCheckStatus(1);
			record.setCheckTime(new Date());
			// TODO 需要添加审核者ID及姓名
			updateApplyOne(apply);
			crService.addCheckRecordOne(record);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int checkApplyListById(List<Integer> idList) throws Exception {
		// TODO 根据ID批量通过审核
		try {
			for(Integer id:idList) {
				Apply apply=new Apply();
				apply.setId(id);
				apply.setCheckStatus(1);
				applyMapper.updateByPrimaryKeySelective(apply);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int checkApplyListByKind(Integer kindId) throws Exception {
		// TODO 根据申请种类批量通过申请
		try {
			applyMapper.checkApplyListByKind(1,kindId);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int checkApplyListByStuId(String stuId) throws Exception {
		// TODO 根据学生学号批量通过审核
		try {
			applyMapper.checkApplyListByStuId(1,stuId);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int checkApplyListByIntegral(Double integral) throws Exception {
		// TODO 根据积分批量通过审核
		try {
			applyMapper.checkApplyListByIntegral(1,integral);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int rejectApplyOneById(Integer id) throws Exception {
		// 根据ID驳回单条申请记录审核
		CheckRecord record=new CheckRecord();
		Apply apply=applyMapper.selectByPrimaryKey(id);
		//判断申请是否已驳回
		if(apply.getCheckStatus()==0) {
			return 1;
		}else {
			apply.setCheckStatus(0);
		}
		//申请未驳回则继续更新申请并添加审核记录
		try {
			record.setApplyId(String.valueOf(id));
			record.setCheckStatus(0);
			record.setCheckTime(new Date());
			// TODO 需要添加审核者ID及姓名
			updateApplyOne(apply);
			crService.addCheckRecordOne(record);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int rejectApplyListById(List<Integer> idList) throws Exception {
		// TODO 根据ID批量驳回申请
		try {
			for(Integer id:idList) {
				Apply apply=new Apply();
				apply.setId(id);
				apply.setCheckStatus(2);
				applyMapper.updateByPrimaryKeySelective(apply);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int rejectApplyListByKind(Integer kindId) throws Exception {
		// TODO 根据申请种类批量驳回申请
		try {
			applyMapper.checkApplyListByKind(2, kindId);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int rejectAppliListByStuId(String stuId) throws Exception {
		// TODO 根据学生学号批量驳回申请
		try {
			applyMapper.checkApplyListByStuId(2, stuId);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int rejectApplyListByIntegral(Double integral) throws Exception {
		// TODO 根据积分批量驳回申请
		try {
			applyMapper.checkApplyListByIntegral(2, integral);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int cancelApplyOneById(CheckRecord record) throws Exception {
		// TODO 根据ID取消单条申请记录
		Integer applyId=Integer.valueOf(record.getApplyId());
		try {
			Apply apply=new Apply();
			apply.setId(applyId);
			apply.setStatus(0);
			Apply getApplyLast=applyMapper.selectByPrimaryKey(applyId);
			applyMapper.updateByPrimaryKeySelective(apply);
			if(getApplyLast.getCheckStatus()!=0) {
				record.setCheckStatus(0);
				record.setApplyId(String.valueOf(apply.getId()));
				crService.addCheckRecordOne(record);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int cancelApplyLisyById(List<Integer> idList) throws Exception {
		// TODO 根据ID批量取消申请记录
		try {
			for(Integer id:idList) {
				Apply apply=new Apply();
				apply.setId(id);
				apply.setStatus(0);
				applyMapper.updateByPrimaryKeySelective(apply);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int cancelApplyListByStuId(String stuId) throws Exception {
		// TODO 根据学生学生批量取消申请记录
		try {
			applyMapper.updateStatusByStuId(0, stuId);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	/*-----------------------------------------修改---------------------------------------------*/

}
