package cn.second.lhj.shiro.utils;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.second.lhj.shiro.po.SecondUserInfo;
import cn.second.lhj.shiro.service.UserInfoService;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserInfoService userInfoServ;
	
	/*
	 *	执行授权逻辑 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		System.out.println("执行授权逻辑 ");
		//给资源进行授权
		SimpleAuthorizationInfo info= new SimpleAuthorizationInfo();
		//添加资源的授权字符串
		info.addStringPermission("admin:view");
		return info;
	}

	/*
	 *	执行认证逻辑 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken getToken) throws AuthenticationException {
//		System.out.println("执行认证逻辑");
		UsernamePasswordToken token=(UsernamePasswordToken)getToken;
		SecondUserInfo userInfo=new SecondUserInfo();
		// 编写shiro判断逻辑，判断用户名和密码
		// 1.判断用户名
		try {
			userInfo = userInfoServ.getByUsername(token.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(userInfo==null) {
			// 用户名不存在
			return null;//shiro底层抛出UnKnowAccountException
		}
		// 2.判断密码
		return new SimpleAuthenticationInfo("",userInfo.getPassword(),"");
	}
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        logger.info("##################执行Shiro权限认证##################");
//        UUser user = (UUser) principalCollection.getPrimaryPrincipal();
//        if (user != null) {
//            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            //用户的角色集合
//            info.addRoles(user.getRoleStrlist());
//            //用户的权限集合
//            info.addStringPermissions(user.getPerminsStrlist());
//
//            return info;
//        }
//        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
//        return null;
//    }
}
