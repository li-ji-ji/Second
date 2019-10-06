package cn.second.lhj.apply.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.second.lhj.apply.po.Apply;
import cn.second.lhj.apply.po.ApplyKind;


@FeignClient(name="second-apply")
public interface ApplyFeignInterface {

/*============================================积分申请表 =========================================== */	
	/*-----------------------------------------查询---------------------------------------------*/
	//查询所有申请记录条数
	@RequestMapping("/countApplyAll")
	public int countApplyAll()throws Exception;
	//查询所有申请记录
	@RequestMapping("/getApplyAll")
	public List<Apply> getApplyAll() throws Exception;
	//查询所有申请记录（分页）
	@RequestMapping("/getApplyAllLimit")
	public List<Apply> getApplyAllLimit(@RequestParam("page")int page,@RequestParam("count")int count) throws Exception;
	//根据ID查询申请记录
	@RequestMapping("/getApplyById")
	public Apply getApplyById(@RequestParam("id")Integer id) throws Exception;
	//根据申请种类查询申请记录
	@RequestMapping("/getApplyByKind")
	public List<Apply> getApplyByKind(@RequestParam("kindId")Integer kindId)throws Exception;
	//根据申请种类查询申请记录（分页）
	@RequestMapping("/getApplyByKindLimit")
	public List<Apply> getApplyByKindLimit(@RequestParam("kindId")Integer kindId,@RequestParam("page")int page,@RequestParam("count")int count)throws Exception;
	//根据学生学号查询申请记录
	@RequestMapping("/getApplyByStuId")
	public List<Apply> getApplyByStuId(@RequestParam("stuId")String stuId)throws Exception;
	//根据学生学号查询申请记录（分页）
	@RequestMapping("/getApplyByStuIdLimit")
	public List<Apply> getApplyByStuIdLimit(@RequestParam("stuId")String stuId,@RequestParam("page")int page,@RequestParam("count")int count)throws Exception;
	//根据申请状态查询申请
	@RequestMapping("/getApplyByStatus")
	public List<Apply> getApplyByStatus(@RequestParam("status")Integer status)throws Exception;
	//根据申请状态查询申请（分页）
	@RequestMapping("/getApplyByStatusLimit")
	public List<Apply> getApplyByStatusLimit(@RequestParam("status")Integer status,@RequestParam("page")int page,@RequestParam("count")int count)throws Exception;
	//根据审核情况查询申请记录
	@RequestMapping("/getApplyByCheckStatus")
	public List<Apply> getApplyByCheckStatus(@RequestParam("checkStatus")Integer checkStatus) throws Exception;
	//根据审核情况查询申请记录（分页）
	@RequestMapping("/getApplyByCheckStatusLimit")
	public List<Apply> getApplyByCheckStatusLimit(@RequestParam("checkStatus")Integer checkStatus,@RequestParam("page")int page,@RequestParam("count")int count) throws Exception;
	//根据是否有佐证材料查询申请记录
	@RequestMapping("/getApplyByDoc")
	public List<Apply> getApplyByDoc(@RequestParam("doc")String doc) throws Exception;
	//根据是否有附件查询申请记录
	@RequestMapping("/getApplyByFile")
	public List<Apply> getApplyByFile(@RequestParam("file")String file) throws Exception;
	//根据积分查询申请记录
	@RequestMapping("/getApplyByIntegral")
	public List<Apply> getApplyByIntegral(@RequestParam("integral")Double integral) throws Exception;
	//根据积分查询申请记录（分页）
	@RequestMapping("/getApplyByIntegralLimit")
	public List<Apply> getApplyByIntegralLimit(@RequestParam("integral")Double integral,@RequestParam("page")int page,@RequestParam("count")int count) throws Exception;
	/*-----------------------------------------查询---------------------------------------------*/
	
	
	/*-----------------------------------------添加---------------------------------------------*/
	//添加申请记录
	@RequestMapping("/insertApplyOne")
	public int insertApplyOne(@RequestBody Apply apply) throws Exception;
	/*-----------------------------------------添加---------------------------------------------*/
	

