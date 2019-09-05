package cn.second.lhj.apply.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.second.lhj.apply.po.Apply;
import cn.second.lhj.apply.service.ApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api
public class ApplyAPI {
	
	@Autowired
	private ApplyService applyService;
	
	/*-----------------------------------------查询---------------------------------------------*/
	//查询所有申请记录条数
    @ApiOperation(value="查询所有申请记录条数")
	@RequestMapping("/countApplyAll")
	public int countApplyAll()throws Exception{
		return applyService.countApplyAll();
	}
	//查询所有申请记录
    @ApiOperation(value="查询所有申请记录")
	@RequestMapping("/getApplyAll")
	public List<Apply> getApplyAll() throws Exception{
		return applyService.getApplyAll();
	}
	//查询所有申请记录（分页）
    @ApiOperation(value="查询所有申请记录（分页）")
	@RequestMapping("/getApplyAllLimit")
	public List<Apply> getApplyAllLimit(@RequestParam("page")int page,@RequestParam("count")int count) throws Exception{
		return applyService.getApplyAllLimit(page, count);
	}
	//根据ID查询申请记录
    @ApiOperation(value="根据ID查询申请记录")
	@RequestMapping("/getApplyById")
	public Apply getApplyById(@RequestParam("id")Integer id) throws Exception{
		return applyService.getApplyById(id);
	}
	//根据申请种类查询申请记录
    @ApiOperation(value="根据申请种类查询申请记录")
	@RequestMapping("/getApplyByKind")
	public List<Apply> getApplyByKind(@RequestParam("kindId")Integer kindId)throws Exception{
		return applyService.getApplyByKind(kindId);
	}
	//根据申请种类查询申请记录（分页）
    @ApiOperation(value="根据申请种类查询申请记录（分页）")
	@RequestMapping("/getApplyByKindLimit")
	public List<Apply> getApplyByKindLimit(@RequestParam("kindId")Integer kindId,@RequestParam("page")int page,@RequestParam("count")int count)throws Exception{
		return applyService.getApplyByKindLimit(kindId, page, count);
	}
	//根据学生学号查询申请记录
    @ApiOperation(value="根据学生学号查询申请记录")
	@RequestMapping("/getApplyByStuId")
	public List<Apply> getApplyByStuId(@RequestParam("stuId")String stuId)throws Exception{
		return applyService.getApplyByStuId(stuId);
	}
	//根据学生学号查询申请记录（分页）
    @ApiOperation(value="根据学生学号查询申请记录（分页）")
	@RequestMapping("/getApplyByStuIdLimit")
	public List<Apply> getApplyByStuIdLimit(@RequestParam("stuId")String stuId,@RequestParam("page")int page,@RequestParam("count")int count)throws Exception{
		return applyService.getApplyByStuIdLimit(stuId, page, count);
	}
	//根据学生学号以及审核状态查询申请记录
    @ApiOperation(value="根据学生学号以及审核状态查询申请记录")
	@RequestMapping("/getApplyByStuIdAndCheckStatus")
	public List<Apply> getApplyByStuIdAndCheckStatus(@RequestParam("stuId")String stuId,@RequestParam("checkStatus")Integer checkStatus)throws Exception{
		return applyService.getApplyByStuIdAndCheckStatus(stuId, checkStatus);
	}
	//根据学生学号以及审核状态查询申请记录（分页）
    @ApiOperation(value="根据学生学号以及审核状态查询申请记录（分页）")
	@RequestMapping("/getApplyByStuIdAndCheckStatusLimit")
	public List<Apply> getApplyByStuIdAndCheckStatusLimit(@RequestParam("stuId")String stuId,@RequestParam("checkStatus")Integer checkStatus,@RequestParam("page")int page,@RequestParam("count")int count)throws Exception{
    	return applyService.getApplyByStuIdAndCheckStatusLimit(stuId, checkStatus, page, count);
    }

    
	//根据申请状态查询申请
    @ApiOperation(value="根据申请状态查询申请")
	@RequestMapping("/getApplyByStatus")
	public List<Apply> getApplyByStatus(@RequestParam("status")Integer status)throws Exception{
		return applyService.getApplyByStatus(status);
	}
	//根据申请状态查询申请（分页）
    @ApiOperation(value="根据申请状态查询申请（分页）")
	@RequestMapping("/getApplyByStatusLimit")
	public List<Apply> getApplyByStatusLimit(@RequestParam("status")Integer status,@RequestParam("page")int page,@RequestParam("count")int count)throws Exception{
		return applyService.getApplyByStatusLimit(status, page, count);
	}
	//根据审核情况查询申请记录
    @ApiOperation(value="根据审核情况查询申请记录")
	@RequestMapping("/getApplyByCheckStatus")
	public List<Apply> getApplyByCheckStatus(@RequestParam("checkStatus")Integer checkStatus) throws Exception{
		return applyService.getApplyByCheckStatus(checkStatus);
	}
	//根据审核情况查询申请记录（分页）
    @ApiOperation(value="根据审核情况查询申请记录（分页）")
	@RequestMapping("/getApplyByCheckStatusLimit")
	public List<Apply> getApplyByCheckStatusLimit(@RequestParam("checkStatus")Integer checkStatus,@RequestParam("page")int page,@RequestParam("count")int count) throws Exception{
		return applyService.getApplyByCheckStatusLimit(checkStatus, page, count);
	}
	//根据是否有佐证材料查询申请记录
    @ApiOperation(value="根据是否有佐证材料查询申请记录")
	@RequestMapping("/getApplyByDoc")
	public List<Apply> getApplyByDoc(@RequestParam("doc")String doc) throws Exception{
		return applyService.getApplyByDoc(doc);
	}
	//根据是否有附件查询申请记录
    @ApiOperation(value="根据是否有附件查询申请记录")
	@RequestMapping("/getApplyByFile")
	public List<Apply> getApplyByFile(@RequestParam("file")String file) throws Exception{
		return applyService.getApplyByFile(file);
	}
	//根据积分查询申请记录
    @ApiOperation(value="根据积分查询申请记录")
	@RequestMapping("/getApplyByIntegral")
	public List<Apply> getApplyByIntegral(@RequestParam("integral")Double integral) throws Exception{
		return applyService.getApplyByIntegral(integral);
	}
	//根据积分查询申请记录（分页）
    @ApiOperation(value="根据积分查询申请记录（分页）")
	@RequestMapping("/getApplyByIntegralLimit")
	public List<Apply> getApplyByIntegralLimit(@RequestParam("integral")Double integral,@RequestParam("page")int page,@RequestParam("count")int count) throws Exception{
		return applyService.getApplyByIntegralLimit(integral, page, count);
	}

