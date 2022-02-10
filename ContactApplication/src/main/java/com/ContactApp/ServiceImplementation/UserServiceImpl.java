package com.ContactApp.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ContactApp.DAO.UserDAO;
import com.ContactApp.Domain.User;
import com.ContactApp.Service.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserDAO userService;
	
	@Override
	public void Register(User user) {
		// TODO Auto-generated method stub
		userService.save(user);
	}

	@Override
	public User login(String loginName, String password) {
		// TODO Auto-generated method stub
		return null;
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
