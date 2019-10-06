package cn.second.lhj.assist.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.second.lhj.assist.po.Menu;
import cn.second.lhj.assist.vm.MenuVM;



@FeignClient(name="second-assist")
public interface MenuFeignInterface {
	
/*----------------------------------------------菜单-----------------------------------------------------*/
	/*-----------------------------------------查询---------------------------------------------*/
	//查询所有菜单条数
	@RequestMapping("/countMenuAll")
	public int countMenuAll()throws Exception;
	//查询所有菜单
	@RequestMapping("/getMenuAll")
	public List<Menu> getMenuAll() throws Exception;
	// 分页查询菜单
	@RequestMapping("/getMenuLimit")
	public List<Menu> getMenuLimit(@RequestParam("page") Integer page,@RequestParam("count") Integer count) throws Exception;
	//查询所有已启用菜单并包装成vm
	@RequestMapping("/getMenuVMAll")
	public List<MenuVM> getMenuVMAll() throws Exception;
	//查询已启用菜单
	@RequestMapping("/getMenuEnable")
	public List<Menu> getMenuEnable() throws Exception;
	//查询未启用菜单
	@RequestMapping("/getMenuNotEnable")
	public List<Menu> getMenuNotEnable() throws Exception;
	//根据ID查询菜单
	@RequestMapping("/getMenuById")
	public Menu getMenuById(@RequestParam("id")Integer id) throws Exception;
	//根据父级菜单ID查询菜单
	@RequestMapping("/getMenuByPid")
	public List<Menu> getMenuByPid(@RequestParam("pid")Integer pid) throws Exception;
	//根据父级菜单查询已启用菜单
	@RequestMapping("/getMenuEnableByPid")
	public List<Menu> getMenuEnableByPid(Integer pid) throws Exception;
	//根据父级菜单查询未启用菜单
	@RequestMapping("/getMenuNotEnableByPid")
	public List<Menu> getMenuNotEnableByPid(Integer pid) throws Exception;
	//根据菜单名称模糊查询
	@RequestMapping("/getMenuByKeyWord")
	public List<Menu> getMenuByKeyWord(@RequestParam("keyWord")String keyWord) throws Exception;
	/*-----------------------------------------查询---------------------------------------------*/

	
	/*-----------------------------------------添加---------------------------------------------*/
	//添加单个菜单
	@RequestMapping("/insertMenuOne")
	public int insertMenuOne(@RequestBody Menu menu) throws Exception;
	/*-----------------------------------------添加---------------------------------------------*/

	
	/*-----------------------------------------删除---------------------------------------------*/
	//根据菜单ID删除单个菜单
	@RequestMapping("/deleteMenuOneById")
	public int deleteMenuOneById(@RequestParam("id")Integer id) throws Exception;
	//根据菜单ID批量删除菜单
	@RequestMapping("/deleteMenuListById")
	public int deleteMenuListById(@RequestParam("idList")List<Integer> idList) throws Exception;
	//根据父级菜单ID批量删除菜单
	@RequestMapping("/deleteMenuByPid")
	public int deleteMenuByPid(@RequestParam("pid") Integer pid) throws Exception;
	//根据菜单名称删除菜单
	@RequestMapping("/deleteMenuByName")
	public int deleteMenuByName(@RequestParam("name") String name) throws Exception;
	/*-----------------------------------------删除---------------------------------------------*/

	
	/*-----------------------------------------修改---------------------------------------------*/
	//修改单个菜单
	@RequestMapping("/updateMenuOne")
	public int updateMenuOne(@RequestBody Menu menu) throws Exception;
	//根据ID启用单个菜单
	@RequestMapping("/updateMenuOneEnable")
	public int updateMenuOneEnable(@RequestParam("id")Integer id) throws Exception;
	//根据ID批量启用菜单
	@RequestMapping("/updateMenuListEnable")
	public int updateMenuListEnable(@RequestParam("idList")List<Integer> idList) throws Exception;
	//根据ID禁用单个菜单
	@RequestMapping("/updateMenuOneNotEnable")
	public int updateMenuOneNotEnable(@RequestParam("id")Integer id)throws Exception;
	//根据ID批量禁用菜单
	@RequestMapping("/updateMenuListNotEnable")
	public int updateMenuListNotEnable(@RequestParam("idList")List<Integer> idList) throws Exception;
	/*-----------------------------------------修改---------------------------------------------*/
/*----------------------------------------------菜单-----------------------------------------------------*/
}
