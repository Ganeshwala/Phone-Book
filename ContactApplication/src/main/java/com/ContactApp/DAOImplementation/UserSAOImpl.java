package com.ContactApp.DAOImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ContactApp.DAO.UserDAO;
import com.ContactApp.Domain.User;
import com.ContactApp.RowMapper.UserRowMapper;

@Repository
public class UserSAOImpl implements UserDAO {

	@Autowired
	JdbcTemplate jTemp;
	
	@Override
	public void save(User user) {
		String sql ="insert into user(userName,userPhone,userEmail,userAddress,loginName,password,role,loginStatus) values(:userName, :userPhone, :userEmail, :userAddress, :loginName, :password, :role,:loginStatus)";
		Map m = new HashMap();
		m.put("userName", user.getUserName());
		m.put("userPhone", user.getUserPhone());
		m.put("userEmail", user.getUserEmail());
		m.put("userAddress", user.getUserAddress());
		m.put("loginName", user.getLoginName());
		m.put("password", user.getPassword());
		m.put("role", user.getRole());
		m.put("loginStatus", user.getLoginStatus());
		SqlParameterSource ps = new MapSqlParameterSource(m);
		jTemp.update(sql, ps);
		System.out.println("User Inserted sucessfully!!!!!");
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql = "update user set userName =:name ,userPhone=:phone,userEmail=:email,userAddress=:address,role=:role,loginStatus=:loginStatus where userId=:id";
		Map m = new HashMap();
		m.put("name",user.getUserName());
		m.put("phone",user.getUserPhone());
		m.put("email",user.getUserEmail());
		m.put("affress",user.getUserAddress());
		m.put("role",user.getRole());
		m.put("loginStatus",user.getLoginStatus());
		m.put("id", user.getUserId());
		jTemp.update(sql,m);
		System.out.println("Update Records");
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		this.delete(user.getUserId());
	}

	@Override
	public void delete(Integer userId) {
		String sql = "delete from user where userId=?";
		jTemp.update(sql,userId);
		System.out.println("user deleted successfully");
		
	}

	@Override
	public User findById(Integer userId) {
		String sql= "select userName,userPhone,userEmail,userAddress,loginName,role,loginStatus from user where userId=?";
		User userResult = jTemp.queryForObject(sql, new UserRowMapper(),userId);
		return userResult;
	}

	@Override
	public List<User> findAll() {
		String sql = "select userName,userPhone,userEmail,userAddress,loginName,role,loginStatus from user";
		List<User> userList = jTemp.query(sql, new UserRowMapper());
		return userList;
	}

	@Override
	public List<User> findByProperty(String propertyName, Object propValue) {
		String sql= "select userName,userPhone,userEmail,userAddress,loginName,role,loginStatus from user where "+propertyName+"=?";
		List<User> userRecord = jTemp.query(sql, new UserRowMapper(),propValue);
		return userRecord;
	}

}
