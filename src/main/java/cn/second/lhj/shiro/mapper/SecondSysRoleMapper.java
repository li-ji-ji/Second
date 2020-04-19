package cn.second.lhj.shiro.mapper;

import cn.second.lhj.shiro.po.SecondSysRole;
import cn.second.lhj.shiro.po.SecondSysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondSysRoleMapper {
    int countByExample(SecondSysRoleExample example);

    int deleteByExample(SecondSysRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecondSysRole record);

    int insertSelective(SecondSysRole record);

    List<SecondSysRole> selectByExample(SecondSysRoleExample example);

    SecondSysRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecondSysRole record, @Param("example") SecondSysRoleExample example);

    int updateByExample(@Param("record") SecondSysRole record, @Param("example") SecondSysRoleExample example);

    int updateByPrimaryKeySelective(SecondSysRole record);

    int updateByPrimaryKey(SecondSysRole record);
}