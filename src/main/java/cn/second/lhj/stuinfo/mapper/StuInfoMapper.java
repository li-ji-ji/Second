package cn.second.lhj.stuinfo.mapper;

import cn.second.lhj.stuinfo.po.StuInfo;
import cn.second.lhj.stuinfo.po.StuInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuInfoMapper {
    int countByExample(StuInfoExample example);

    int deleteByExample(StuInfoExample example);

    int deleteByPrimaryKey(String stuId);

    int insert(StuInfo record);

    int insertSelective(StuInfo record);

    List<StuInfo> selectByExample(StuInfoExample example);

    StuInfo selectByPrimaryKey(String stuId);

    int updateByExampleSelective(@Param("record") StuInfo record, @Param("example") StuInfoExample example);

    int updateByExample(@Param("record") StuInfo record, @Param("example") StuInfoExample example);

    int updateByPrimaryKeySelective(StuInfo record);

    int updateByPrimaryKey(StuInfo record);
}