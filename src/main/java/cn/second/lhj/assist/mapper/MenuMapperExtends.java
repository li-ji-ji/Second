package cn.second.lhj.assist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.second.lhj.assist.po.Menu;

public interface MenuMapperExtends extends MenuMapper {
	
	//根据父级菜单ID和状态查询菜单
	@Select("select * from menu where p_id=#{pid} and status=#{status}")
	public List<Menu> getMenuListByPidAndStatus(Integer pid,Integer status) throws Exception;

	@Results({@Result(property="pId",column="p_id"),@Result(property="pName",column="p_name")})
	//根据菜单名称关键字进行模糊搜索
	@Select("select * from menu where name like CONCAT('%',#{keyWord},'%')")
	public List<Menu> getMenuByKeyWord(String keyWord)throws Exception;
	
	//根据菜单ID更改菜单启用状态
	@Update("update menu set status=#{status} where id=#{id}")
	public int updateMenuStatusById(Integer status,Integer id) throws Exception;
	
}
