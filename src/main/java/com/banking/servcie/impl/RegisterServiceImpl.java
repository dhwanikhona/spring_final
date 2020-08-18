package com.banking.servcie.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.UserDAO;
import com.banking.exception.BusinessException;
import com.banking.model.SavingsAccount;
import com.banking.model.User;
import com.banking.servcie.RegisterService;
import com.banking.servcie.SavingsAccountService;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private UserDAO dao;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	@Override
	public User createUser(User user) {
		user.setEnable(true);
		user.setRole("user");
		user.setSavingsAccount(savingsAccountService.createSavingsAccount());
		return dao.save(user);
		
	}

	@Override
	public User updateUser(User user) {
		return dao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.findAll();
	}

	@Override
	public void enableUser(String username) {
		
		
		
		User enable = dao.findByUsername(username);
		enable.setEnable(true);
//		enable.setDisable(false);
		dao.save(enable);
	}

	@Override
	public void disableUser(String username) {
		User disable = dao.findByUsername(username);
//		disable.setDisable(true);
		disable.setEnable(false);
		
		dao.save(disable);
		
	}

	@Override
	public void deleteUserById(int uId) {
		dao.deleteById(uId);
	
	}
	
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}
	
	@Override
	public User findBySavingsAccount(SavingsAccount savingsAccount) {
		
		return dao.findBySavingsAccount(savingsAccount);
	}
		
	
	}	
	



