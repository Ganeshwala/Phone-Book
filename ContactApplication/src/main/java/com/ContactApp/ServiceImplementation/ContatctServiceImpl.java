package com.ContactApp.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ContactApp.DAO.ContactDAO;
import com.ContactApp.Domain.Contact;
import com.ContactApp.Service.ContactServices;
import com.ContactApp.Util.StringUtil;

@Service
public class ContatctServiceImpl implements ContactServices {

	@Autowired
	private ContactDAO contactService;
	
	@Autowired
	JdbcTemplate jService;
	
	@Override
	public void save(Contact con) {
		// TODO Auto-generated method stub
		contactService.save(con);
	}

	@Override
	public void update(Contact con) {
		// TODO Auto-generated method stub
		contactService.update(con);
	}

	@Override
	public void delete(Integer conId) {
		// TODO Auto-generated method stub
		contactService.delete(conId);
	}

	@Override
	public void delete(Integer[] conIds) {
		String ids = StringUtil.toCommaSeparatedString(conIds);
		String sql = "delete from contact where contactId in ('"+ids+"')";
		jService.update(sql);
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		
		return contactService.findByProperty("userId", userId); 
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		// TODO Auto-generated method stub
		return null;
	}

}
