package cn.second.lhj.apply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

import cn.second.lhj.apply.feign.ApplyFeignInterface;
import cn.second.lhj.apply.po.ApplyKind;

@Controller
@RequestMapping("/applyKind")
public class ApplyKindController {

	@Autowired
	private ApplyFeignInterface kindFeign;
	
	//跳转到分类表格
	@RequestMapping("/toTable")
	public String toTable(Model model,@RequestParam(value="page",required=false,defaultValue="1")Integer page,@RequestParam(value="count",required=false,defaultValue="5")Integer count) throws Exception{
		List<ApplyKind> kindList=kindFeign.getApplyKindAllLimit(page, count);
		model.addAttribute("kindList",kindList);
		int pageNum=(kindFeign.countApplyKindAll()/count)+1;
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageNow",page);
		int hasPage=1;
		model.addAttribute("hasPage",hasPage);
		return "applykind/Table";
	}
	
	//查看子分类
	@RequestMapping("/toKindByPid")
	public String toKindByPid(Model model,@RequestParam("id")Integer id,@RequestParam(value="page",required=false,defaultValue="1")Integer page,@RequestParam(value="count",required=false,defaultValue="5")Integer count) throws Exception{
		List<ApplyKind> kindList=kindFeign.getApplyKindByPid(id);
		model.addAttribute("kindList",kindList);
		int pageNum=(kindFeign.countApplyKindAll()/count)+1;
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageNow",page);
		int hasPage=0;
		model.addAttribute("hasPage",hasPage);
		return "applykind/Table";
	}
	
	//跳转到修改表单
	@RequestMapping("/toEdit")
	public String toEdit(Model model,@RequestParam("id")Integer id)throws Exception{
		ApplyKind kind=kindFeign.getApplyKindById(id);
		model.addAttribute("kind", kind);
		List<ApplyKind> pKinds=kindFeign.getApplyKindFirstAndSecond();
		model.addAttribute("pKinds",pKinds);
		return "applyKind/EditForm";
	}

	//修改分类信息
	@RequestMapping("/updateApplyKindOne")
	public String updateApplyKindOne(Model model,ApplyKind applyKind)throws Exception{
		kindFeign.updateApplyKindOne(applyKind);
		return "redirect:toTable";
	}
	
	//根据ID删除单个分类
	@RequestMapping("/delApplyKindOneById")
	public String delApplyKindOneById(@RequestParam("id")List<Integer> idList)throws Exception{
		kindFeign.delApplyKindListById(idList);
		return "redirect:toTable";
	}
	
	//根据ID批量删除分类
	@RequestMapping("/delApplyKindListById")
	public String delApplyKindListById(@RequestParam("id") Integer id)throws Exception{
		kindFeign.delApplyKindOneById(id);
		return "redirect:toTable";
	}
	
	//启用单个分类
	@RequestMapping("/setApplyKindStatusOn")
	public String setApplyKindStatusOn(@RequestParam("id") Integer id)throws Exception{
		kindFeign.setApplyKindStatusOn(id);
		return "redirect:toTable";
	}	
	
	//禁用单个分类
	@RequestMapping("/setApplyKindStatusOff")
	public String setApplyKindStatusOff(@RequestParam("id") Integer id)throws Exception{
		kindFeign.setApplyKindStatusOff(id);
		return "redirect:toTable";
	}
	
	//根据分类名模糊搜索
	@RequestMapping("/getApplyKindByNameLike")
	public String getApplyKindByNameLike(Model model,@RequestParam("keyWord") String keyWord)throws Exception{
		List<ApplyKind> kindList= kindFeign.getApplyKindByNameLike(keyWord);
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
		List<ApplyKind> pKinds=kindFeign.getApplyKindFirstAndSecond();
		model.addAttribute("pKinds",pKinds);
		return "applyKind/AddForm";
	}
	
	//添加单个分类
	@RequestMapping("/insertApplyKindOne")
	public String insertApplyKindOne(ApplyKind applyKind) throws Exception{
		kindFeign.insertApplyKindOne(applyKind);
		return "redirect:toTable";
	}
}
