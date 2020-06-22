package com.wuzesheng.org.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wuzesheng.org.domain.User;
import com.wuzesheng.org.service.UserService;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月12日 下午5:18:51
 */
@Controller
public class LoginController {
	
	@Resource
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//GET请求
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	//POST请求
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(@RequestParam String UserName,
						@RequestParam String PassWord,
						HttpServletRequest request,
						Model model,
						HttpSession session) {

		System.out.println(UserName);
		System.out.println(PassWord);
		User user = userService.loginUser(UserName, PassWord);
		System.out.println(user);	
		if(user != null || user.getStatus() != "禁用" ){
			session.setAttribute("user", user);
			//管理员登录
			if("管理员".equals(user.getRole()))
				return "redirect:/view/index.html";
			//调度员登录
			else if("调度员".equals(user.getRole()))
				return "redirect:/view/diaodu/index.html";
			//驾驶员登录
			else
				return "redirect:/view/jiashi/index.html";			
		}else{
			model.addAttribute("error","账号、密码错误或已被禁用登录对象!");
			return "redirect:/view/login.jsp";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,
						HttpSession session){
		
		session.removeAttribute("user");
		request.setAttribute("mse", "退出成功！");
		return "redirect:/view/login.jsp";
	}
}
