package cn.second.lhj.asso.mapper;

import cn.second.lhj.asso.po.CspAssoSchool;
import cn.second.lhj.asso.po.CspAssoSchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CspAssoSchoolMapper {
    int countByExample(CspAssoSchoolExample example);

    int deleteByExample(CspAssoSchoolExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CspAssoSchool record);

    int insertSelective(CspAssoSchool record);

    List<CspAssoSchool> selectByExample(CspAssoSchoolExample example);

    CspAssoSchool selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CspAssoSchool record, @Param("example") CspAssoSchoolExample example);

    int updateByExample(@Param("record") CspAssoSchool record, @Param("example") CspAssoSchoolExample example);

    int updateByPrimaryKeySelective(CspAssoSchool record);

    int updateByPrimaryKey(CspAssoSchool record);
}