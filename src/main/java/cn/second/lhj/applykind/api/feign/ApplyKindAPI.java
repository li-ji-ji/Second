package cn.second.lhj.applykind.api.feign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cn.second.lhj.applykind.po.ApplyKind;
import cn.second.lhj.applykind.service.ApplyKindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * 			积分、活动分类表
 * */

@RestController
@CrossOrigin
@Api
public class ApplyKindAPI {

	@Autowired
	private ApplyKindService kindService;

	/*-----------------------------------------查询---------------------------------------------*/

    @ApiOperation(value="查询所有分类")
    @RequestMapping("/getApplyKindAll")
	public List<ApplyKind> getApplyKindAll() throws Exception {
		// TODO 查询所有分类
		return kindService.getApplyKindAll();
	}

    @ApiOperation(value="查询所有分类（分页）")
    @RequestMapping("/getApplyKindAllLimit")
	public List<ApplyKind> getApplyKindAllLimit(@RequestParam("page") Integer page,
			@RequestParam("count") Integer count) throws Exception {
		// TODO 查询所有分类（分页）
		return kindService.getApplyKindAllLimit(page, count);
	}

    @ApiOperation(value="根据ID查询分类")
    @RequestMapping("/getApplyKindById")
	public ApplyKind getApplyKindById(@RequestParam("id") Integer id) throws Exception {
		// TODO 根据ID查询分类
		return kindService.getApplyKindById(id);
	}

    @ApiOperation(value="根据分类名称查询分类")
    @RequestMapping("/getApplyKindByName")
	public List<ApplyKind> getApplyKindByName(@RequestParam("name") String name) throws Exception {
		// TODO 根据分类名称查询分类
		return kindService.getApplyKindByName(name);
	}

    @ApiOperation(value="根据分类名称查询分类（模糊）")
    @RequestMapping("/getApplyKindByNameLike")
	public List<ApplyKind> getApplyKindByNameLike(@RequestParam("keyWord") String keyWord) throws Exception {
		// TODO 根据分类名称查询分类（模糊）
		return kindService.getApplyKindByNameLike(keyWord);
	}

    @ApiOperation(value="根据上级分类ID查询分类")
    @RequestMapping("/getApplyKindByPid")
	public List<ApplyKind> getApplyKindByPid(@RequestParam("pId") Integer pId) throws Exception {
		// TODO 根据上级分类ID查询分类
		return kindService.getApplyKindByPid(pId);
	}

    @ApiOperation(value="根据上级分类ID查询分类（分页）")
    @RequestMapping("/getApplyKindByPidLimit")
	public List<ApplyKind> getApplyKindByPidLimit(@RequestParam("pId") Integer pId, @RequestParam("page") Integer page,
			@RequestParam("count") Integer count) throws Exception {
		// 根据上级分类ID查询分类（分页）
		return kindService.getApplyKindByPidLimit(pId, page, count);
	}

    @ApiOperation(value="根据启用状态查询分类")
    @RequestMapping("/getApplyKindByStatus")
	public List<ApplyKind> getApplyKindByStatus(@RequestParam("status") Integer status) throws Exception {
		// TODO 根据启用状态查询分类
		return kindService.getApplyKindByStatus(status);
	}

    @ApiOperation(value="根据启用状态查询分类（分页）")
    @RequestMapping("/getApplyKindByStatusLimit")
	public List<ApplyKind> getApplyKindByStatusLimit(@RequestParam("status") Integer status,
			@RequestParam("page") Integer page, @RequestParam("count") Integer count) throws Exception {
		// TODO 根据启用状态查询分类（分页）
		return kindService.getApplyKindByStatusLimit(status, page, count);
	}

    @ApiOperation(value="查询已启用分类")
    @RequestMapping("/getApplyKindStatusOn")
	public List<ApplyKind> getApplyKindStatusOn() throws Exception {
		// TODO 查询已启用分类
		return kindService.getApplyKindStatusOn();
	}

