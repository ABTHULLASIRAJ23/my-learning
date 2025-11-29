package org.entity;

public class POJO_login {
	private String Role;
	private String email;
	private String password;
	
	public String getRole() {
		return Role;
	}
	
	public void setRole(String role) {
		Role = role;
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
	public POJO_login(String role,String email,String password) {
		this.Role =role;
		this.email=email;
		this.password=password;
	}
}

 