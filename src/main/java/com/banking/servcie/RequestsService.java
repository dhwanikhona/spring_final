package com.banking.servcie;

import java.util.List;

import com.banking.model.Requests;

public interface RequestsService {
	
	public void createRequests(String requestType,String requestDiscription, String username);
	public void acceptRequests(int requestId);
	public List<Requests> findAllRequests();
	public void deleteRequests(int requestId);


}