    @ApiOperation(value="查询已启用分类（分页）")
    @RequestMapping("/getApplyKindStatusOnLimit")
	public List<ApplyKind> getApplyKindStatusOnLimit(@RequestParam("page") Integer page,
			@RequestParam("count") Integer count) throws Exception {
		// TODO 查询已启用分类（分页）
		return kindService.getApplyKindStatusOnLimit(page, count);
	}

    @ApiOperation(value="查询未启用分类")
    @RequestMapping("/getApplyKindStatusOff")
	public List<ApplyKind> getApplyKindStatusOff() throws Exception {
		// TODO 查询未启用分类
		return kindService.getApplyKindStatusOff();
	}

    @ApiOperation(value="查询未启用分类（分页）")
    @RequestMapping("/getApplyKindStatusOffLimit")
	public List<ApplyKind> getApplyKindStatusOffLimit(@RequestParam("page") Integer page,
			@RequestParam("count") Integer count) throws Exception {
		// TODO 查询未启用分类（分页）
		return kindService.getApplyKindStatusOffLimit(page, count);
	}

    @ApiOperation(value="根据分类积分查询分类")
    @RequestMapping("/getApplyKindByIntegral")
	public List<ApplyKind> getApplyKindByIntegral(@RequestParam("integral") Double integral) throws Exception {
		// TODO 根据分类积分查询分类
		return kindService.getApplyKindByIntegral(integral);
	}

    @ApiOperation(value="根据分类积分查询分类（分页）")
    @RequestMapping("/getApplyKindByIntegralLimit")
	public List<ApplyKind> getApplyKindByIntegralLimit(@RequestParam("integral") Double integral,
			@RequestParam("page") Integer page, @RequestParam("count") Integer count) throws Exception {
		// TODO 根据分类积分查询分类（分页）
		return kindService.getApplyKindByIntegralLimit(integral, page, count);
	}

    @ApiOperation(value="根据是否需要佐证材料查询分类")
    @RequestMapping("/getApplyKindByDocStatus")
	public List<ApplyKind> getApplyKindByDocStatus(@RequestParam("docStatus") Integer docStatus) throws Exception {
		// TODO 根据是否需要佐证材料查询分类
		return kindService.getApplyKindByDocStatus(docStatus);
	}

    @ApiOperation(value="根据是否需要佐证材料查询分类（分页）")
    @RequestMapping("/getApplyKindByDocStatusLimit")
	public List<ApplyKind> getApplyKindByDocStatusLimit(@RequestParam("docStatus")Integer docStatus, @RequestParam("page")Integer page,@RequestParam("count") Integer count)
			throws Exception {
		// TODO 根据是否需要佐证材料查询分类（分页）
		return kindService.getApplyKindByDocStatusLimit(docStatus, page, count);
	}

    @ApiOperation(value="根据是否需要文件查询分类")
    @RequestMapping("/getApplyKindByFileStatus")
	public List<ApplyKind> getApplyKindByFileStatus(@RequestParam("fileStatus")Integer fileStatus) throws Exception {
		// TODO 根据是否需要文件查询分类
		return kindService.getApplyKindByFileStatus(fileStatus);
	}

    @ApiOperation(value="根据是否需要文件查询分类（分页）")
    @RequestMapping("/getApplyKindByFileStatusLimit")
	public List<ApplyKind> getApplyKindByFileStatusLimit(@RequestParam("fileStatus")Integer fileStatus,@RequestParam("page") Integer page,@RequestParam("count") Integer count)
			throws Exception {
		// TODO 根据是否需要文件查询分类（分页）
		return kindService.getApplyKindByFileStatusLimit(fileStatus, page, count);
	}

    @ApiOperation(value="根据是否需要审核查询分类")
    @RequestMapping("/getApplyKindByCheckStatus")
	public List<ApplyKind> getApplyKindByCheckStatus(@RequestParam("checkStatus")Integer checkStatus) throws Exception {
		// TODO 根据是否需要审核查询分类
		return kindService.getApplyKindByCheckStatus(checkStatus);
	}

