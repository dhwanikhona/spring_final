package com.banking.servcie;

import com.banking.model.Login;
import com.banking.model.User;

public interface LoginService {
	
	public User login(Login login) throws Exception;

}
