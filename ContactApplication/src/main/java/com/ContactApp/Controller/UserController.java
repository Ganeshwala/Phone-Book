package com.ContactApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping(value= {"/","/Home"})
	public String login() {
		return "Home";
	}
}
