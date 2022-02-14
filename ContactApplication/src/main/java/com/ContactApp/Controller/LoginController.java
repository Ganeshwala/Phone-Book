package com.ContactApp.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ContactApp.Command.LoginCommand;
import com.ContactApp.Domain.User;
import com.ContactApp.Exception.UserBlockException;
import com.ContactApp.Service.UserServices;

@Controller
public class LoginController {

	@Autowired
	private UserServices uService; 
	
	
	@RequestMapping(value= {"/","/Home"})
	public String login(Model m) {
		m.addAttribute("command",new LoginCommand());
		return "Home";
	}
	
	@RequestMapping(value= {"/login"},method=RequestMethod.POST)
	public String loginHandler(@ModelAttribute("command")LoginCommand cmd,Model m,HttpSession userSession) {
		try {
			User loginUser = uService.login(cmd.getLoginName(), cmd.getPassword());
			if(loginUser == null) {
				m.addAttribute("err","Login Failed! Enter Valid UserName & Password");
				return "Home";
			}
			else {
				if(loginUser.getRole().equals(UserServices.role_Admin)) {
					addUserInSession(loginUser,userSession);
					return "redirect:admin/dashbord";
				}else if(loginUser.getRole().equals(UserServices.role_User)) {
					addUserInSession(loginUser,userSession);
					return "redirect:user/dashbord";
				}else {
					m.addAttribute("err","Invalid User");
					return "Home";
				}
			}
		} catch (UserBlockException e) {
			// TODO Auto-generated catch block
			m.addAttribute("err",e.getMessage());
			return "Home";
		}
	}
	
	@RequestMapping(value= {"/user/dashbord"})
	public String userLogin() {
		return "UserDashbord";
	}
	
	@RequestMapping(value= {"/admin/dashbord"})
	public String adminLogin() {
		return "AdminDashbord";
	}
	
	@RequestMapping(value="/userRegister")
	public String userRegistration(Model m) {
		m.addAttribute("register", new User());
		return "Registration";
	}
	
	@RequestMapping(value="/register")
	public String registerNewUser(@ModelAttribute("register") User user,Model m) {
		try {
			user.setRole(uService.role_User);
			user.setLoginStatus(uService.login_Status_Active);
			uService.Register(user);
			return "redirect:Home";
		} catch (DuplicateKeyException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			m.addAttribute("err", "Username is already register !!! please try with other user name");
			return "Registration";
		}
		
	}
	
	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("userRole", u.getRole());
	}
}