	/*-----------------------------------------删除---------------------------------------------*/
	//根据ID删除单条申请记录
	@RequestMapping("/deleteApplyOneById")
	public int deleteApplyOneById(@RequestParam("id")Integer id) throws Exception;
	//根据ID批量删除申请记录
	@RequestMapping("/deleteApplyListById")
	public int deleteApplyListById(@RequestParam("idList")List<Integer> idList) throws Exception;
	//根据学生学号批量删除申请记录
	@RequestMapping("/deleteApplyListByStuId")
	public int deleteApplyListByStuId(@RequestParam("stuId")String stuId) throws Exception;
	//根据申请分类批量删除申请记录
	@RequestMapping("/deleteApplyListByKind")
	public int deleteApplyListByKind(@RequestParam("kindId")Integer kindId) throws Exception;
	/*-----------------------------------------删除---------------------------------------------*/
	
	

	/*-----------------------------------------修改---------------------------------------------*/
	//修改单条申请记录
	@RequestMapping("/updateApplyOne")
	public int updateApplyOne(@RequestBody Apply apply) throws Exception;
	//根据ID通过单条申请记录审核
	@RequestMapping("/checkApplyOneById")
	public int checkApplyOneById(@RequestParam("id")Integer id)throws Exception;
	//根据ID批量通过审核
	@RequestMapping("/checkApplyListById")
	public int checkApplyListById(@RequestParam("idList")List<Integer> idList) throws Exception;
	//根据申请种类批量通过申请
	@RequestMapping("/checkApplyListByKind")
	public int checkApplyListByKind(@RequestParam("kindId")Integer kindId)throws Exception;
	//根据学生学号批量通过审核
	@RequestMapping("/checkApplyListByStuId")
	public int checkApplyListByStuId(@RequestParam("stuId")String stuId) throws Exception;
	//根据积分批量通过审核
	@RequestMapping("/checkApplyListByIntegral")
	public int checkApplyListByIntegral(@RequestParam("integral")Double integral) throws Exception;
	//根据ID驳回单条申请记录
	@RequestMapping("/rejectApplyOneById")
	public int rejectApplyOneById(@RequestParam("id")Integer id) throws Exception;
	//根据ID批量驳回申请
	@RequestMapping("/rejectApplyListById")
	public int rejectApplyListById(@RequestParam("idList")List<Integer> idList)throws Exception;
	//根据申请种类批量驳回申请
	@RequestMapping("/rejectApplyListByKind")
	public int rejectApplyListByKind(@RequestParam("kindId")Integer kindId)throws Exception;
	//根据学生学号批量驳回申请
	@RequestMapping("/rejectAppliListByStuId")
	public int rejectAppliListByStuId(@RequestParam("stuId")String stuId)throws Exception;
	//根据积分批量驳回申请
	@RequestMapping("/rejectApplyListByIntegral")
	public int rejectApplyListByIntegral(@RequestParam("integral")Double integral)throws Exception;
	//根据ID取消单条申请记录
	@RequestMapping("/cancelApplyOneById")
	public int cancelApplyOneById(@RequestParam("id")Integer id)throws Exception;
	//根据ID批量取消申请记录
	@RequestMapping("/cancelApplyLisyById")
	public int cancelApplyLisyById(@RequestParam("idList")List<Integer> idList)throws Exception;
	//根据学生学生批量取消申请记录
	@RequestMapping("/cancelApplyListByStuId")
	public int cancelApplyListByStuId(@RequestParam("stuId")String stuId)throws Exception;
	/*-----------------------------------------修改---------------------------------------------*/
	
/*============================================积分申请表 =========================================== */	
	
	
	
/*============================================活动/积分分类表 =========================================== */
	/*-----------------------------------------查询---------------------------------------------*/
	// TODO 查询所有分类
    @RequestMapping("/countApplyKindAll")
	public int countApplyKindAll() throws Exception;
    
