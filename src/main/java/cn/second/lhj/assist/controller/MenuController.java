package cn.second.lhj.assist.controller;

import java.util.List;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.second.lhj.assist.feign.MenuFeignInterface;
import cn.second.lhj.assist.po.Menu;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuFeignInterface menuFeign;
	
	//跳转到菜单表格
	@RequestMapping("/toTable")
	public String toTable(Model model,@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "count", required = false, defaultValue = "5") Integer count)throws Exception{
		List<Menu> menus=menuFeign.getMenuLimit(page,count);
		model.addAttribute("menus",menus);
		int pageNum=(menuFeign.countMenuAll()/count)+1;
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageNow",page);
		int hasPage=1;
		model.addAttribute("hasPage",hasPage);
		return "menu/Table";
	}
	
	//跳转到菜单修改表单
	@RequestMapping("/toEdit")
	public String toEdit(Model model,@RequestParam("id")Integer id)throws Exception{
		Menu menu=menuFeign.getMenuById(id);
		model.addAttribute("menu",menu);
		List<Menu> pMenus=menuFeign.getMenuByPid(0);
		model.addAttribute("pMenus",pMenus);
		return "menu/EditForm";
	}
	
	//提交菜单信息修改
	@RequestMapping("/updateMenuOne")
	public String updateMenuOne(Menu menu)throws Exception{
		//System.out.println(menu.getStatus());
		if(menu.getStatus()==null) {
			menu.setStatus(0);
		}
		menuFeign.updateMenuOne(menu);
		return "redirect:toTable";
	}
	
	//跳转到添加表单
	@RequestMapping("/toAdd")
	public String toAdd(Model model) throws Exception{
		List<Menu> pMenus=menuFeign.getMenuByPid(0);
		model.addAttribute("pMenus",pMenus);
		return "menu/AddForm";
	}
	
	//提交菜单信息添加
	@RequestMapping("/insertMenuOne")
	public String insertMenuOne(Menu menu)throws Exception{
		//System.out.println(menu.getStatus());
		if(menu.getStatus()==null) {
			menu.setStatus(0);
		}
		menuFeign.insertMenuOne(menu);
		return "redirect:toTable";
	}
	
	//禁用单个菜单
	@RequestMapping("/updateMenuOneNotEnable")
	public String updateMenuOneNotEnable(@RequestParam("id") Integer id) throws Exception{
		menuFeign.updateMenuOneNotEnable(id);
		return "redirect:toTable";
	}
	
	//启用单个菜单
	@RequestMapping("/updateMenuOneEnable")
	public String updateMenuOneEnable(@RequestParam("id") Integer id) throws Exception{
		menuFeign.updateMenuOneEnable(id);
		return "redirect:toTable";
	}
	
	//删除单个菜单
	@RequestMapping("/deleteMenuOne")
	public String deleteMenuOne(@RequestParam("id") Integer id) throws Exception{
		menuFeign.deleteMenuOneById(id);
		return "redirect:toTable";
	}
	
	//批量删除菜单
	@RequestMapping("/deleteMenuListById")
	public String deleteMenuListById(@RequestParam("id")List<Integer> idList)throws Exception{
		menuFeign.deleteMenuListById(idList);
		return "redirect:toTable";
	}
	
	//根据菜单名称模糊查询
	@RequestMapping("/getMenuByKeyWord")
	public String getMenuByKeyWord(Model model,@RequestParam("keyWord")String keyWord) throws Exception{
		List<Menu> menus=menuFeign.getMenuByKeyWord(keyWord);
		model.addAttribute("menus",menus);
		int pageNum=1;
		int page=1;
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageNow",page);
		int hasPage=0;
		model.addAttribute("hasPage",hasPage);
		return "menu/Table";
	}
	
	//查看子菜单
	@RequestMapping("/getMenuByPid")
	public String getMenuByPid(Model model,@RequestParam("id")Integer id)throws Exception{
		List<Menu> menus=menuFeign.getMenuByPid(id);
		model.addAttribute("menus", menus);
		int pageNum=1;
		int page=1;
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("pageNow",page);
		int hasPage=0;
		model.addAttribute("hasPage",hasPage);
		return "menu/Table";
	}
}
