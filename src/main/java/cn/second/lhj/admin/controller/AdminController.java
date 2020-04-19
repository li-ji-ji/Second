 package cn.second.lhj.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.second.lhj.log.Log;
import cn.second.lhj.menu.service.MenuService;
import cn.second.lhj.menu.vm.MenuVM;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/toIndex")
	@Log(value="进入管理员后台主页")
	public String toIndex(Model model) throws Exception{
		List<MenuVM> menus=menuService.getMenuVMAll();
		//System.out.println(menus.toString());
		model.addAttribute("menus",menus);
		return "admin/index";
	}
	
	//跳转到欢迎页
	@RequestMapping("/toWelcome")
	public String toWelcome(@RequestParam("name") String name,Model model)throws Exception{
		model.addAttribute("name", name);
		return "admin/welcome";
	}

}