	// TODO 查询所有分类
    @RequestMapping("/getApplyKindAll")
	public List<ApplyKind> getApplyKindAll() throws Exception;

	// TODO 查询所有分类（分页）
    @RequestMapping("/getApplyKindAllLimit")
	public List<ApplyKind> getApplyKindAllLimit(@RequestParam("page") Integer page,
			@RequestParam("count") Integer count) throws Exception;
    // TODO 查询一二级分类
    @RequestMapping("/getApplyKindFirstAndSecond")
	public List<ApplyKind> getApplyKindFirstAndSecond()throws Exception;
	// TODO 根据ID查询分类
    @RequestMapping("/getApplyKindById")
	public ApplyKind getApplyKindById(@RequestParam("id") Integer id) throws Exception;

	// TODO 根据分类名称查询分类
    @RequestMapping("/getApplyKindByName")
	public List<ApplyKind> getApplyKindByName(@RequestParam("name") String name) throws Exception;
    
	// TODO 根据分类等级查询分类
    @RequestMapping("/getApplyKindByKindLevel")
	public List<ApplyKind> getApplyKindByKindLevel(@RequestParam("level")Integer level)throws Exception;

	// TODO 根据分类等级查询分类（分页）
    @RequestMapping("/getApplyKindByKindLevelLimit")
	public List<ApplyKind> getApplyKindByKindLevelLimit(@RequestParam("level")Integer level,@RequestParam("page")Integer page,@RequestParam("count")Integer count)throws Exception;


	// TODO 根据是否需要举办活动查询分类
    @RequestMapping("/getApplyKindByHasAct")
	public List<ApplyKind> getApplyKindByHasAct(@RequestParam("hasAct")Integer hasAct)throws Exception;

	//根据是否需要举办活动查询分类（分页）
    @RequestMapping("/getApplyKindByHasActLimit")
	public List<ApplyKind> getApplyKindByHasActLimit(@RequestParam("hasAct")Integer hasAct,@RequestParam("page")Integer page,@RequestParam("count")Integer count)throws Exception;
	
	// TODO 根据分类名称查询分类（模糊）
    @RequestMapping("/getApplyKindByNameLike")
	public List<ApplyKind> getApplyKindByNameLike(@RequestParam("keyWord") String keyWord) throws Exception;

	// TODO 根据上级分类ID查询分类
    @RequestMapping("/getApplyKindByPid")
	public List<ApplyKind> getApplyKindByPid(@RequestParam("pId") Integer pId) throws Exception;

	// 根据上级分类ID查询分类（分页）
    @RequestMapping("/getApplyKindByPidLimit")
	public List<ApplyKind> getApplyKindByPidLimit(@RequestParam("pId") Integer pId, @RequestParam("page") Integer page,
			@RequestParam("count") Integer count) throws Exception;
    
	// TODO 根据启用状态查询分类
    @RequestMapping("/getApplyKindByStatus")
	public List<ApplyKind> getApplyKindByStatus(@RequestParam("status") Integer status) throws Exception;

	// TODO 根据启用状态查询分类（分页）
    @RequestMapping("/getApplyKindByStatusLimit")
	public List<ApplyKind> getApplyKindByStatusLimit(@RequestParam("status") Integer status,
			@RequestParam("page") Integer page, @RequestParam("count") Integer count) throws Exception;

	// TODO 查询已启用分类
    @RequestMapping("/getApplyKindStatusOn")
	public List<ApplyKind> getApplyKindStatusOn() throws Exception;

	// TODO 查询已启用分类（分页）
    @RequestMapping("/getApplyKindStatusOnLimit")
	public List<ApplyKind> getApplyKindStatusOnLimit(@RequestParam("page") Integer page,
			@RequestParam("count") Integer count) throws Exception;

