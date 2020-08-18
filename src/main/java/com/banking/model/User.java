package com.banking.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
import com.banking.model.Requests;
import com.banking.model.SavingsAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class User{
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uId;
	
	private String firstName;
	private String lastName;
	private long mobileNumber;
	private String address;
	private String city;
	private String state;
	private String country;
	private String gender;
	private String role;
	
	@Column(name = "email", nullable = false, unique = true)
	private String emailId;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	private boolean enable=true;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "savings_account_id", referencedColumnName = "savingsAccountId")
	private SavingsAccount savingsAccount;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Requests> requestsList;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	

	

	public long getuId() {
		return uId;
	}






	public void setuId(long uId) {
		this.uId = uId;
	}






	public String getFirstName() {
		return firstName;
	}






	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}






	public String getLastName() {
		return lastName;
	}






	public void setLastName(String lastName) {
		this.lastName = lastName;
	}






	public long getMobileNumber() {
		return mobileNumber;
	}






	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}






	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
	}






	public String getCity() {
		return city;
	}






	public void setCity(String city) {
		this.city = city;
	}






	public String getState() {
		return state;
	}






	public void setState(String state) {
		this.state = state;
	}






	public String getCountry() {
		return country;
	}






	public void setCountry(String country) {
		this.country = country;
	}






	public String getGender() {
		return gender;
	}






	public void setGender(String gender) {
		this.gender = gender;
	}






	public String getRole() {
		return role;
	}






	public void setRole(String role) {
		this.role = role;
	}






	public String getEmailId() {
		return emailId;
	}






	public void setEmailId(String emailId) {
		this.emailId = emailId;
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






	public boolean isEnable() {
		return enable;
	}






	public void setEnable(boolean enable) {
		this.enable = enable;
	}






	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}






	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}






	public List<Requests> getRequestsList() {
		return requestsList;
	}






	public void setRequestsList(List<Requests> requestsList) {
		this.requestsList = requestsList;
	}






	@Override
	public String toString() {
		return "User [uId=" + uId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", gender=" + gender + ", role=" + role + ", emailId=" + emailId + ", username=" + username
				+ ", password=" + password + ", enable=" + enable + ", savingsAccount=" + savingsAccount
				+ ", requestsList=" + requestsList + "]";
	}






	public User(String firstName, String lastName, long mobileNumber, String address, String city,
			String state, String country, String gender, String role, String emailId, String username, String password,
			boolean enable, SavingsAccount savingsAccount, List<Requests> requestsList) {
		super();
	//	this.uId = uId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.gender = gender;
		this.role = role;
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.savingsAccount = savingsAccount;
		this.requestsList = requestsList;
	}
	
	
	
	public User(String firstName, String lastName,String username, String password) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		
	}










	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return enable;
//	}


		


		

}
