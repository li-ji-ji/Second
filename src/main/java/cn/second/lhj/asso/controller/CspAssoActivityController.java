package cn.second.lhj.asso.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

import cn.second.lhj.applykind.po.ApplyKind;
import cn.second.lhj.applykind.service.ApplyKindService;
import cn.second.lhj.asso.dto.AssoActivityFormDto;
import cn.second.lhj.asso.po.CspAssoActivity;
import cn.second.lhj.asso.po.CspAssoManagement;
import cn.second.lhj.asso.po.CspAssoStudent;
import cn.second.lhj.asso.service.CspAssoActivityService;
import cn.second.lhj.asso.service.CspAssoManagementService;
import cn.second.lhj.asso.service.CspAssoStudentService;

@Controller
@RequestMapping("/assoAct")
public class CspAssoActivityController {
	
	
//	@Autowired
//	private AssoActFeignInterface assoAct;

//	@Autowired
//	private ApplyFeignInterface applyFeign;

	
	@Autowired
	private CspAssoActivityService actService;
	
	@Autowired
	private CspAssoManagementService assoService;
	
	@Autowired
	private CspAssoStudentService stuService;
	
	@Autowired
	private ApplyKindService applyKindService;
	
	//跳转到所有活动页面
	@RequestMapping("/toTable")
	public String toActTable(Model model,@RequestParam(value="page",required=false,defaultValue="1")Integer page,@RequestParam(value="count",required=false,defaultValue="5")Integer count) throws Exception {
		List<CspAssoActivity> actList=actService.getActivityAllLimit(page, count);
		model.addAttribute("actList",actList);
		int pageNum=(actService.countActivityAll()/count)+1;
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageNow",page);
		int hasPage=1;
		model.addAttribute("hasPage",hasPage);
		return "AssoAct/Table";
	}
	
	//跳转到社团活动页面
	@RequestMapping("/toAssoActTable")
	public String toAssoActTable(@RequestParam("assoId") String assoId,Model model) throws Exception {
		Object activityList=actService.getActivityByAId(assoId);
		model.addAttribute("activityList", activityList);
		return "ftl/asso/activity/Table";
	}
	
	//删除单个活动
	@RequestMapping("/deleteActivityOneById")
	public String deleteActivityOneById(@RequestParam("id") Integer id)throws Exception{
		actService.deleteActivityOneById(id);
		return "redirect:toTable";
	}
	
	//跳转到修改页面
	@RequestMapping("/toEdit")
	public String toActEditForm(@RequestParam("id") Integer id,Model model)throws Exception{
		AssoActivityFormDto act=actService.getAssoActFormDto(id);
		model.addAttribute("act", act);
		List<CspAssoManagement> assoList=assoService.getAll();
		model.addAttribute("assoList",assoList);
		List<CspAssoStudent> stuList=stuService.getAll();
		model.addAttribute("stuList",stuList);
		//获取分类列表
		List<ApplyKind> kindList=applyKindService.getApplyKindByPid(0);
		model.addAttribute("kindList", kindList);
		List<ApplyKind> getKindAll=applyKindService.getApplyKindAll();
		String kindAll=JSON.toJSONString(getKindAll);
		model.addAttribute("kindAll", kindAll);
		return "AssoAct/EditForm";
	}
	
	//更新单个活动数据
	@RequestMapping("/updateActOne")
	public String updateActOne(AssoActivityFormDto act)throws Exception{
		System.out.println(act.toString());
		actService.updateActivityOne(act);
		return "redirect:toTable";
	}
	
	//更新活动状态为开启
	@RequestMapping("/updateActivityStatusOpen")
	public String updateActivityStatusOpen(@RequestParam("id") Integer id)throws Exception{
		actService.updateActivityStatusOpen(id);
		return "redirect:toTable";
	}
	//更新活动状态为结束
	@RequestMapping("/updateActivityStatusClose")
	public String updateActivityStatusClose(@RequestParam("id") Integer id)throws Exception{
		actService.updateActivityStatusClose(id);
		return "redirect:toTable";
	}
	
	//跳转到添加页面
	@RequestMapping("/toAdd")
	public String toActEditForm(Model model)throws Exception{
		List<CspAssoManagement> assoList=assoService.getAll();
		List<CspAssoStudent> stuList=stuService.getAll();
		model.addAttribute("assoList", assoList);
		model.addAttribute("stuList", stuList);
		//获取分类列表
		List<ApplyKind> kindList=applyKindService.getApplyKindByPid(0);
		model.addAttribute("kindList", kindList);
		List<ApplyKind> getKindAll=applyKindService.getApplyKindAll();
		String kindAll=JSON.toJSONString(getKindAll);
		model.addAttribute("kindAll", kindAll);
		return "AssoAct/AddForm";
	}
	
	//添加一个新的活动
	@RequestMapping("/insertActivityOne")
	public String insertActicity(AssoActivityFormDto act)throws Exception{
		actService.insertActicity(act);
		return "redirect:toTable";
	}
	
	//根据ID批量删除活动
	@RequestMapping("/delActByIdList")
	public String delActByIdList(@RequestParam("id") List<Integer> idList)throws Exception{
		// TODO 批量删除
		return "redirect:toTable";
	} 
	//根据ID查询申请
	@RequestMapping("/getActByActId")
	public String getActById(Model model,@RequestParam("keyWord")String actId)throws Exception{
		AssoActivityFormDto act=(AssoActivityFormDto) actService.getActivityByActId(actId);
		List<AssoActivityFormDto> actList=new ArrayList();
		actList.add(act);
		model.addAttribute("actList",actList);
		model.addAttribute("pageNum",1);
		model.addAttribute("pageNow",1);
		model.addAttribute("hasPage",0);
		return "AssoAct/Table";
	}
	
	//查看详情
	@RequestMapping("/toDetail")
	public String toDetail(Model model,@RequestParam("id")Integer id)throws Exception{
		AssoActivityFormDto act=actService.getAssoActFormDto(id);
		model.addAttribute("act", act);
		return "AssoAct/Detail";
	}
}
