package cn.second.lhj.shiro.mapper;

import cn.second.lhj.shiro.po.SecondSysRolePermission;
import cn.second.lhj.shiro.po.SecondSysRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondSysRolePermissionMapper {
    int countByExample(SecondSysRolePermissionExample example);

    int deleteByExample(SecondSysRolePermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecondSysRolePermission record);

    int insertSelective(SecondSysRolePermission record);

    List<SecondSysRolePermission> selectByExample(SecondSysRolePermissionExample example);

    SecondSysRolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecondSysRolePermission record, @Param("example") SecondSysRolePermissionExample example);

    int updateByExample(@Param("record") SecondSysRolePermission record, @Param("example") SecondSysRolePermissionExample example);

    int updateByPrimaryKeySelective(SecondSysRolePermission record);

    int updateByPrimaryKey(SecondSysRolePermission record);
}