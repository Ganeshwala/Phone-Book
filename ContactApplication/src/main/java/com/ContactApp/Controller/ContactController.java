package com.ContactApp.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		Integer contactId = (Integer)session.getAttribute("userContactId");
		System.out.println("contactId"+contactId);
		Integer userId = (Integer) session.getAttribute("userId");
		if(contactId != null) {
			try {
				c.setUserId(userId);
				c.setContactId(contactId); // FK -> logged User Id
				cService.update(c);
				m.addAttribute("success", "Edit Successfully !!!!");
				return "ContactForm";
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				m.addAttribute("err", "Failed to Edit Contact");
				return "ContactForm";
			}
		}else {
			try {
				
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
	
	@RequestMapping(value="/user/contactList")
	public String contactList(HttpSession sess,Model m) {
		m.addAttribute("contactList",cService.findUserContact((Integer)sess.getAttribute("userId")));
		return "ContactList";
	}
	
	@RequestMapping(value="/user/delete")
	public String contactDelete(@RequestParam("contactId") Integer cid) {
		cService.delete(cid);
		return "redirect:/user/contactList?msg=del";
	}
	
	@RequestMapping(value="/user/edit")
	public String editUser(@RequestParam("contactId") Integer cid,HttpSession sess,Model m) {
		sess.setAttribute("userContactId", cid);
		Contact userContact = cService.findById(cid);
		m.addAttribute("contact", userContact);
		return "ContactForm";
	}
	
	@RequestMapping(value="/user/searchContact")
	public String searchContact(@RequestParam("search") String search,HttpSession session,Model m) {
		Integer userId = (Integer)session.getAttribute("userId");
		m.addAttribute("contactList",cService.findUserContact(userId, search));
		return "ContactList";
	}
}
