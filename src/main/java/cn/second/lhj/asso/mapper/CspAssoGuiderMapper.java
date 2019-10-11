package cn.second.lhj.asso.mapper;

import cn.second.lhj.asso.po.CspAssoGuider;
import cn.second.lhj.asso.po.CspAssoGuiderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CspAssoGuiderMapper {
    int countByExample(CspAssoGuiderExample example);

    int deleteByExample(CspAssoGuiderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CspAssoGuider record);

    int insertSelective(CspAssoGuider record);

    List<CspAssoGuider> selectByExample(CspAssoGuiderExample example);

    CspAssoGuider selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CspAssoGuider record, @Param("example") CspAssoGuiderExample example);

    int updateByExample(@Param("record") CspAssoGuider record, @Param("example") CspAssoGuiderExample example);

    int updateByPrimaryKeySelective(CspAssoGuider record);

    int updateByPrimaryKey(CspAssoGuider record);
}