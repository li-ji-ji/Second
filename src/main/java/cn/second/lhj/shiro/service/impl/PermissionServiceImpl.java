package cn.second.lhj.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.second.lhj.shiro.mapper.extend.SysPermissionMapperExtends;
import cn.second.lhj.shiro.po.SecondSysPermission;
import cn.second.lhj.shiro.po.SecondSysPermissionExample;
import cn.second.lhj.shiro.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private SysPermissionMapperExtends permMapper;
	
	@Override
	public List<SecondSysPermission> getAll() throws Exception {
		return permMapper.selectByExample(null);
	}

	@Override
	public SecondSysPermission getById(Integer id) throws Exception {
		return permMapper.selectByPrimaryKey(id);
	}

	@Override
	public int add(SecondSysPermission perm) throws Exception {
		return permMapper.insertSelective(perm);
	}

	@Override
	public int update(SecondSysPermission perm) throws Exception {
		return permMapper.updateByPrimaryKeySelective(perm);
	}

	@Override
	public int delete(Integer id) throws Exception {
		return permMapper.deleteByPrimaryKey(id);
	}


/*==============================================查询=================================================*/
	

	// 查询已启用权限
	@Override
	public List<SecondSysPermission> getAblePerms() throws Exception{
		SecondSysPermissionExample example = new SecondSysPermissionExample();
		SecondSysPermissionExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);
		return permMapper.selectByExample(example);
	}
	
/*==============================================查询=================================================*/

/*==============================================添加=================================================*/

/*==============================================添加=================================================*/

/*==============================================修改=================================================*/

/*==============================================修改=================================================*/

/*==============================================删除=================================================*/

/*==============================================删除=================================================*/

}
