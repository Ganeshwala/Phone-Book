package com.ContactApp.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ContactApp.Domain.Contact;
import com.ContactApp.Service.ContactServices;

@Controller
public class ContactController {

	@Autowired
	ContactServices cService;
	
	@RequestMapping(value="/user/contactForm")
	public String contactForm(Model m) {
		m.addAttribute("contact", new Contact());
		return "ContactForm";
	}
	
	@RequestMapping(value="/saveContact")
	public String saveContact(@ModelAttribute("contact")Contact c,HttpSession session,Model m) {
		try {
			Integer userId = (Integer) session.getAttribute("userId");
			c.setUserId(userId); // FK -> logged User Id
			cService.save(c);
			m.addAttribute("success", "Save Successfully !!!!");
			return "ContactForm";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			m.addAttribute("err", "Failed to Save Contact");
			return "ContactForm";
		}
	}
}
