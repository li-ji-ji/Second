package cn.second.lhj.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.second.lhj.assist.feign.MenuFeignInterface;
import cn.second.lhj.authority.models.Menu;
import cn.second.lhj.authority.models.MenuVo;
import cn.second.lhj.authority.models.SysRole;
import cn.second.lhj.authority.models.UserInfo;
import cn.second.lhj.authority.util.MyShiroUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	MenuFeignInterface menuFeign;
	
	@RequestMapping("/toIndex")
	public String toIndex(Model model) throws Exception{
		UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
		List<MenuVo> menuVos = new ArrayList<MenuVo>();
		for(SysRole role:userInfo.getRoleList()) {
			for(Menu menu:role.getMenus()) {
				MyShiroUtil.addMenuVo(menuVos,0,menu);
			}
		}
		model.addAttribute("menus",menuVos);
		return "admin/index";
	}
	
	//跳转到欢迎页
	@RequestMapping("/toWelcome")
	public String toWelcome(@RequestParam("name") String name,Model model)throws Exception{
		model.addAttribute("name", name);
		return "admin/welcome";
	}
}