    @ApiOperation(value="根据是否需要审核查询分类（分页）")
    @RequestMapping("/getApplyKindByCheckStatusLimit")
	public List<ApplyKind> getApplyKindByCheckStatusLimit(@RequestParam("checkStatus")Integer checkStatus, @RequestParam("page")Integer page,@RequestParam("count") Integer count)
			throws Exception {
		// TODO 根据是否需要审核查询分类（分页）
		return kindService.getApplyKindByCheckStatusLimit(checkStatus, page, count);
	}

    @ApiOperation(value="根据审核方式查询分类")
    @RequestMapping("/getApplyKindByCheckKind")
	public List<ApplyKind> getApplyKindByCheckKind(@RequestParam("checkKind")Integer checkKind) throws Exception {
		// TODO 根据审核方式查询分类
		return kindService.getApplyKindByCheckKind(checkKind);
	}

    @ApiOperation(value="根据审核方式查询分类（分页）")
    @RequestMapping("/getApplyKindByCheckKindLimit")
	public List<ApplyKind> getApplyKindByCheckKindLimit(@RequestParam("checkKind")Integer checkKind,@RequestParam("page") Integer page,@RequestParam("count") Integer count)
			throws Exception {
		// TODO 根据审核方式查询分类（分页）
		return kindService.getApplyKindByCheckKindLimit(checkKind, page, count);
	}
	/*-----------------------------------------查询---------------------------------------------*/

	/*-----------------------------------------添加---------------------------------------------*/

    @ApiOperation(value="添加单个分类")
    @RequestMapping("/insertApplyKindOne")
    public int insertApplyKindOne(@RequestBody ApplyKind applyKind) throws Exception {
		// TODO 添加单个分类
		return kindService.insertApplyKindOne(applyKind);
	}
	/*-----------------------------------------添加---------------------------------------------*/

	/*-----------------------------------------修改---------------------------------------------*/
    @ApiOperation(value="修改单个分类")
    @RequestMapping("/updateApplyKindOne")
	public int updateApplyKindOne(@RequestBody ApplyKind applyKind) throws Exception {
		// TODO 修改单个分类
		return kindService.updateApplyKindOne(applyKind);
	}

    @ApiOperation(value="启用分类")
    @RequestMapping("/setApplyKindStatusOn")
	public int setApplyKindStatusOn(@RequestParam("id") Integer id) throws Exception {
		// TODO 启用分类
		return kindService.setApplyKindStatusOn(id);
	}

    @ApiOperation(value="禁用分类")
    @RequestMapping("/setApplyKindStatusOff")
	public int setApplyKindStatusOff(@RequestParam("id")Integer id) throws Exception {
		// TODO 禁用分类
		return kindService.setApplyKindStatusOff(id);
	}

    @ApiOperation(value="启用佐证材料")
    @RequestMapping("/setApplyKindDocOn")
	public int setApplyKindDocOn(@RequestParam("id")Integer id) throws Exception {
		// TODO 启用佐证材料
		return kindService.setApplyKindDocOn(id);
	}

    @ApiOperation(value="禁用佐证材料")
    @RequestMapping("/setApplyKindDocOff")
	public int setApplyKindDocOff(@RequestParam("id")Integer id) throws Exception {
		// TODO 禁用佐证材料
		return kindService.setApplyKindDocOff(id);
	}

    @ApiOperation(value="启用证明文件")
    @RequestMapping("/setApplyKindFileOn")
	public int setApplyKindFileOn(@RequestParam("id")Integer id) throws Exception {
		// TODO 启用证明文件
		return kindService.setApplyKindFileOn(id);
	}

    @ApiOperation(value="禁用证明文件")
    @RequestMapping("/setApplyKindFileOff")
	public int setApplyKindFileOff(@RequestParam("id")Integer id) throws Exception {
		// TODO 禁用证明文件
		return kindService.setApplyKindFileOff(id);
	}

