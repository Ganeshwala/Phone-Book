package com.ContactApp.Service;

import java.util.List;

import com.ContactApp.Domain.User;
import com.ContactApp.Exception.UserBlockException;

public interface UserServices {

	public static final Integer login_Status_Active = 1;
	public static final Integer login_Status_Block = 2;

	public static final Integer role_Admin = 1;
	public static final Integer role_User = 2;

	public void Register(User user);

	/*
	 * The method handle login operation(authentication) using given credentials, it
	 * return User object when success and null on failed.
	 */
	public User login(String loginName, String password) throws UserBlockException;

	public List<User> getUserList();

	/*
	 * this method change the user login status. loginStatus is block->2 and active
	 * ->1
	 * 
	 */
	public void changeLoginStatus(Integer userId, Integer loginStatus);
}
