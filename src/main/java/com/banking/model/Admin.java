package com.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Admin {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int adminId;
		private String username;
		private String password;
		
		public Admin() {
			// TODO Auto-generated constructor stub
		}
		
		
		public int getAdminId() {
			return adminId;
		}


		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}


		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		

}
