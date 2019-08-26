package cn.second.lhj.assoAct.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.second.lhj.apply.po.Apply;
import cn.second.lhj.assoAct.dto.AssoActivityFormDto;
import cn.second.lhj.assoAct.feign.AssoActFeignInterface;
import cn.second.lhj.assoAct.po.CspAssoActivity;
import cn.second.lhj.assoAct.po.CspAssoManagement;
import cn.second.lhj.assoAct.po.CspAssoStudent;

@Controller
@RequestMapping("/assoAct")
public class CspAssoActivityController {
	
	@Autowired
	private AssoActFeignInterface assoAct;
	
	//跳转到所有活动页面
	@RequestMapping("/toTable")
	public String toActTable(Model model,@RequestParam(value="page",required=false,defaultValue="1")Integer page,@RequestParam(value="count",required=false,defaultValue="5")Integer count) throws Exception {
		List<CspAssoActivity> actList=assoAct.getActivityAllLimit(page, count);
		model.addAttribute("actList",actList);
		int pageNum=(assoAct.countActivityAll()/count)+1;
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageNow",page);
		int hasPage=1;
		model.addAttribute("hasPage",hasPage);
		return "AssoAct/Table";
	}
	
	//跳转到社团活动页面
	@RequestMapping("/toAssoActTable")
	public String toAssoActTable(@RequestParam("assoId") String assoId,Model model) throws Exception {
		Object activityList=assoAct.getActivityByAId(assoId);
		model.addAttribute("activityList", activityList);
		return "ftl/asso/activity/Table";
	}
	
	//删除单个活动
	@RequestMapping("/deleteActivityOneById")
	public String deleteActivityOneById(@RequestParam("id") Integer id)throws Exception{
		assoAct.deleteActivityOneById(id);
		return "redirect:toTable";
	}
	
	//跳转到修改页面
	@RequestMapping("/toEdit")
	public String toActEditForm(@RequestParam("id") Integer id,Model model)throws Exception{
		AssoActivityFormDto act=assoAct.getAssoActFormDto(id);
		model.addAttribute("act", act);
		List<CspAssoManagement> assoList=assoAct.getAll();
		model.addAttribute("assoList",assoList);
		List<CspAssoStudent> stuList=assoAct.getStuAll();
		model.addAttribute("stuList",stuList);
		return "AssoAct/EditForm";
	}
	
	//更新单个活动数据
	@RequestMapping("/updateActOne")
	public String updateActOne(AssoActivityFormDto act)throws Exception{
		System.out.println(act.toString());
		assoAct.updateActivityOne(act);
		return "redirect:toTable";
	}
	
	//更新活动状态为开启
	@RequestMapping("/updateActivityStatusOpen")
	public String updateActivityStatusOpen(@RequestParam("id") Integer id)throws Exception{
		assoAct.updateActivityStatusOpen(id);
		return "redirect:toTable";
	}
	//更新活动状态为结束
	@RequestMapping("/updateActivityStatusClose")
	public String updateActivityStatusClose(@RequestParam("id") Integer id)throws Exception{
		assoAct.updateActivityStatusClose(id);
		return "redirect:toTable";
	}
	
	//跳转到添加页面
	@RequestMapping("/toAdd")
	public String toActEditForm(Model model)throws Exception{
		List<CspAssoManagement> assoList=assoAct.getAll();
		List<CspAssoStudent> stuList=assoAct.getStuAll();
		model.addAttribute("assoList", assoList);
		model.addAttribute("stuList", stuList);
		return "AssoAct/AddForm";
	}
	
	//添加一个新的活动
	@RequestMapping("/insertActivityOne")
	public String insertActicity(AssoActivityFormDto act)throws Exception{
		assoAct.insertActicity(act);
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
		AssoActivityFormDto act=assoAct.getActicityByActId(actId);
		List<AssoActivityFormDto> actList=new ArrayList();
		actList.add(act);
		model.addAttribute("actList",actList);
		model.addAttribute("pageNum",1);
		model.addAttribute("pageNow",1);
		model.addAttribute("hasPage",0);
		return "AssoAct/Table";
	}
}
