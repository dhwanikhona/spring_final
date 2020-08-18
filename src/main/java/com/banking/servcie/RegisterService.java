package com.banking.servcie;

import java.util.List;

import com.banking.exception.BusinessException;
import com.banking.model.SavingsAccount;
import com.banking.model.User;

public interface RegisterService {
	
	public User createUser(User user);
	public User updateUser(User user);
	public List<User> getAllUsers();
	public void enableUser(String username);
	public void disableUser(String username);
	public void deleteUserById(int uId);
	public User findByUsername(String username);
	public User findBySavingsAccount(SavingsAccount savingsAccount);


}
