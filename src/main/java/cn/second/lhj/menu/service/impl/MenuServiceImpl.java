package cn.second.lhj.menu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.second.lhj.menu.mapper.MenuMapperExtends;
import cn.second.lhj.menu.po.Menu;
import cn.second.lhj.menu.po.MenuExample;
import cn.second.lhj.menu.service.MenuService;
import cn.second.lhj.menu.vm.MenuVM;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapperExtends menuMapper;

	
	/*-----------------------------------------查询---------------------------------------------*/
	@Override
	public int countMenuAll()throws Exception{
		// TODO 查询所有菜单条数
		return menuMapper.countByExample(null);
	}
	@Override
	public List<Menu> getMenuAll() throws Exception{
		// TODO 查询所有菜单
		return menuMapper.selectByExample(null);
	}
	@Override
	public List<Menu> getMenuLimit(Integer page,Integer count)throws Exception{
		// TODO 分页查询菜单
		PageHelper.startPage(page,count);
		return menuMapper.selectByExample(null);
	}
	@Override
	public List<MenuVM> getMenuVMAll() throws Exception {
		// TODO 查询所有已启用菜单并包装成vm
		MenuExample example=new MenuExample();
		MenuExample.Criteria criteria=example.createCriteria();
		criteria.andPIdEqualTo(0);
		criteria.andStatusEqualTo(1);
		List<Menu> menus=menuMapper.selectByExample(example);
		List<MenuVM> vms=new ArrayList<>();
		MenuVM menuVM=null;
		for(Menu menu:menus) {
			menuVM=new MenuVM();
			//System.out.println(menuVM);
			BeanUtils.copyProperties(menu, menuVM);
			List<Menu> sub=getMenuEnableByPid(menu.getId());
			//System.out.println(sub);
			menuVM.setMenus(sub);
			vms.add(menuVM);
		}
		return vms;
	}

	@Override
	public List<Menu> getMenuEnable() throws Exception {
		// TODO 查询已启用菜单
		MenuExample example=new MenuExample();
		MenuExample.Criteria criteria=example.createCriteria();
		criteria.andStatusEqualTo(1);
		return menuMapper.selectByExample(example);
	}

	@Override
	public List<Menu> getMenuNotEnable() throws Exception {
		// TODO 查询未启用菜单
		MenuExample example=new MenuExample();
		MenuExample.Criteria criteria=example.createCriteria();
		criteria.andStatusEqualTo(0);
		return menuMapper.selectByExample(example);
	}

	@Override
	public Menu getMenuById(Integer id) throws Exception {
		// TODO 根据ID查询菜单
		return menuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Menu> getMenuByPid(Integer pid) throws Exception {
		// TODO 根据父级菜单ID查询菜单
		MenuExample example=new MenuExample();
		MenuExample.Criteria criteria=example.createCriteria();
		criteria.andPIdEqualTo(pid);
		return menuMapper.selectByExample(example);
	}

	@Override
	public List<Menu> getMenuEnableByPid(Integer pid) throws Exception {
		// TODO 根据父级菜单查询已启用菜单
		MenuExample example=new MenuExample();
		MenuExample.Criteria criteria=example.createCriteria();
		criteria.andPIdEqualTo(pid);
		criteria.andStatusEqualTo(1);
		return menuMapper.selectByExample(example);
	}

	@Override
	public List<Menu> getMenuNotEnableByPid(Integer pid) throws Exception {
		// TODO 根据父级菜单查询未启用菜单
		// TODO 根据父级菜单查询已启用菜单
		MenuExample example=new MenuExample();
		MenuExample.Criteria criteria=example.createCriteria();
		criteria.andPIdEqualTo(pid);
		criteria.andStatusEqualTo(0);
		return menuMapper.selectByExample(example);
	}
	
	@Override
	public List<Menu> getMenuByKeyWord(String keyWord) throws Exception{
		MenuExample example=new MenuExample();
		MenuExample.Criteria criteria=example.createCriteria();
		criteria.andNameLike("%"+keyWord+"%");
		return menuMapper.selectByExample(example);
	}
	/*-----------------------------------------查询---------------------------------------------*/
	
	
	/*-----------------------------------------添加---------------------------------------------*/
	@Override
	public int insertMenuOne(Menu menu) throws Exception {
		// TODO 添加单个菜单
		try {
			menuMapper.insertSelective(menu);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	/*-----------------------------------------添加---------------------------------------------*/
	

	/*-----------------------------------------删除---------------------------------------------*/
	@Override
	public int deleteMenuOneById(Integer id) throws Exception {
		// TODO 根据菜单ID删除单个菜单
		try {
			menuMapper.deleteByPrimaryKey(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteMenuListById(List<Integer> idList) throws Exception {
		// TODO 根据菜单ID批量删除菜单
		try {
			for(Integer id:idList) {
				menuMapper.deleteByPrimaryKey(id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteMenuByPid(Integer pid) throws Exception {
		// TODO 根据父级菜单ID批量删除菜单
		try {
			MenuExample example=new MenuExample();
			MenuExample.Criteria criteria=example.createCriteria();
			criteria.andPIdEqualTo(pid);
			menuMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteMenuByName(String name) throws Exception {
		// TODO 根据菜单名称删除菜单
		try {
			MenuExample example=new MenuExample();
			MenuExample.Criteria criteria=example.createCriteria();
			criteria.andNameEqualTo(name);
			menuMapper.deleteByExample(example);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	/*-----------------------------------------删除---------------------------------------------*/
	
	

	/*-----------------------------------------修改---------------------------------------------*/
	@Override
	public int updateMenuOne(Menu menu) throws Exception {
		// TODO 修改单个菜单
		try {
			menuMapper.updateByPrimaryKeySelective(menu);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateMenuOneEnable(Integer id) throws Exception {
		// TODO 根据ID启用单个菜单
		try {
			menuMapper.updateMenuStatusById(1, id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int updateMenuListEnable(List<Integer> idList) throws Exception {
		// TODO 根据ID批量启用菜单
		try {
			for(Integer id:idList) {
				menuMapper.updateMenuStatusById(1, id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateMenuOneNotEnable(Integer id) throws Exception {
		// TODO 根据ID禁用单个菜单
		try {
			menuMapper.updateMenuStatusById(0, id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateMenuListNotEnable(List<Integer> idList) throws Exception {
		// TODO 根据ID批量禁用菜单
		try {
			for(Integer id:idList) {
				menuMapper.updateMenuStatusById(0, id);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	/*-----------------------------------------修改---------------------------------------------*/
}