	// TODO 查询未启用分类
    @RequestMapping("/getApplyKindStatusOff")
	public List<ApplyKind> getApplyKindStatusOff() throws Exception;
    
	// TODO 查询未启用分类（分页）
    @RequestMapping("/getApplyKindStatusOffLimit")
	public List<ApplyKind> getApplyKindStatusOffLimit(@RequestParam("page") Integer page,
			@RequestParam("count") Integer count) throws Exception;

	// TODO 根据分类积分查询分类
    @RequestMapping("/getApplyKindByIntegral")
	public List<ApplyKind> getApplyKindByIntegral(@RequestParam("integral") Double integral) throws Exception;

	// TODO 根据分类积分查询分类（分页）
    @RequestMapping("/getApplyKindByIntegralLimit")
	public List<ApplyKind> getApplyKindByIntegralLimit(@RequestParam("integral") Double integral,
			@RequestParam("page") Integer page, @RequestParam("count") Integer count) throws Exception;

	// TODO 根据是否需要佐证材料查询分类
    @RequestMapping("/getApplyKindByDocStatus")
	public List<ApplyKind> getApplyKindByDocStatus(@RequestParam("docStatus") Integer docStatus) throws Exception;

	// TODO 根据是否需要佐证材料查询分类（分页）
    @RequestMapping("/getApplyKindByDocStatusLimit")
	public List<ApplyKind> getApplyKindByDocStatusLimit(@RequestParam("docStatus")Integer docStatus, @RequestParam("page")Integer page,@RequestParam("count") Integer count)
			throws Exception;

	// TODO 根据是否需要文件查询分类
    @RequestMapping("/getApplyKindByFileStatus")
	public List<ApplyKind> getApplyKindByFileStatus(@RequestParam("fileStatus")Integer fileStatus) throws Exception;

	// TODO 根据是否需要文件查询分类（分页）
    @RequestMapping("/getApplyKindByFileStatusLimit")
	public List<ApplyKind> getApplyKindByFileStatusLimit(@RequestParam("fileStatus")Integer fileStatus,@RequestParam("page") Integer page,@RequestParam("count") Integer count)
			throws Exception;
    
	// TODO 根据是否需要审核查询分类
    @RequestMapping("/getApplyKindByCheckStatus")
	public List<ApplyKind> getApplyKindByCheckStatus(@RequestParam("checkStatus")Integer checkStatus) throws Exception;

	// TODO 根据是否需要审核查询分类（分页）
    @RequestMapping("/getApplyKindByCheckStatusLimit")
	public List<ApplyKind> getApplyKindByCheckStatusLimit(@RequestParam("checkStatus")Integer checkStatus, @RequestParam("page")Integer page,@RequestParam("count") Integer count)
			throws Exception;

	// TODO 根据审核方式查询分类
    @RequestMapping("/getApplyKindByCheckKind")
	public List<ApplyKind> getApplyKindByCheckKind(@RequestParam("checkKind")Integer checkKind) throws Exception;

	// TODO 根据审核方式查询分类（分页）
    @RequestMapping("/getApplyKindByCheckKindLimit")
	public List<ApplyKind> getApplyKindByCheckKindLimit(@RequestParam("checkKind")Integer checkKind,@RequestParam("page") Integer page,@RequestParam("count") Integer count)
			throws Exception;
	/*-----------------------------------------查询---------------------------------------------*/

	/*-----------------------------------------添加---------------------------------------------*/

	// TODO 添加单个分类
    @RequestMapping("/insertApplyKindOne")
    public int insertApplyKindOne(@RequestBody ApplyKind applyKind) throws Exception;
	/*-----------------------------------------添加---------------------------------------------*/

	/*-----------------------------------------修改---------------------------------------------*/

