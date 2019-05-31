package cn.appsys.controller.backend;

import cn.appsys.controller.developer.DevLoginController;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/dev")
public class UserLoginController {
	
	@Resource
	private DevUserService devUserService;
	private Logger logger = Logger.getLogger(DevLoginController.class);
	
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("LoginController welcome AppinfoSystem dev ");
		return "devlogin";
	}

	@RequestMapping(value="/dologin")
	public String dologin(@RequestParam String devCode, @RequestParam String password , HttpServletRequest request){
		DevUser user = null;
		user = devUserService.getLoginUser(devCode);
		if(user==null){
			request.setAttribute("error","用户名不存在");
		}else if(user.getDevPassword().equals(password)){
			request.setAttribute("error","密码错误");
		}else{
			request.getSession().setAttribute(Constants.DEV_USER_SESSION,user);
			return "redirect:/dev/flatform/main";
		}
		return "devlogin";
	}
}
