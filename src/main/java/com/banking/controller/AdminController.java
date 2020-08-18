package com.banking.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.Requests;
import com.banking.model.User;
import com.banking.servcie.RegisterService;
import com.banking.servcie.RequestsService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	@Autowired
	private RegisterService service;
	
	@Autowired
	private RequestsService requestsService;
	
	
	@GetMapping("/admin/getallusers")
	public ResponseEntity <List<User>> getAllUsers() {
		
//		return service.getAllUsers();
		
		 return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
	}

	@PutMapping("/admin/enable/{username}")
	public ResponseEntity <String> enableUser(@PathVariable String username) {
		
		service.enableUser(username);
		 return new ResponseEntity<>("done", HttpStatus.OK);
		
				
	}
	
	@PutMapping("/admin/disable/{username}")
	public ResponseEntity <String> diableUser(@PathVariable String username) {
		
		service.disableUser(username);
		 return new ResponseEntity<>("done", HttpStatus.OK);
				
	}
	
	@DeleteMapping("/admin/delete/{uId}")
	public ResponseEntity <String> deleteUserById(@PathVariable("uId")int uId) {

		service.deleteUserById(uId);
		
		 return new ResponseEntity<>("done", HttpStatus.OK);
	}
	
	@PutMapping("/admin/request/{requestId}")
	public ResponseEntity <String> acceptRequests(@PathVariable("requestId") int requestId) {
		System.out.println("/n/n/n/n/n/n/n/n");
		System.out.println("inside accept request");
		
		System.out.println(requestId);
		
		//int reqId = Integer.parseInt(requestId);
		
		
		requestsService.acceptRequests(requestId);
		
		 return new ResponseEntity<>("done", HttpStatus.OK);
	}

	@GetMapping("/admin/requests")
	public ResponseEntity <List<Requests>> findAllRequests() {
		System.out.println("Inside find requests");
		List<Requests> requests= requestsService.findAllRequests();
		
		return new ResponseEntity<> ( requests, HttpStatus.OK);
	}

	@DeleteMapping("/admin/delete/request/{requestId}")
	public ResponseEntity <String> deleteRequests(@PathVariable int requestId) {
		
		System.out.println("in delete requests");
		
		requestsService.deleteRequests(requestId);
		 return new ResponseEntity<>("done", HttpStatus.OK);
	}

}