	// TODO 修改单个分类
    @RequestMapping("/updateApplyKindOne")
	public int updateApplyKindOne(@RequestBody ApplyKind applyKind) throws Exception;

	// TODO 启用分类
    @RequestMapping("/setApplyKindStatusOn")
	public int setApplyKindStatusOn(@RequestParam("id") Integer id) throws Exception;

	// TODO 禁用分类
    @RequestMapping("/setApplyKindStatusOff")
	public int setApplyKindStatusOff(@RequestParam("id")Integer id) throws Exception;

	// TODO 启用佐证材料
    @RequestMapping("/setApplyKindDocOn")
	public int setApplyKindDocOn(@RequestParam("id")Integer id) throws Exception;

	// TODO 禁用佐证材料
    @RequestMapping("/setApplyKindDocOff")
	public int setApplyKindDocOff(@RequestParam("id")Integer id) throws Exception;

	// TODO 启用证明文件
    @RequestMapping("/setApplyKindFileOn")
	public int setApplyKindFileOn(@RequestParam("id")Integer id) throws Exception;

	// TODO 禁用证明文件
    @RequestMapping("/setApplyKindFileOff")
	public int setApplyKindFileOff(@RequestParam("id")Integer id) throws Exception;

	// TODO 启用审核
    @RequestMapping("/setApplyKindCheckOn")
	public int setApplyKindCheckOn(@RequestParam("id")Integer id) throws Exception;

	// TODO 禁用审核
    @RequestMapping("/setApplyKindCheckOff")
	public int setApplyKindCheckOff(@RequestParam("id")Integer id) throws Exception;

	// TODO 启用手动审核
    @RequestMapping("/setApplyKindCheckManual")
	public int setApplyKindCheckManual(@RequestParam("id")Integer id) throws Exception;

	// TODO 启用自动审核
    @RequestMapping("/setApplyKindCheckAuto")
	public int setApplyKindCheckAuto(@RequestParam("id")Integer id) throws Exception;

	/*-----------------------------------------修改---------------------------------------------*/

	/*-----------------------------------------删除---------------------------------------------*/
	// TODO 根据ID删除单个分类
    @RequestMapping("/delApplyKindOneById")
	public int delApplyKindOneById(@RequestParam("id")Integer id) throws Exception;

	// TODO 根据ID批量删除分类
    @RequestMapping("/delApplyKindListById")
	public int delApplyKindListById(@RequestParam("idList")List<Integer> idList) throws Exception;

	// 根据上级分类ID批量删除分类
    @RequestMapping("/delAppliKindListByPid")
	public int delAppliKindListByPid(@RequestParam("pId")Integer pId) throws Exception;

	// TODO 根据分类积分批量删除分类
    @RequestMapping("/delApplyKindListByIntegral")
	public int delApplyKindListByIntegral(@RequestParam("Integral")Double Integral) throws Exception;

	// TODO 根据是否需要佐证材料批量删除分类
    @RequestMapping("/delApplyKindListByDocStatus")
	public int delApplyKindListByDocStatus(@RequestParam("docStatus")Integer docStatus) throws Exception;

	// TODO 根据是否需要证明文件批量删除分类
    @RequestMapping("/delApplyKindListByFileStatus")
	public int delApplyKindListByFileStatus(@RequestParam("fileStatus")Integer fileStatus) throws Exception;

	// TODO 根据是否需要审核批量删除分类
    @RequestMapping("/delApplyKindListByCheckStatus")
	public int delApplyKindListByCheckStatus(@RequestParam("checkStatus")Integer checkStatus) throws Exception;

	// TODO 根据审核方式批量删除分类
    @RequestMapping("/delApplyKindListByCheckKind")
	public int delApplyKindListByCheckKind(@RequestParam("checkKind")Integer checkKind) throws Exception;
	/*-----------------------------------------删除---------------------------------------------*/
/*============================================活动/积分分类表 =========================================== */
}
