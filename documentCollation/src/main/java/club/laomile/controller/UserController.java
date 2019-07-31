package club.laomile.controller;

import club.laomile.bean.UserBean;
import club.laomile.service.UserInsertService;
import club.laomile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService us;

	@Autowired
	UserInsertService uis;

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
		public ModelAndView login(HttpSession session, HttpServletRequest request, Model model,
								  @RequestParam("user_name") String user_name,
								  @RequestParam("user_password") String user_password){
			UserBean ub = new UserBean(user_name,user_password);
			ModelAndView modelandview = new ModelAndView();
			try {
				UserBean userBean = us.findUser(ub);
				session.setAttribute("user",userBean);
				modelandview.setViewName("fileUpload");
			}catch (Exception e){
				modelandview.addObject("message", "密码或用户名错误");
				modelandview.setViewName("login");
			}finally {
				return modelandview;
			}
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public ModelAndView register(HttpSession session,Model modle,
								 @RequestParam("user_name") String user_name,
								 @RequestParam("user_password") String user_password,
								 @RequestParam("user_password_double") String user_password_double){
		UserBean ub = new UserBean(user_name,user_password);
		ModelAndView mav = new ModelAndView();
		String message = uis.userinsert(ub,user_password_double);
		if(message != null){
			if(message.equals("注册成功，请登录")){
				mav.addObject("message",message);
				mav.setViewName("login");
			}else{
				mav.addObject("message",message);
				mav.setViewName("register");
			}
		}
		return mav;
	}
}