	//根据时间段查询已审核申请记录
    @ApiOperation(value="根据时间段查询已审核申请记录")
	@RequestMapping("/getApplyCheckedByDateBetween")
	public List<Apply> getApplyCheckedByDateBetween(@RequestParam("startTime")String getStartTime)throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date startTime = sdf.parse(getStartTime); 
    	Date endTime=new Date();
    	return applyService.getApplyCheckedByDateBetween(startTime, endTime);
    }
	/*-----------------------------------------查询---------------------------------------------*/
	
	
	/*-----------------------------------------添加---------------------------------------------*/
	//添加申请记录
    @ApiOperation(value="添加申请记录")
	@RequestMapping("/insertApplyOne")
	public int insertApplyOne(@RequestBody Apply apply) throws Exception{
		return applyService.insertApplyOne(apply);
	}
	/*-----------------------------------------添加---------------------------------------------*/
	

	/*-----------------------------------------删除---------------------------------------------*/
	//根据ID删除单条申请记录
    @ApiOperation(value="根据ID删除单条申请记录")
	@RequestMapping("/deleteApplyOneById")
	public int deleteApplyOneById(@RequestParam("id")Integer id) throws Exception{
		return applyService.deleteApplyOneById(id);
	}
	//根据ID批量删除申请记录
    @ApiOperation(value="根据ID批量删除申请记录")
	@RequestMapping("/deleteApplyListById")
	public int deleteApplyListById(@RequestParam("idList")List<Integer> idList) throws Exception{
		return applyService.deleteApplyListById(idList);
	}
	//根据学生学号批量删除申请记录
    @ApiOperation(value="根据学生学号批量删除申请记录")
	@RequestMapping("/deleteApplyListByStuId")
	public int deleteApplyListByStuId(@RequestParam("stuId")String stuId) throws Exception{
		return applyService.deleteApplyListByStuId(stuId);
	}
	//根据申请分类批量删除申请记录
    @ApiOperation(value="根据申请分类批量删除申请记录")
	@RequestMapping("/deleteApplyListByKind")
	public int deleteApplyListByKind(@RequestParam("kindId")Integer kindId) throws Exception{
		return applyService.deleteApplyListByKind(kindId);
	}
	/*-----------------------------------------删除---------------------------------------------*/
	
	

	/*-----------------------------------------修改---------------------------------------------*/
	//修改单条申请记录
    @ApiOperation(value="修改单条申请记录")
	@RequestMapping("/updateApplyOne")
	public int updateApplyOne(@RequestBody Apply apply) throws Exception{
		return applyService.updateApplyOne(apply);
	}
	//根据ID通过单条申请记录审核
    @ApiOperation(value="根据ID通过单条申请记录审核")
	@RequestMapping("/checkApplyOneById")
	public int checkApplyOneById(@RequestParam("id")Integer id)throws Exception{
		return applyService.checkApplyOneById(id);
	}
	//根据ID批量通过审核
    @ApiOperation(value="根据ID批量通过审核")
	@RequestMapping("/checkApplyListById")
	public int checkApplyListById(@RequestParam("idList")List<Integer> idList) throws Exception{
		return applyService.checkApplyListById(idList);
	}
	//根据申请种类批量通过申请
    @ApiOperation(value="根据申请种类批量通过申请")
	@RequestMapping("/checkApplyListByKind")
	public int checkApplyListByKind(@RequestParam("kindId")Integer kindId)throws Exception{
		return applyService.checkApplyListByKind(kindId);
	}
	//根据学生学号批量通过审核
    @ApiOperation(value="根据学生学号批量通过审核")
	@RequestMapping("/checkApplyListByStuId")
	public int checkApplyListByStuId(@RequestParam("stuId")String stuId) throws Exception{
		return applyService.checkApplyListByStuId(stuId);
	}
	//根据积分批量通过审核
    @ApiOperation(value="根据积分批量通过审核")
	@RequestMapping("/checkApplyListByIntegral")
	public int checkApplyListByIntegral(@RequestParam("integral")Double integral) throws Exception{
		return applyService.checkApplyListByIntegral(integral);
	}
	//根据ID驳回单条申请记录
    @ApiOperation(value="根据ID驳回单条申请记录")
	@RequestMapping("/rejectApplyOneById")
	public int rejectApplyOneById(@RequestParam("id")Integer id) throws Exception{
		return applyService.rejectApplyOneById(id);
	}
	//根据ID批量驳回申请
    @ApiOperation(value="根据ID批量驳回申请")
	@RequestMapping("/rejectApplyListById")
	public int rejectApplyListById(@RequestParam("idList")List<Integer> idList)throws Exception{
		return applyService.rejectApplyListById(idList);
	}
	//根据申请种类批量驳回申请
    @ApiOperation(value="根据申请种类批量驳回申请")
	@RequestMapping("/rejectApplyListByKind")
	public int rejectApplyListByKind(@RequestParam("kindId")Integer kindId)throws Exception{
		return applyService.rejectApplyListByKind(kindId);
	}
	//根据学生学号批量驳回申请
    @ApiOperation(value="根据学生学号批量驳回申请")
	@RequestMapping("/rejectAppliListByStuId")
	public int rejectAppliListByStuId(@RequestParam("stuId")String stuId)throws Exception{
		return applyService.rejectAppliListByStuId(stuId);
	}
	//根据积分批量驳回申请
    @ApiOperation(value="根据积分批量驳回申请")
	@RequestMapping("/rejectApplyListByIntegral")
	public int rejectApplyListByIntegral(@RequestParam("integral")Double integral)throws Exception{
		return applyService.rejectApplyListByIntegral(integral);
	}
	
	//根据ID取消单条申请记录
    @ApiOperation(value="根据ID取消单条申请记录")
	@RequestMapping("/cancelApplyOneById")
	public int cancelApplyOneById(@RequestParam("id")Integer id)throws Exception{
		return applyService.cancelApplyOneById(id);
	}
	//根据ID批量取消申请记录
    @ApiOperation(value="根据ID批量取消申请记录")
	@RequestMapping("/cancelApplyLisyById")
	public int cancelApplyLisyById(@RequestParam("idList")List<Integer> idList)throws Exception{
		return applyService.cancelApplyLisyById(idList);
	}
	//根据学生学生批量取消申请记录
    @ApiOperation(value="根据学生学生批量取消申请记录")
	@RequestMapping("/cancelApplyListByStuId")
	public int cancelApplyListByStuId(@RequestParam("stuId")String stuId)throws Exception{
		return applyService.cancelApplyListByStuId(stuId);
	}
	/*-----------------------------------------修改---------------------------------------------*/
	
}
