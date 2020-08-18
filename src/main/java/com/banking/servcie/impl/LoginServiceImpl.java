package com.banking.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.AdminDAO;
import com.banking.dao.UserDAO;
import com.banking.model.Admin;
import com.banking.model.Login;
import com.banking.model.User;
import com.banking.servcie.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private AdminDAO adminDao;

	@Autowired
	private UserDAO dao;
	
	@Override
	public User login(Login login) throws Exception {
		User user=null;
		Admin admin = null;
		
		try {
			
			
			if(login.getUsername().equals("admin1")) {
				
				admin=adminDao.findByUsername(login.getUsername());
				if(!login.getPassword().equals(admin.getPassword())) {
					throw new Exception();
				}
				
				
			}else {
				
				user=dao.findByUsername(login.getUsername());
				
				if(!login.getPassword().equals(user.getPassword())) {
					throw new Exception();
				}else if((login.getPassword().equals(user.getPassword()) && user.isEnable()==false)){
					throw new Exception("User Disabled");
					
				}
				
			}
			
			
			
		} 
		catch (Exception e) {
			throw new Exception("Username or password is incorrect");
		}
		return user;
	}
}
