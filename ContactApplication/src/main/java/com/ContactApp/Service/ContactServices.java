package com.ContactApp.Service;

import java.util.List;

import com.ContactApp.Domain.Contact;

public interface ContactServices {

	public void save(Contact con);
	public void update(Contact con);
	public void delete(Integer conId);
	public void delete(Integer[] conIds);
	public Contact findById(Integer cid);
	public List<Contact> findUserContact(Integer userId);
	public List<Contact> findUserContact(Integer userId,String txt);
}
