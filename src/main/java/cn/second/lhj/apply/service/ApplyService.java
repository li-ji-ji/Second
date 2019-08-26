package cn.second.lhj.apply.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.second.lhj.apply.po.Apply;

/*
    *          积分申请表
 * */

@Service
public interface ApplyService {
	
	/*-----------------------------------------查询---------------------------------------------*/
	//查询所有申请记录条数
	public int countApplyAll()throws Exception;
	//查询所有申请记录
	public List<Apply> getApplyAll() throws Exception;
	//查询所有申请记录（分页）
	public List<Apply> getApplyAllLimit(int page,int count) throws Exception;
	//根据ID查询申请记录
	public Apply getApplyById(Integer id) throws Exception;
	//根据申请种类查询申请记录
	public List<Apply> getApplyByKind(Integer kindId)throws Exception;
	//根据申请种类查询申请记录（分页）
	public List<Apply> getApplyByKindLimit(Integer kindId,int page,int count)throws Exception;
	//根据学生学号查询申请记录
	public List<Apply> getApplyByStuId(String stuId)throws Exception;
	//根据学生学号查询申请记录（分页）
	public List<Apply> getApplyByStuIdLimit(String stuId,int page,int count)throws Exception;
	//根据学生学号以及审核状态查询申请记录
	public List<Apply> getApplyByStuIdAndCheckStatus(String stuId,Integer checkStatus)throws Exception;
	//根据学生学号以及审核状态查询申请记录（分页）
	public List<Apply> getApplyByStuIdAndCheckStatusLimit(String stuId,Integer checkStatus,int page,int count)throws Exception;
	//根据申请状态查询申请
	public List<Apply> getApplyByStatus(Integer status)throws Exception;
	//根据申请状态查询申请（分页）
	public List<Apply> getApplyByStatusLimit(Integer status,int page,int count)throws Exception;
	//根据审核情况查询申请记录
	public List<Apply> getApplyByCheckStatus(Integer checkStatus) throws Exception;
	//根据审核情况查询申请记录（分页）
	public List<Apply> getApplyByCheckStatusLimit(Integer checkStatus,int page,int count) throws Exception;
	//根据是否有佐证材料查询申请记录
	public List<Apply> getApplyByDoc(String doc) throws Exception;
	//根据是否有附件查询申请记录
	public List<Apply> getApplyByFile(String file) throws Exception;
	//根据积分查询申请记录
	public List<Apply> getApplyByIntegral(Double integral) throws Exception;
	//根据积分查询申请记录（分页）
	public List<Apply> getApplyByIntegralLimit(Double integral,int page,int count) throws Exception;
	/*-----------------------------------------查询---------------------------------------------*/
	
	
	/*-----------------------------------------添加---------------------------------------------*/
	//添加申请记录
	public int insertApplyOne(Apply apply) throws Exception;
	/*-----------------------------------------添加---------------------------------------------*/
	

	/*-----------------------------------------删除---------------------------------------------*/
	//根据ID删除单条申请记录
	public int deleteApplyOneById(Integer id) throws Exception;
	//根据ID批量删除申请记录
	public int deleteApplyListById(List<Integer> idList) throws Exception;
	//根据学生学号批量删除申请记录
	public int deleteApplyListByStuId(String stuId) throws Exception;
	//根据申请分类批量删除申请记录
	public int deleteApplyListByKind(Integer kindId) throws Exception;
	/*-----------------------------------------删除---------------------------------------------*/
	
	

	/*-----------------------------------------修改---------------------------------------------*/
	//修改单条申请记录
	public int updateApplyOne(Apply apply) throws Exception;
	//根据ID通过单条申请记录审核
	public int checkApplyOneById(Integer id)throws Exception;
	//根据ID批量通过审核
	public int checkApplyListById(List<Integer> idList) throws Exception;
	//根据申请种类批量通过申请
	public int checkApplyListByKind(Integer kindId)throws Exception;
	//根据学生学号批量通过审核
	public int checkApplyListByStuId(String stuId) throws Exception;
	//根据积分批量通过审核
	public int checkApplyListByIntegral(Double integral) throws Exception;
	//根据ID驳回单条申请记录
	public int rejectApplyOneById(Integer id) throws Exception;
	//根据ID批量驳回申请
	public int rejectApplyListById(List<Integer> idList)throws Exception;
	//根据申请种类批量驳回申请
	public int rejectApplyListByKind(Integer kindId)throws Exception;
	//根据学生学号批量驳回申请
	public int rejectAppliListByStuId(String stuId)throws Exception;
	//根据积分批量驳回申请
	public int rejectApplyListByIntegral(Double integral)throws Exception;
	
	//根据ID取消单条申请记录
	public int cancelApplyOneById(Integer id)throws Exception;
	//根据ID批量取消申请记录
	public int cancelApplyLisyById(List<Integer> idList)throws Exception;
	//根据学生学生批量取消申请记录
	public int cancelApplyListByStuId(String stuId)throws Exception;
	/*-----------------------------------------修改---------------------------------------------*/
	
	
}
