package com.ContactApp.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ContactApp.Domain.Contact;

public class ContactRowMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact c = new Contact();
		c.setContactId(rs.getInt("contactId"));
		c.setUserId(rs.getInt("userId"));
		c.setContactName(rs.getString("contactName"));
		c.setContactEmail(rs.getString("contactEmail"));
		c.setContactPhone(rs.getString("contactPhone"));
		c.setContactAddress(rs.getString("contactAddress"));
		c.setContactRemark(rs.getString("contactRemark"));
		return c;
	}

}
