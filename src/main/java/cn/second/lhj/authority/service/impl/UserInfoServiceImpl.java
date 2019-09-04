package cn.second.lhj.authority.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.second.lhj.authority.mapper.MenuMapper;
import cn.second.lhj.authority.mapper.SysMenuMapper;
import cn.second.lhj.authority.mapper.SysPermissionMapper;
import cn.second.lhj.authority.mapper.SysRoleMenuMapper;
import cn.second.lhj.authority.mapper.SysRolePermissionMapper;
import cn.second.lhj.authority.mapper.UserInfoMapper;
import cn.second.lhj.authority.models.Menu;
import cn.second.lhj.authority.models.SysPermission;
import cn.second.lhj.authority.models.SysRole;
import cn.second.lhj.authority.models.SysRoleMenu;
import cn.second.lhj.authority.models.SysRoleMenuExample;
import cn.second.lhj.authority.models.SysRolePermission;
import cn.second.lhj.authority.models.SysRolePermissionExample;
import cn.second.lhj.authority.models.UserInfo;
import cn.second.lhj.authority.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private SysRolePermissionMapper sysRolePermissionMapper;
	
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;

	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public UserInfo findByUsername(String username) {
		UserInfo userInfo = userInfoMapper.selectUserRolePermissionByUsername(username);
		UserInfo userInfoBak = userInfo;
		//添加用户权限
		for(int i = 0; i < userInfo.getRoleList().size(); i++) {
			SysRole role = userInfo.getRoleList().get(i);
			Integer roleId = role.getId();
			/**
			 * permission
			 */
			SysRolePermissionExample sysRolePermissionExample = new SysRolePermissionExample();
			sysRolePermissionExample.setDistinct(true);// 去除重复,true是选择不重复记录,false反之
			SysRolePermissionExample.Criteria criteria = sysRolePermissionExample.createCriteria();// 构造自定义查询条件
			criteria.andRoleIdEqualTo(roleId);
			List<SysRolePermission> SysRolePermissions = sysRolePermissionMapper
					.selectByExample(sysRolePermissionExample);
			List<SysPermission> sysPermissionList = new ArrayList<SysPermission>();
			for (SysRolePermission s : SysRolePermissions) {
				Integer pId = s.getPermissionId();
				SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(pId);
				sysPermissionList.add(sysPermission);
			}
			userInfo.getRoleList().get(i).setPermissions(sysPermissionList);
			
			/**
			 * menu
			 */
			/*
			 * SysRoleMenuExample sysRoleMenuExample = new SysRoleMenuExample();
			 * sysRoleMenuExample.setDistinct(true); SysRoleMenuExample.Criteria
			 * roleMenuCriteria = sysRoleMenuExample.createCriteria();
			 * roleMenuCriteria.andRoleIdEqualTo(roleId); List<SysRoleMenu> SysRoleMenus =
			 * sysRoleMenuMapper .selectByExample(sysRoleMenuExample); List<SysMenu>
			 * sysMenuList = new ArrayList<SysMenu>(); for (SysRoleMenu m : SysRoleMenus) {
			 * SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(m.getMenuId());
			 * sysMenuList.add(sysMenu); }
			 * 
			 * userInfo.getRoleList().get(i).setMenus(sysMenuList);
			 */
			SysRoleMenuExample sysRoleMenuExample = new SysRoleMenuExample();
			sysRoleMenuExample.setDistinct(true);
			SysRoleMenuExample.Criteria roleMenuCriteria = sysRoleMenuExample.createCriteria();
			roleMenuCriteria.andRoleIdEqualTo(roleId);
			List<SysRoleMenu> SysRoleMenus = sysRoleMenuMapper
					.selectByExample(sysRoleMenuExample);
			List<Menu> menuList = new ArrayList<Menu>();
			for (SysRoleMenu m : SysRoleMenus) {
				Menu menu = menuMapper.selectByPrimaryKey(m.getMenuId());
				menuList.add(menu);
			}
			
			userInfo.getRoleList().get(i).setMenus(menuList);
		}
		
		return userInfo;
	}
	
}
