package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.Login;
import com.banking.model.User;
import com.banking.servcie.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	private LoginService service;
	
	private MultiValueMap<String, String> map;
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody Login login) {
		
		try {
			return new ResponseEntity<User>(service.login(login), HttpStatus.OK);

		} catch (Exception e) {
			map=new LinkedMultiValueMap<>();
			map.add("message", e.getMessage());			
			return new ResponseEntity<User>(null,map, HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
