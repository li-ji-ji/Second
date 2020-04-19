package cn.second.lhj.shiro.config;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.second.lhj.shiro.po.SecondSysPermission;
import cn.second.lhj.shiro.service.PermissionService;
import cn.second.lhj.shiro.utils.UserRealm;

@Configuration
public class ShiroConfig {

	@Autowired
	private PermissionService permServ;
	
	/*
	 * 创建ShiroFilterFactoryBean
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) throws Exception {
		ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
		// 查询所有权限
		List<SecondSysPermission> perms=permServ.getAblePerms();
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//添加shiro内置过滤器
		/*
		 * shiro内置过滤器，可以实现权限相关的拦截器
		 * 常用过滤器：
		 *		anon：无需认证（登录）即可访问的资源
		 *		authc：必须认证才可以访问的资源
		 *		user：如果使 用rememberMe的功能才可以直接访问
		 *		perms：该资源必须得到资源权限才可以访问
		 *		role：该资源必须得到角色权限才可以访问
		 */
		Map<String,String> filterMap=new LinkedHashMap<String,String>();
//		filterMap.put("/admin/add", "authc");
//		filterMap.put("/admin/update","authc");
		// 或可通过数据库查询注入路径访问权限，达成后台界面管理访问权限
		filterMap.put("/api/*","anon");
		filterMap.put("/login/*","anon");
		// 授权过滤器
		for(SecondSysPermission perm:perms) {
			filterMap.put(perm.getUrl(),"perms["+perm.getPermission()+"]");
		}
//		filterMap.put("/admin/toIndex", "perms[user:admin/toIndex]");
		//拦截所有必须写在最后，否则拦截所有资源！！！！！！！
		filterMap.put("/*", "authc");
		//修改跳转的登录页面
		shiroFilterFactoryBean.setLoginUrl("/login/toLogin");
		// 设置未授权提示页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/login/to401");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}
	
	
	/*
	 * 创建DefaultWebSecurityManager 
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {		
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		//关联realm
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	
	
	/*
	 * 创建realm
	 */
	@Bean(name="userRealm")
	public UserRealm getRealm() throws Exception{
		return new UserRealm();
	}
}
