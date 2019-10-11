package cn.second.lhj.menu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.second.lhj.menu.po.Menu;
import cn.second.lhj.menu.vm.MenuVM;

/*
 * 	菜单表
 * */

@Service
public interface MenuService {
	
	/*-----------------------------------------查询---------------------------------------------*/
	//查询所有菜单条数
	public int countMenuAll()throws Exception;
	//查询所有菜单 
	public List<Menu> getMenuAll() throws Exception;
	//分页查询所有菜单
	public List<Menu> getMenuLimit(Integer page,Integer count)throws Exception;
	//查询所有已启用菜单并包装成vm
	public List<MenuVM> getMenuVMAll() throws Exception;
	//查询已启用菜单
	public List<Menu> getMenuEnable() throws Exception;
	//查询未启用菜单
	public List<Menu> getMenuNotEnable() throws Exception;
	//根据ID查询菜单
	public Menu getMenuById(Integer id) throws Exception;
	//根据父级菜单ID查询菜单
	public List<Menu> getMenuByPid(Integer pid) throws Exception;
	//根据父级菜单查询已启用菜单
	public List<Menu> getMenuEnableByPid(Integer pid) throws Exception;
	//根据父级菜单查询未启用菜单
	public List<Menu> getMenuNotEnableByPid(Integer pid) throws Exception;
	//根据菜单名称模糊查询
	public List<Menu> getMenuByKeyWord(String keyWord) throws Exception;
	
	/*-----------------------------------------查询---------------------------------------------*/

	
	/*-----------------------------------------添加---------------------------------------------*/
	//添加单个菜单
	public int insertMenuOne(Menu menu) throws Exception;
	/*-----------------------------------------添加---------------------------------------------*/

	
	/*-----------------------------------------删除---------------------------------------------*/
	//根据菜单ID删除单个菜单
	public int deleteMenuOneById(Integer id) throws Exception;
	//根据菜单ID批量删除菜单
	public int deleteMenuListById(List<Integer> idList) throws Exception;
	//根据父级菜单ID批量删除菜单
	public int deleteMenuByPid(Integer pid) throws Exception;
	//根据菜单名称删除菜单
	public int deleteMenuByName(String name) throws Exception;
	/*-----------------------------------------删除---------------------------------------------*/

	
	/*-----------------------------------------修改---------------------------------------------*/
	//修改单个菜单
	public int updateMenuOne(Menu menu) throws Exception;
	//根据ID启用单个菜单
	public int updateMenuOneEnable(Integer id) throws Exception;
	//根据ID批量启用菜单
	public int updateMenuListEnable(List<Integer> idList) throws Exception;
	//根据ID禁用单个菜单
	public int updateMenuOneNotEnable(Integer id)throws Exception;
	//根据ID批量禁用菜单
	public int updateMenuListNotEnable(List<Integer> idList) throws Exception;
	/*-----------------------------------------修改---------------------------------------------*/
	
}
