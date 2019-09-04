package cn.second.lhj.authority.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.second.lhj.assist.feign.MenuFeignInterface;
import cn.second.lhj.assist.vm.MenuVM;
import cn.second.lhj.authority.models.Menu;
import cn.second.lhj.authority.models.MenuVo;
import cn.second.lhj.authority.models.SysRole;
import cn.second.lhj.authority.models.UserInfo;
import cn.second.lhj.authority.util.MyShiroUtil;

@RestController
public class DataApi {
	private static final Logger logger = LoggerFactory.getLogger(DataApi.class);
	
	@Autowired
	MenuFeignInterface menuFeign;
	
	
	@RequestMapping(value="/getMenu")
	public List<MenuVo> getMenu(){
		logger.info("getMenu()");
		UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
		List<MenuVo> menuVos = new ArrayList<MenuVo>();
		for(SysRole role:userInfo.getRoleList()) {
			for(Menu menu:role.getMenus()) {
				MyShiroUtil.addMenuVo(menuVos,0,menu);
			}
		}
		return menuVos;
	}
	
	@RequestMapping(value="/allGetMenu")
	public List<MenuVM> toIndex(Model model) throws Exception{
		List<MenuVM> menus=menuFeign.getMenuVMAll();
		return menus;
	}
}
