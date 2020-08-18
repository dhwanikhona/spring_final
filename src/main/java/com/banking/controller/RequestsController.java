package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.Requests;
import com.banking.servcie.RequestsService;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RequestsController {
	
	@Autowired
	private RequestsService requestsService;

	@PostMapping("/request")
	public ResponseEntity <String> createRequests(@RequestParam("requestType")String requestType, @RequestParam("requestDescription")String requestDiscription, @RequestParam("username")String username) {
		
		requestsService.createRequests(requestType, requestDiscription, username);
		
		 return new ResponseEntity<>("done", HttpStatus.OK);
		
	}
	

}
