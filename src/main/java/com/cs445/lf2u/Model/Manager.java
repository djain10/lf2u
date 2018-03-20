package com.cs445.lf2u.Model;

public class Manager {
	
	String mid;
	String name;
	String created_by;
	String created_date;
	String phone;
	String email;
	
	public Manager() {
		
	}
	
	public Manager(String mid, String name, String created_by, String created_date, String phone, String email) {
		super();
		this.mid = mid;
		this.name = name;
		this.created_by = created_by;
		this.created_date = created_date;
		this.phone = phone;
		this.email = email;
	}
	
	
	public String getMid() {
		return mid;
	}
	
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCreated_by() {
		return created_by;
	}
	
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
	public String getCreated_date() {
		return created_date;
	}
	
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
		
}
