package com.ContactApp.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ContactApp.Domain.Contact;

@Repository
public interface ContactDAO {

	public void save(Contact contact);

	public void update(Contact contact);

	public void delete(Contact contact);

	public void delete(Integer contactId);

	public Contact findById(Integer contactId);

	public List<Contact> findAll();

	public List<Contact> findByProperty(String propertyName, Object propValue);
}
