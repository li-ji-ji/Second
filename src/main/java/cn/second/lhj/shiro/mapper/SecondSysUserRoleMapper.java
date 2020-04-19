package cn.second.lhj.shiro.mapper;

import cn.second.lhj.shiro.po.SecondSysUserRole;
import cn.second.lhj.shiro.po.SecondSysUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondSysUserRoleMapper {
    int countByExample(SecondSysUserRoleExample example);

    int deleteByExample(SecondSysUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecondSysUserRole record);

    int insertSelective(SecondSysUserRole record);

    List<SecondSysUserRole> selectByExample(SecondSysUserRoleExample example);

    SecondSysUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecondSysUserRole record, @Param("example") SecondSysUserRoleExample example);

    int updateByExample(@Param("record") SecondSysUserRole record, @Param("example") SecondSysUserRoleExample example);

    int updateByPrimaryKeySelective(SecondSysUserRole record);

    int updateByPrimaryKey(SecondSysUserRole record);
}