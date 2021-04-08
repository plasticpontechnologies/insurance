package com.insurance.in.Insurance.model;

public class User {

	private String user_name;
	
	private String phone_number;
	
	private String email;
	
	private String password;
	
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return user_name;
	}

	public void setName(String name) {
		this.user_name = name;
		
	}

	public String getPhone() {
		return phone_number;
	}

	public void setPhone(String phone) {
		this.phone_number = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", phone_number=" + phone_number + ", email=" + email + ", password="
				+ password + ", enabled=" + enabled + "]";
	}
		
	
}
