package cn.second.lhj.applykind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.second.lhj.applykind.po.ApplyKind;
import cn.second.lhj.applykind.service.ApplyKindService;

@Controller
@RequestMapping("/applyKind")
public class ApplyKindController {

	@Autowired
	private ApplyKindService kindService;
	
	//跳转到分类表格
	@RequestMapping("/toTable")
	public String toTable(Model model,@RequestParam(value="page",required=false,defaultValue="1")Integer page,@RequestParam(value="count",required=false,defaultValue="5")Integer count) throws Exception{
		List<ApplyKind> kindList=kindService.getApplyKindAllLimit(page, count);
		model.addAttribute("kindList",kindList);
		int pageNum=(kindService.countApplyKindAll()/count)+1;
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageNow",page);
		int hasPage=1;
		model.addAttribute("hasPage",hasPage);
		return "applykind/Table";
	}
	
	//查看子分类
	@RequestMapping("/toKindByPid")
	public String toKindByPid(Model model,@RequestParam("id")Integer id,@RequestParam(value="page",required=false,defaultValue="1")Integer page,@RequestParam(value="count",required=false,defaultValue="5")Integer count) throws Exception{
		List<ApplyKind> kindList=kindService.getApplyKindByPid(id);
		model.addAttribute("kindList",kindList);
		int pageNum=(kindService.countApplyKindAll()/count)+1;
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageNow",page);
		int hasPage=0;
		model.addAttribute("hasPage",hasPage);
		return "applykind/Table";
	}
	
	//跳转到修改表单
	@RequestMapping("/toEdit")
	public String toEdit(Model model,@RequestParam("id")Integer id)throws Exception{
		ApplyKind kind=kindService.getApplyKindById(id);
		model.addAttribute("kind", kind);
		List<ApplyKind> pKinds=kindService.getApplyKindFirstAndSecond();
		model.addAttribute("pKinds",pKinds);
		return "applyKind/EditForm";
	}

	//修改分类信息
	@RequestMapping("/updateApplyKindOne")
	public String updateApplyKindOne(Model model,ApplyKind applyKind)throws Exception{
		kindService.updateApplyKindOne(applyKind);
		return "redirect:toTable";
	}
	
	//根据ID删除单个分类
	@RequestMapping("/delApplyKindOneById")
	public String delApplyKindOneById(@RequestParam("id")List<Integer> idList)throws Exception{
		kindService.delApplyKindListById(idList);
		return "redirect:toTable";
	}
	
	//根据ID批量删除分类
	@RequestMapping("/delApplyKindListById")
	public String delApplyKindListById(@RequestParam("id") Integer id)throws Exception{
		kindService.delApplyKindOneById(id);
		return "redirect:toTable";
	}
	
	//启用单个分类
	@RequestMapping("/setApplyKindStatusOn")
	public String setApplyKindStatusOn(@RequestParam("id") Integer id)throws Exception{
		kindService.setApplyKindStatusOn(id);
		return "redirect:toTable";
	}	
	
	//禁用单个分类
	@RequestMapping("/setApplyKindStatusOff")
	public String setApplyKindStatusOff(@RequestParam("id") Integer id)throws Exception{
		kindService.setApplyKindStatusOff(id);
		return "redirect:toTable";
	}
	
	//根据分类名模糊搜索
	@RequestMapping("/getApplyKindByNameLike")
	public String getApplyKindByNameLike(Model model,@RequestParam("keyWord") String keyWord)throws Exception{
		List<ApplyKind> kindList= kindService.getApplyKindByNameLike(keyWord);
		model.addAttribute("kindList",kindList);
		int pageNum=1;
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageNow",1);
		model.addAttribute("hasPage",0);
		return "applykind/Table";
	}
	
	//跳转到添加表单
	@RequestMapping("/toAdd")
	public String toAdd(Model model)throws Exception{
		List<ApplyKind> pKinds=kindService.getApplyKindFirstAndSecond();
		model.addAttribute("pKinds",pKinds);
		return "applyKind/AddForm";
	}
	
	//添加单个分类
	@RequestMapping("/insertApplyKindOne")
	public String insertApplyKindOne(ApplyKind applyKind) throws Exception{
		kindService.insertApplyKindOne(applyKind);
		return "redirect:toTable";
	}
}
