package cn.second.lhj.authority.mapper;

import cn.second.lhj.authority.models.SysRolePermission;
import cn.second.lhj.authority.models.SysRolePermissionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysRolePermissionMapper {
    long countByExample(SysRolePermissionExample example);

    int deleteByExample(SysRolePermissionExample example);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);
}