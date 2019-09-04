package cn.second.lhj.authority.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.second.lhj.authority.mapper.MenuMapper;
import cn.second.lhj.authority.mapper.SysMenuMapper;
import cn.second.lhj.authority.models.Menu;
import cn.second.lhj.authority.models.MenuVo;



public class MyShiroUtil {
	private static final Logger logger = LoggerFactory.getLogger(MyShiroUtil.class);
	
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Autowired
	private MenuMapper menuMapper;
	/**
	 * 增加一个菜单节点
	 * @param menuVos
	 * @param p
	 * @param menu
	 */
	public static void addMenuVo(List<MenuVo> menuVos, Integer p, Menu menu) {
		MyShiroUtil myShiroUtil = new MyShiroUtil();
		if(myShiroUtil.addMenuVoAtMenuVos(menuVos,0,menu) == 0) {
			//没有找到直接父节点的时候
			MenuVo menuVo = myShiroUtil.sysMenuToMenuTo(menu);
			menuVo = myShiroUtil.createSub(menuVo,p);
			menuVos.add(menuVo);
		}
	}
	
	/**
	 * 递归创建一个到level+1级的菜单
	 * @param menuVo
	 * @param Level
	 * @return
	 */
	public MenuVo createSub(MenuVo menuVo,int Level) {
		if(menuVo.getpId() == Level) {
			return menuVo;
		}
		List<MenuVo> children = new ArrayList<MenuVo>();
		children.add(menuVo);
		MenuVo menu = createSub(sysMenuToMenuTo(menuMapper.selectByPrimaryKey(menuVo.getpId())),Level);
		menu.setMenus(children);
		return menu;
	}

	/**
	 * 将菜单添加到显示menuVos去 使用递归算法 
	 * 存在pid菜单的情况
	 * @param menuVos 树
	 * @param p 这个树的父id
	 * @param menu 待插入的节点
	 * @return
	 * 1：添加成功
	 * 0：添加失败
	 * -1：该节点原先存在
	 */
	public int addMenuVoAtMenuVos(List<MenuVo> menuVos, Integer p, Menu menu) {
		int isP = 0;
		if (menu.getpId() == p) {
			// 找到了上一个节点
			for (MenuVo menuVo : menuVos) {
				if (menuVo.getId() == menu.getId()) {
					return -1;//已存在
				}
			}
			if(menuVos.add(sysMenuToMenuTo(menu))) {
				return 1;//成功
			}
		} else {
			for (int i = 0; i < menuVos.size(); i++) {
				if(menuVos.get(i).getMenus() == null) {
					if(menuVos.get(i).getId() != menu.getpId()) {
						return 0;
					}
					menuVos.get(i).setMenus(new ArrayList<MenuVo>());
				}
				isP = addMenuVoAtMenuVos(menuVos.get(i).getMenus(),menuVos.get(i).getId(),menu);
				if(isP == 1 || isP == -1) {
					return isP;
				}
			}
		}
		return isP;
	}

	/**
	 * //将数据库的菜单（sysMenu）转换成一般用于前端展示使用的菜单（MenuVo）
	 * 
	 * @param menu
	 * @return
	 */
	public MenuVo sysMenuToMenuTo(Menu menu) {
		MenuVo menuVo = new MenuVo();
		menuVo.setId(menu.getId());
		menuVo.setpId(menu.getpId());
		menuVo.setName(menu.getName());
		menuVo.setpName(menu.getpName());
		menuVo.setUrl(menu.getUrl());
		menuVo.setStatus(menu.getStatus());
		return menuVo;
	}
}
