package com.bit2015.mysite.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.mysite.service.UserService;
import com.bit2015.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform() {

		return "user/joinform";

	}

	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		userService.join(userVo);
		
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinsuccess(@ModelAttribute UserVo userVo) {
		
		return "user/joinsuccess";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, @ModelAttribute UserVo userVo) {
		UserVo vo = userService.login(userVo);
		if (vo == null){
			return "redirect:/user/loginform";
		}
		session.setAttribute("authUser", vo);
		
		return "redirect:/";
	}
	
	@RequestMapping("/loginform")
	public String loginform() {
		
		return "user/loginform";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping("/update")
	public String update(HttpSession session, @ModelAttribute UserVo userVo){
		System.out.println(userVo);
		userService.update(userVo);
		session.setAttribute("authUser", userVo);
		return "redirect:/";
	}
	@RequestMapping("/updateform")
	public String updateform(HttpSession session){
		
		return "user/updateform";
	}
	@RequestMapping("/checkemail")
	@ResponseBody
	public Map<String, Object> checkemail(String email){
		
		UserVo userVo = userService.getUser(email);
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(userVo==null){
			map.put("result", "not exist");
			
		}else{
			map.put("result", "exist");
		}
		return map;
	}
	

}
