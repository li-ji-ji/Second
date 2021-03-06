package cn.second.lhj.apply.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.second.lhj.apply.po.Apply;
import cn.second.lhj.apply.service.ApplyService;
import cn.second.lhj.applykind.po.ApplyKind;
import cn.second.lhj.applykind.service.ApplyKindService;
import cn.second.lhj.checkrecord.service.CheckRecordService;

@Controller
@RequestMapping("/apply")
public class ApplyController {

	@Autowired
	private ApplyService applyService;
	
	@Autowired
	private ApplyKindService kindService;
	
	//跳转到申请列表
	@RequestMapping("/toTable")
	public String toTable(Model model,@RequestParam(value="page",required=false,defaultValue="1")Integer page,@RequestParam(value="count",required=false,defaultValue="5")Integer count)throws Exception{
		List<Apply> applyList=applyService.getApplyAllLimit(page, count);
		model.addAttribute("applyList",applyList);
		int pageNum=(applyService.countApplyAll()/count)+1;
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageNow",page);
		int hasPage=1;
		model.addAttribute("hasPage",hasPage);
		return "apply/Table";
	}
	
	//跳转到修改表单
	@RequestMapping("/toEdit")
	public String toEdit(Model model,@RequestParam("id") Integer id)throws Exception{
		Apply apply=applyService.getApplyById(id);
		model.addAttribute("apply", apply);
		List<ApplyKind> kindList=kindService.getApplyKindByPid(0);
		model.addAttribute("kindList", kindList);
		List<ApplyKind> getKindAll=kindService.getApplyKindAll();
		String kindAll=JSON.toJSONString(getKindAll);
		model.addAttribute("kindAll", kindAll);
		return "apply/EditForm";
	}
	
	//提交修改表单
	@RequestMapping("/updateApplyOne")
	public String updateApplyOne(Apply apply)throws Exception{
		applyService.updateApplyOne(apply);
		return "redirect:toTable";
	}
	
	//跳转到添加表单
	@RequestMapping("/toAdd")
	public String toAdd(Model model)throws Exception{
		List<ApplyKind> kindList=kindService.getApplyKindByPid(0);
		model.addAttribute("kindList", kindList);
		List<ApplyKind> getKindAll=kindService.getApplyKindAll();
		String kindAll=JSON.toJSONString(getKindAll);
		model.addAttribute("kindAll", kindAll);
		return "apply/AddForm";
	}
	
	//提交添加表单
	@RequestMapping("/insertApplyOne")
	public String insertApplyOne(Apply apply)throws Exception{
		applyService.insertApplyOne(apply);
		return "redirect:toTable";
	}
	
	//根据ID删除单个申请
	@RequestMapping("/delApplyOneById")
	public String delApplyOneById(@RequestParam("id")Integer id)throws Exception{
		applyService.deleteApplyOneById(id);
		return "redirect:toTable";
	}

	//根据ID批量删除申请
	@RequestMapping("/delApplyListById")
	public String delApplyListById(@RequestParam("id") List<Integer> idList)throws Exception{
		applyService.deleteApplyListById(idList);
		return "redirect:toTable";
	}
	
	//根据ID批量通过审核
	@RequestMapping("/checkApplyListById")
	public String checkApplyListById(@RequestParam("id") List<Integer> idList)throws Exception{
		applyService.checkApplyListById(idList);
		return "redirect:toTable";
	}
	
	//根据ID批量驳回审核
	@RequestMapping("/rejectApplyListById")
	public String rejectApplyListById(@RequestParam("id") List<Integer> idList) throws Exception{
		applyService.rejectApplyListById(idList);
		return "redirect:toTable";
	}
	
	//根据ID查询申请
	@RequestMapping("/getApplyById")
	public String getApplyById(Model model,@RequestParam("keyWord")Integer id)throws Exception{
		Apply apply=applyService.getApplyById(id);
		List<Apply> applyList=new ArrayList();
		applyList.add(apply);
		model.addAttribute("applyList",applyList);
		model.addAttribute("pageNum",1);
		model.addAttribute("pageNow",1);
		model.addAttribute("hasPage",0);
		return "apply/Table";
	}
	
	//通过单个申请审核
	@RequestMapping("/checkApplyOne")
	public String checkApplyOne(@RequestParam("id") Integer id)throws Exception{
		applyService.checkApplyOneById(id);
		return "redirect:toTable";
	}
	
	//驳回单个申请审核
	@RequestMapping("/rejectApplyOne")
	public String rejectApplyOne(@RequestParam("id") Integer id)throws Exception{
		applyService.rejectApplyOneById(id);
		return "redirect:toTable";
	}
	
	//根据ID获取下级分类
	@RequestMapping("/getApplyKindByPid")
	@ResponseBody
	public List<ApplyKind> getApplyKindByPid(@RequestParam("pId")Integer pId)throws Exception{
		return kindService.getApplyKindByPid(pId);
	}
	
	//查看详情
	@RequestMapping("/toDetail")
	public String toDetail(Model model,@RequestParam("id")Integer id)throws Exception{
		Apply apply=applyService.getApplyById(id);
		model.addAttribute("apply", apply);
		return "apply/Detail";
	}
}
