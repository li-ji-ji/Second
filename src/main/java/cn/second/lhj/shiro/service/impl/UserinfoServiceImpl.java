package cn.second.lhj.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.second.lhj.shiro.mapper.extend.UserInfoMapperExtends;
import cn.second.lhj.shiro.po.SecondUserInfo;
import cn.second.lhj.shiro.po.SecondUserInfoExample;
import cn.second.lhj.shiro.service.UserInfoService;

@Service
public class UserinfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapperExtends userinfoMap;
	
	@Override
	public List<SecondUserInfo> getAll() throws Exception {
		return userinfoMap.selectByExample(null);
	}

	@Override
	public SecondUserInfo getById(Integer id) throws Exception {
		return userinfoMap.selectByPrimaryKey(id);
	}

	@Override
	public int add(SecondUserInfo userInfo) throws Exception {
		return userinfoMap.insertSelective(userInfo);
	}

	@Override
	public int update(SecondUserInfo userInfo) throws Exception {
		return userinfoMap.updateByPrimaryKeySelective(userInfo);
	}

	@Override
	public int delete(Integer id) throws Exception {
		return userinfoMap.deleteByPrimaryKey(id);
	}

/*==============================================查询=================================================*/

	// 根据用户账号查询用户信息
	@Override
	public SecondUserInfo getByUsername(String username) throws Exception{
		SecondUserInfoExample example=new SecondUserInfoExample();
		SecondUserInfoExample.Criteria criteria=example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<SecondUserInfo> users=userinfoMap.selectByExample(example);
		if(users.size()>0) {
			return users.get(0);
		}else {
			return null;
		}
	}
/*==============================================查询=================================================*/

/*==============================================添加=================================================*/

/*==============================================添加=================================================*/

/*==============================================修改=================================================*/

/*==============================================修改=================================================*/

/*==============================================删除=================================================*/

/*==============================================删除=================================================*/

}
