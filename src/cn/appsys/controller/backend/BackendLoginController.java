package cn.appsys.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backend.BackendService;

@Controller
@RequestMapping("/manager")
public class BackendLoginController {
		
	//ע��BackendService����
	@Resource
	private BackendService backendService;
	
	//��ת����̨��¼ҳ��
	@RequestMapping("/login")
	public String login(){
		 return "backendlogin";
	}
	
	@RequestMapping("/dologin")
	public String dologin(@RequestParam("userCode")String userCode,
			@RequestParam("userPassword")String userPassword,
			HttpSession session,HttpServletRequest request){
		//����ҵ��㷽������ȡ����̨�û�����
		BackendUser user=backendService.login(userCode);
		//�����ж�
		if(user.getUserPassword().equals(userPassword)){
			session.setAttribute("userSession", user);
			return "/backend/main";
		}else {
			request.setAttribute("errot", "�û������������");
			return "backendlogin";
		}
	}
}
