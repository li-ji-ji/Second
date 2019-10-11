package cn.second.lhj.applykind.mapper;

import cn.second.lhj.applykind.po.ApplyKind;
import cn.second.lhj.applykind.po.ApplyKindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyKindMapper {
    int countByExample(ApplyKindExample example);

    int deleteByExample(ApplyKindExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplyKind record);

    int insertSelective(ApplyKind record);

    List<ApplyKind> selectByExample(ApplyKindExample example);

    ApplyKind selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplyKind record, @Param("example") ApplyKindExample example);

    int updateByExample(@Param("record") ApplyKind record, @Param("example") ApplyKindExample example);

    int updateByPrimaryKeySelective(ApplyKind record);

    int updateByPrimaryKey(ApplyKind record);
}