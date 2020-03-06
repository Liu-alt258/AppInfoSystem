package cn.appsys.controller.dev;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.dev.DevService;

@Controller
@RequestMapping("/dev")
public class DevController {

	@Resource
	private DevService devService;
	
	@RequestMapping("/login")
	public String login(){
		return "devlogin";
	}
	
	@RequestMapping("/dologin")
	public String dologin(@RequestParam("devCode")String devCode,
			@RequestParam("devPassword")String devPassword,
			HttpSession session,HttpServletRequest request){
		DevUser user=devService.login(devCode);
		if(user.getDevPassword().equals(devPassword)){
			session.setAttribute("devUserSession", user);
			return "/developer/main";
		}else{
			request.setAttribute("error", "用户名或密码错误！");
			return "devlogin";
		}
		
	}
	
	
	
	
	
}
