package cn.second.lhj.applykind.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.second.lhj.applykind.po.ApplyKind;

/*
   *      积分、活动分类表
 * */

@Service
public interface ApplyKindService {
	
	
	/*-----------------------------------------查询---------------------------------------------*/
	//查询所有分类
	public List<ApplyKind> getApplyKindAll()throws Exception;
	//查询所有分类（分页）
	public List<ApplyKind> getApplyKindAllLimit(Integer page,Integer count)throws Exception;
	//根据ID查询分类
	public ApplyKind getApplyKindById(Integer id)throws Exception;
	//根据分类名称查询分类
	public List<ApplyKind> getApplyKindByName(String name)throws Exception;
	//根据分类名称查询分类（模糊）
	public List<ApplyKind> getApplyKindByNameLike(String keyWord)throws Exception;
	//根据上级分类ID查询分类
	public List<ApplyKind> getApplyKindByPid(Integer pId)throws Exception;
	//根据上级分类ID查询分类（分页）
	public List<ApplyKind> getApplyKindByPidLimit(Integer pId,Integer page,Integer count)throws Exception;
	//根据启用状态查询分类
	public List<ApplyKind> getApplyKindByStatus(Integer status) throws Exception;
	//根据启用状态查询分类（分页）
	public List<ApplyKind> getApplyKindByStatusLimit(Integer status,Integer page,Integer count) throws Exception;
	//查询已启用分类
	public List<ApplyKind> getApplyKindStatusOn() throws Exception;
	//查询已启用分类（分页）
	public List<ApplyKind> getApplyKindStatusOnLimit(Integer page,Integer count) throws Exception;
	//查询未启用分类
	public List<ApplyKind> getApplyKindStatusOff() throws Exception;
	//查询未启用分类（分页）
	public List<ApplyKind> getApplyKindStatusOffLimit(Integer page,Integer count) throws Exception;
	//根据分类积分查询分类
	public List<ApplyKind> getApplyKindByIntegral(Double integral)throws Exception;
	//根据分类积分查询分类（分页）
	public List<ApplyKind> getApplyKindByIntegralLimit(Double integral,Integer page,Integer count)throws Exception;
	//根据是否需要佐证材料查询分类
	public List<ApplyKind> getApplyKindByDocStatus(Integer docStatus)throws Exception;
	//根据是否需要佐证材料查询分类（分页）
	public List<ApplyKind> getApplyKindByDocStatusLimit(Integer docStatus,Integer page,Integer count)throws Exception;
	//根据是否需要文件查询分类
	public List<ApplyKind> getApplyKindByFileStatus(Integer fileStatus) throws Exception;
	//根据是否需要文件查询分类（分页）
	public List<ApplyKind> getApplyKindByFileStatusLimit(Integer fileStatus,Integer page,Integer count) throws Exception;
	//根据是否需要审核查询分类
	public List<ApplyKind> getApplyKindByCheckStatus(Integer checkStatus)throws Exception;
	//根据是否需要审核查询分类（分页）
	public List<ApplyKind> getApplyKindByCheckStatusLimit(Integer checkStatus,Integer page,Integer count)throws Exception;
	//根据审核方式查询分类
	public List<ApplyKind> getApplyKindByCheckKind(Integer checkKind)throws Exception;
	//根据审核方式查询分类（分页）
	public List<ApplyKind> getApplyKindByCheckKindLimit(Integer checkKind,Integer page,Integer count)throws Exception;
	/*-----------------------------------------查询---------------------------------------------*/
	
	
	/*-----------------------------------------添加---------------------------------------------*/
	//添加单个分类
	public int insertApplyKindOne(ApplyKind applyKind)throws Exception;
	/*-----------------------------------------添加---------------------------------------------*/	
	
	
	/*-----------------------------------------修改---------------------------------------------*/
	//修改单个分类
	public int updateApplyKindOne(ApplyKind applyKind)throws Exception;
	//启用分类
	public int setApplyKindStatusOn(Integer id) throws Exception;
	//禁用分类
	public int setApplyKindStatusOff(Integer id) throws Exception;
	//启用佐证材料
	public int setApplyKindDocOn(Integer id) throws Exception;
	//禁用佐证材料
	public int setApplyKindDocOff(Integer id) throws Exception;
	//启用证明文件
	public int setApplyKindFileOn(Integer id) throws Exception;
	//禁用证明文件
	public int setApplyKindFileOff(Integer id) throws Exception;
	//启用审核
	public int setApplyKindCheckOn(Integer id) throws Exception;
	//禁用审核
	public int setApplyKindCheckOff(Integer id) throws Exception;
	//启用手动审核
	public int setApplyKindCheckManual(Integer id) throws Exception;
	//启用自动审核
	public int setApplyKindCheckAuto(Integer id) throws Exception;
	
	/*-----------------------------------------修改---------------------------------------------*/	
	
	
	/*-----------------------------------------删除---------------------------------------------*/	
	//根据ID删除单个分类
	public int delApplyKindOneById(Integer id)throws Exception;
	//根据ID批量删除分类
	public int delApplyKindListById(List<Integer> idList) throws Exception;
	//根据上级分类ID批量删除分类
	public int delAppliKindListByPid(Integer pId) throws Exception;
	//根据分类积分批量删除分类
	public int delApplyKindListByIntegral(Double Integral) throws Exception;
	//根据是否需要佐证材料批量删除分类
	public int delApplyKindListByDocStatus(Integer docStatus) throws Exception;
	//根据是否需要证明文件批量删除分类
	public int delApplyKindListByFileStatus(Integer fileStatus) throws Exception;
	//根据是否需要审核批量删除分类
	public int delApplyKindListByCheckStatus(Integer checkStatus) throws Exception;
	//根据审核方式批量删除分类
	public int delApplyKindListByCheckKind(Integer checkKind) throws Exception;
	/*-----------------------------------------删除---------------------------------------------*/	
}
