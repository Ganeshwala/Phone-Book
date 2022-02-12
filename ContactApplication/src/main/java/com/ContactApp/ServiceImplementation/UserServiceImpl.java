package com.ContactApp.ServiceImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ContactApp.DAO.UserDAO;
import com.ContactApp.Domain.User;
import com.ContactApp.Exception.UserBlockException;
import com.ContactApp.RowMapper.UserRowMapper;
import com.ContactApp.Service.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserDAO userService;
	
	@Autowired
	JdbcTemplate jUserService;
	
	@Override
	public void Register(User user) {
		// TODO Auto-generated method stub
		userService.save(user);
	}

	@Override
	public User login(String loginName, String password) throws UserBlockException {
		System.out.println("loginName=====>"+loginName+"password<======"+password);
		String sql ="select userId,userName,userPhone,userAddress,userEmail,role,loginStatus,loginName from user  where loginName='"+loginName+"' and password='"+password+"'";
		/*Map m = new HashMap();
		m.put("ln",loginName);
		m.put("pw",password);*/
		try {
			User userResult = jUserService.queryForObject(sql, new UserRowMapper());
			if(userResult.getLoginStatus().equals(UserServices.login_Status_Block)) {
				throw new UserBlockException("Your Account has been blocked !!!");
			}else {
				return userResult;
			}
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub

	}

}
