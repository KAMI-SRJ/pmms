package com.dugstudio.pmms.controller;

import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value="/login")
public class LoginController extends BaseController {

	@RequestMapping(value="/index")
	public String index(){
		System.out.println("index+");
		return "redirect:front/user/index.do";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(){
		ModelAndView mav=new ModelAndView();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sno=request.getParameter("sno");
		String password=request.getParameter("password");
		String rememberMe=request.getParameter("rememberMe");
		System.out.println(sno+password+rememberMe);
		if(StringUtils.isNotBlank(sno)&&StringUtils.isNotBlank(password)){
			String md5Pwd=MD5Util.generatePassword(password);
			System.out.println("md5:"+md5Pwd);
			try {
				UsernamePasswordToken token = new UsernamePasswordToken(sno, md5Pwd, rememberMe);
				Subject subject = SecurityUtils.getSubject();
						subject.login(token);
						mav.setViewName("/front/index1");

			} catch (LockedAccountException lae) {
			    System.out.println("账号已被禁用");
				mav.addObject("login_msg", "账号已被禁用");
				mav.setViewName("redirect:/front/user/index.do");
			} catch (AuthenticationException ae) {
				System.out.println("账号或密码错误");
				mav.addObject("login_msg", "账号或密码错误");
				mav.setViewName("redirect:/front/user/index.do");
			} catch (Exception e) {
				System.out.println("登录异常"+e.getMessage());
				mav.addObject("login_msg", "登录异常");
				mav.setViewName("redirect:/front/user/index.do");
			}
		}else{
			mav.setViewName("redirect:/front/user/index.do");
		}
		return mav;
	}
	@RequestMapping("/logout")
	public ModelAndView logout(){
		ModelAndView mav=new ModelAndView();
		Subject sub=SecurityUtils.getSubject();
		if(sub!=null){
		sub.logout();
		mav.setViewName("redirect:/front/user/index.do");
		}
		return mav;
	}
}
