package cn.second.lhj.shiro.mapper;

import cn.second.lhj.shiro.po.SecondUserInfo;
import cn.second.lhj.shiro.po.SecondUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondUserInfoMapper {
    int countByExample(SecondUserInfoExample example);

    int deleteByExample(SecondUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecondUserInfo record);

    int insertSelective(SecondUserInfo record);

    List<SecondUserInfo> selectByExample(SecondUserInfoExample example);

    SecondUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecondUserInfo record, @Param("example") SecondUserInfoExample example);

    int updateByExample(@Param("record") SecondUserInfo record, @Param("example") SecondUserInfoExample example);

    int updateByPrimaryKeySelective(SecondUserInfo record);

    int updateByPrimaryKey(SecondUserInfo record);
}