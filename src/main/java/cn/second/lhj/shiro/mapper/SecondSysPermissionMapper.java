package cn.second.lhj.shiro.mapper;

import cn.second.lhj.shiro.po.SecondSysPermission;
import cn.second.lhj.shiro.po.SecondSysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondSysPermissionMapper {
    int countByExample(SecondSysPermissionExample example);

    int deleteByExample(SecondSysPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecondSysPermission record);

    int insertSelective(SecondSysPermission record);

    List<SecondSysPermission> selectByExample(SecondSysPermissionExample example);

    SecondSysPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecondSysPermission record, @Param("example") SecondSysPermissionExample example);

    int updateByExample(@Param("record") SecondSysPermission record, @Param("example") SecondSysPermissionExample example);

    int updateByPrimaryKeySelective(SecondSysPermission record);

    int updateByPrimaryKey(SecondSysPermission record);
}