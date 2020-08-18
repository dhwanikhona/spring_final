package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.exception.BusinessException;
import com.banking.model.User;
import com.banking.servcie.RegisterService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController{
	
	@Autowired
	private RegisterService service;
	
	private MultiValueMap<String, String> map;
	@PostMapping("/registration")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<>(service.createUser(user), HttpStatus.OK);
	}

//	@PutMapping("/user")
//	public ResponseEntity <User>updateUser(@RequestParam("username"),@RequestParam("emailId") String emailId,@RequestParam("mobileNumber") {
//		
////		return service.updateUser(user);
//		
//		 return new ResponseEntity<>(service.updateUser(user), HttpStatus.OK);
//		
//		
//	}
//	
	
	@GetMapping("/userdetails")
	public ResponseEntity<User> getUserByUsername(@RequestParam("username") String username){
		return new ResponseEntity<>(service.findByUsername(username), HttpStatus.OK);
	}
			

//	@Override
//	public void disableUser(int uId) {
//		// TODO Auto-generated method stub
//		
//	}

	
	
}
