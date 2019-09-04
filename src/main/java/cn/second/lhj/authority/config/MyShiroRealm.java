package cn.second.lhj.authority.config;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.second.lhj.authority.models.SysPermission;
import cn.second.lhj.authority.models.SysRole;
import cn.second.lhj.authority.models.UserInfo;
import cn.second.lhj.authority.service.UserInfoService;

public class MyShiroRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

	@Resource
	private UserInfoService userInfoService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
		//Set<String> roles=new HashSet<String>();
		List<SysRole> roleList = userInfo.getRoleList();
		if(roleList.size() > 0 ) {
			for (SysRole role : roleList) {
				//roles.add(role.getRole());
				authorizationInfo.addRole(role.getRole());
				for (SysPermission p : role.getPermissions()) {
					authorizationInfo.addStringPermission(p.getPermission());
				}
			}
		}
		//authorizationInfo.setRoles(roles);
		return authorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户的输入的账号.
		String username = (String) token.getPrincipal();
		logger.info("doGetAuthenticationInfo: --> username="+username);
//		System.out.println(token.getCredentials());
		// 通过username从数据库中查找 User对象，如果找到，没找到.
		// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		UserInfo userInfo = userInfoService.findByUsername(username);
		logger.info("doGetAuthenticationInfo: --> userInfo="+userInfo);
		if (userInfo == null) {
			return null;
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, // 用户名
				userInfo.getPassword(), // 密码
				ByteSource.Util.bytes(userInfo.getCredentialsSalt()), // salt=username+salt
				getName() // realm name
		);
		return authenticationInfo;
	}

}
