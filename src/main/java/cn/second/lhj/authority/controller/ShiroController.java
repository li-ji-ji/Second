package cn.second.lhj.authority.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.second.lhj.authority.mapper.MenuMapper;
import cn.second.lhj.authority.service.UserInfoService;

@Controller
public class ShiroController {
	private static final Logger logger = LoggerFactory.getLogger(ShiroController.class);
	
	@Autowired
	private MenuMapper menuMapper;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
		System.out.println("ShiroController.login()");
		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exception=" + exception);
		String msg = "";
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("UnknownAccountException -- > 账号不存在：");
				msg = "UnknownAccountException -- > 账号不存在：";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("IncorrectCredentialsException -- > 密码不正确：");
				msg = "IncorrectCredentialsException -- > 密码不正确：";
			} else if ("kaptchaValidateFailed".equals(exception)) {
				System.out.println("kaptchaValidateFailed -- > 验证码错误");
				msg = "kaptchaValidateFailed -- > 验证码错误";
			} else {
				msg = "else >> " + exception;
				System.out.println("else -- >" + exception);
			}
		}
		map.put("msg", msg);
		// 此方法不处理登录成功,由shiro进行处理
		return "login";
	}

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/index")
	public String index() {
		logger.info("index()");
		logger.info("menu1="+menuMapper.selectByPrimaryKey(1));
		return "index";
	}

	@RequestMapping("/403")
	public String unauthorizedRole() {
		System.out.println("------没有权限-------");
		return "403";
	}

	@RequestMapping("/add")
	public String add() {
		System.out.println("----- add()-------");
		return "userInfoAdd";
	}

	@RequestMapping("/del")
	public String del() {
		return "userInfoDel";
	}

	@RequestMapping("/second")
	public String second() {
		return "userInfo";
	}
}
