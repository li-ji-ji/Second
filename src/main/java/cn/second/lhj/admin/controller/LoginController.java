package cn.second.lhj.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import cn.second.lhj.shiro.po.SecondUserInfo;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	//跳转到管理员登录页
	@RequestMapping("/toLogin")
	public String toLogin(Model model)throws Exception{
		return "admin/login";
	}
	
	//管理员登录逻辑处理
	@RequestMapping("/login")
	public String login(String username,String password,RedirectAttributesModelMap model,HttpServletRequest request ,HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		/*
		 *	使用shiro编写认证操作 
		 */
		// 1.获取Subject
		Subject subject=SecurityUtils.getSubject();
		// 2.封装用户数据
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		// 3.执行登录方法
		try {
			subject.login(token);
			SecondUserInfo userInfo=new SecondUserInfo();
			userInfo.setUsername(token.getUsername());
            session.setAttribute("UserInfo", userInfo);
            //设置session时效
            session.setMaxInactiveInterval(30*60);
			// 登录成功
			return "redirect:/admin/toIndex";
		} catch (UnknownAccountException e) {
			//e.printStackTrace();
			//登录失败
			model.addFlashAttribute("msg","用户名不存在");
			return "redirect:/login/toLogin";
		}catch (IncorrectCredentialsException e) {
			//登录失败
			model.addFlashAttribute("msg","密码错误");
			return "redirect:/login/toLogin";
		}
	}
	
	//跳转到测试添加用户
	@RequestMapping("/add")
	public String toAdd()throws Exception{
		return "admin/UserAdd";
	}
	//跳转到测试修改用户
	@RequestMapping("/update")
	public String toUpdate()throws Exception{
		return "admin/UserUpdate";
	}
	
	// 跳转到未授权页面
	@RequestMapping("/to401")
	public String to401(Model model) throws Exception{
		return "admin/UserAdd";
	}
}