    @ApiOperation(value="启用审核")
    @RequestMapping("/setApplyKindCheckOn")
	public int setApplyKindCheckOn(@RequestParam("id")Integer id) throws Exception {
		// TODO 启用审核
		return kindService.setApplyKindCheckOn(id);
	}

    @ApiOperation(value="禁用审核")
    @RequestMapping("/setApplyKindCheckOff")
	public int setApplyKindCheckOff(@RequestParam("id")Integer id) throws Exception {
		// TODO 禁用审核
		return kindService.setApplyKindCheckOff(id);
	}

    @ApiOperation(value="启用手动审核")
    @RequestMapping("/setApplyKindCheckManual")
	public int setApplyKindCheckManual(@RequestParam("id")Integer id) throws Exception {
		// TODO 启用手动审核
		return kindService.setApplyKindCheckManual(id);
	}

    @ApiOperation(value="启用自动审核")
    @RequestMapping("/setApplyKindCheckAuto")
	public int setApplyKindCheckAuto(@RequestParam("id")Integer id) throws Exception {
		// TODO 启用自动审核
		return kindService.setApplyKindCheckAuto(id);
	}

	/*-----------------------------------------修改---------------------------------------------*/

	/*-----------------------------------------删除---------------------------------------------*/
    @ApiOperation(value="根据ID删除单个分类")
    @RequestMapping("/delApplyKindOneById")
	public int delApplyKindOneById(@RequestParam("id")Integer id) throws Exception {
		// TODO 根据ID删除单个分类
		return kindService.delApplyKindOneById(id);
	}

    @ApiOperation(value="根据ID批量删除分类")
    @RequestMapping("/delApplyKindListById")
	public int delApplyKindListById(@RequestParam("idList")List<Integer> idList) throws Exception {
		// TODO 根据ID批量删除分类
		return kindService.delApplyKindListById(idList);
	}

    @ApiOperation(value="根据上级分类ID批量删除分类")
    @RequestMapping("/delAppliKindListByPid")
	public int delAppliKindListByPid(@RequestParam("pId")Integer pId) throws Exception {
		// 根据上级分类ID批量删除分类
		return kindService.delAppliKindListByPid(pId);
	}

    @ApiOperation(value="根据分类积分批量删除分类")
    @RequestMapping("/delApplyKindListByIntegral")
	public int delApplyKindListByIntegral(@RequestParam("Integral")Double Integral) throws Exception {
		// TODO 根据分类积分批量删除分类
		return kindService.delApplyKindListByIntegral(Integral);
	}

    @ApiOperation(value="根据是否需要佐证材料批量删除分类")
    @RequestMapping("/delApplyKindListByDocStatus")
	public int delApplyKindListByDocStatus(@RequestParam("docStatus")Integer docStatus) throws Exception {
		// TODO 根据是否需要佐证材料批量删除分类
		return kindService.delApplyKindListByDocStatus(docStatus);
	}

    @ApiOperation(value="根据是否需要证明文件批量删除分类")
    @RequestMapping("/delApplyKindListByFileStatus")
	public int delApplyKindListByFileStatus(@RequestParam("fileStatus")Integer fileStatus) throws Exception {
		// TODO 根据是否需要证明文件批量删除分类
		return kindService.delApplyKindListByFileStatus(fileStatus);
	}

    @ApiOperation(value="根据是否需要审核批量删除分类")
    @RequestMapping("/delApplyKindListByCheckStatus")
	public int delApplyKindListByCheckStatus(@RequestParam("checkStatus")Integer checkStatus) throws Exception {
		// TODO 根据是否需要审核批量删除分类
		return kindService.delApplyKindListByCheckStatus(checkStatus);
	}

    @ApiOperation(value="根据审核方式批量删除分类")
    @RequestMapping("/delApplyKindListByCheckKind")
	public int delApplyKindListByCheckKind(@RequestParam("checkKind")Integer checkKind) throws Exception {
		// TODO 根据审核方式批量删除分类
		return kindService.delApplyKindListByCheckKind(checkKind);
	}

	/*-----------------------------------------删除---------------------------------------------*/
}
