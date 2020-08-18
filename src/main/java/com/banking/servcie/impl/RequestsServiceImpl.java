package com.banking.servcie.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.dao.RequestsDAO;
import com.banking.model.Requests;
import com.banking.model.User;
import com.banking.servcie.RegisterService;
import com.banking.servcie.RequestsService;
import java.util.Optional;

@Service
public class RequestsServiceImpl implements RequestsService {
	
	@Autowired
	private RequestsDAO requestDao;
	
	@Autowired
	private RegisterService registerService;
	
	@Override
	public void createRequests(String requestType,String requestDiscription, String username) {
		Date date = new Date();
		Requests request = new Requests();
		request.setDate(date);
		request.setRequestType(requestType);
		request.setRequestDiscription(requestDiscription);
		request.setAccept(false);
		User user = registerService.findByUsername(username);
		request.setUsername(username);
		request.setUser(user);
		
		requestDao.save(request);
		
	}

	@Override
	public void acceptRequests(int requestId) {
		
		Requests request = requestDao.findById(requestId).get();
		request.setAccept(true);
		requestDao.save(request);
	}

	@Override
	public List<Requests> findAllRequests() {
		
		return requestDao.findAll();
	}

	@Override
	public void deleteRequests(int requestId) {
		
		requestDao.deleteById(requestId);
		
	}


}
