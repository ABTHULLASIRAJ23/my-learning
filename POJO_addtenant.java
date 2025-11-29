package org.entity;

public class POJO_addtenant {
	private String name;
	private String email;
	private String password;
	private long phonum;
	private int flatnum;
	private double rent;
	
	public POJO_addtenant(String name,String email,String password,long phonum,int flatnum,double rent) {
		this.name= name;
		this.email= email;
		this.password =password;
		this.phonum=phonum;
		this.flatnum=flatnum;
		this.rent=rent;
		
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhonum() {
		return phonum;
	}

	public void setPhonum(long phonum) {
		this.phonum = phonum;
	}

	public int getFlatnum() {
		return flatnum;
	}

	public void setFlatnum(int flatnum) {
		this.flatnum = flatnum;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}
	
}