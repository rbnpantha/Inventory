package models;

import service.UserService;

public class User implements RuleSet{
	private int id;
	private int roleId;
	private String username;
	private String password;
	private String name;
	private String email;
	private long phoneNumber;
	private String address;
	private long lastLogin;
	private int status;
	private String city;
	private String country;
	public int isAdmin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}



	@Override
	public void applyRules() throws RuleException {
		if((RuleSetFactory.isEmpty(name) || RuleSetFactory.isEmpty(username)|| RuleSetFactory.isEmpty(email)
				||RuleSetFactory.isEmpty(password) || RuleSetFactory.isEmpty(String.valueOf(phoneNumber)) || RuleSetFactory.isEmpty(address)
				|| RuleSetFactory.isEmpty(address) || RuleSetFactory.isEmpty(city) || RuleSetFactory.isEmpty(country))){
			System.out.print("here");
			throw new RuleException(" All fields must be nonempty");

		}

		if(!new UserService().isUniqueUsername(username)){
			throw new RuleException("The username already exists");
		}

		if(!RuleSetFactory.isValidEmail(email)){
			throw new RuleException("Email is not valid");
		}

		if(!RuleSetFactory.isValidPhoneNumber(String.valueOf(phoneNumber))){
			throw new RuleException("Phone number is not valid");

		}

		if(!new UserService().isUniqueEmail(email)){
			throw new RuleException("The email already exists");
		}



	}


}