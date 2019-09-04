package cn.second.lhj.authority.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import cn.second.lhj.authority.models.UserInfo;

@Component
public interface TestMapper {
	@Select({ "select * from user_info where uid = #{id}" })
	UserInfo selectById(int id);
}
