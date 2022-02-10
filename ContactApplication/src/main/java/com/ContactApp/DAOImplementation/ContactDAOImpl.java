package com.ContactApp.DAOImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ContactApp.DAO.ContactDAO;
import com.ContactApp.Domain.Contact;
import com.ContactApp.RowMapper.ContactRowMapper;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	JdbcTemplate jTemp;
	@Override
	public void save(Contact contact) {
	
		String sql = "insert into contact(userId,contactName,contactPhone,contactEmail, contactAddress,contactRemark) values(:userId,:contactName,:contactPhone,:contactEmail, :contactAddress,:contactRemark)";
		Map m = new HashMap();
		m.put("userId", contact.getUserId());
		m.put("contactName",contact.getContactName());
		m.put("contactPhone", contact.getContactPhone());
		m.put("contactEmail", contact.getContactEmail());
		m.put("contactAddress",contact.getContactAddress());
		m.put("contactRemrk",contact.getContactRemark());
		jTemp.update(sql,m);
		System.out.println("contact Added!!!!");

	}

	@Override
	public void update(Contact contact) {
		String sql = "update contatc set userId=:userId,contactName=:name,contactPhone=:phone,contactEmail=:email, contactAddress=:address, contactRemark=:remark where contactId=?";
		Map m = new HashMap();
		m.put("userId", contact.getUserId());
		m.put("name",contact.getContactName());
		m.put("phone", contact.getContactPhone());
		m.put("email", contact.getContactEmail());
		m.put("address",contact.getContactAddress());
		m.put("remrk",contact.getContactRemark());
		jTemp.update(sql,m,contact.getContactId());
	}

	@Override
	public void delete(Contact contact) {
		// TODO Auto-generated method stub
		this.delete(contact.getContactId());
	}

	@Override
	public void delete(Integer contactId) {
		String sql = "delete from contact where contactId=?";
		jTemp.update(sql,contactId);
	}

	@Override
	public Contact findById(Integer contactId) {
		String sql = "select contactId,userId,contactName,contactPhone,contactEmail, contactAddress,contactRemark from contact where contactId=?";
		Contact con = jTemp.queryForObject(sql, new ContactRowMapper(),contactId);
		return con;
	}

	@Override
	public List<Contact> findAll() {
		String sql = "select contactId,userId,contactName,contactPhone,contactEmail, contactAddress,contactRemark from contact";
		List<Contact> contactList = jTemp.query(sql,new ContactRowMapper());
		return contactList;
	}

	@Override
	public List<Contact> findByProperty(String propertyName, Object propValue) {
		String sql = "select contactId,userId,contactName,contactPhone,contactEmail, contactAddress,contactRemark from contact where"+propertyName+"=?";
		List<Contact> contactRecords = jTemp.query(sql,new ContactRowMapper(),propValue);
		return contactRecords;
	}

}
