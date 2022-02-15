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
	
		String sql = "insert into contact(userId,contactName,contactPhone,contactEmail, contactAddress,contactRemark) values('"+contact.getUserId()+"','"+contact.getContactName()+"','"+contact.getContactPhone()+"','"+contact.getContactEmail()+"', '"+contact.getContactAddress()+"','"+contact.getContactRemark()+"')";
		jTemp.update(sql);
		System.out.println("contact Added!!!!");
	}

	@Override
	public void update(Contact contact) {
		String sql = "update contact set userId='"+contact.getUserId()+"',contactName='"+contact.getContactName()+"',contactPhone='"+contact.getContactPhone()+"',contactEmail='"+contact.getContactEmail()+"', contactAddress='"+contact.getContactAddress()+"', contactRemark='"+contact.getContactRemark()+"' where contactId='"+contact.getContactId()+"'";
		jTemp.update(sql);
	}

	@Override
	public void delete(Contact contact) {
		// TODO Auto-generated method stub
		this.delete(contact.getContactId());
	}

	@Override
	public void delete(Integer contactId) {
		String sql = "delete from contact where contactId='"+contactId+"'";
		jTemp.update(sql);
	}

	@Override
	public Contact findById(Integer contactId) {
		String sql = "select contactId,userId,contactName,contactPhone,contactEmail, contactAddress,contactRemark from contact where contactId='"+contactId+"'";
		Contact con = jTemp.queryForObject(sql, new ContactRowMapper());
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
		String sql = "select contactId,userId,contactName,contactPhone,contactEmail, contactAddress,contactRemark from contact where "+propertyName+"='"+propValue+"'";
		List<Contact> contactRecords = jTemp.query(sql,new ContactRowMapper());
		return contactRecords;
	}

}
