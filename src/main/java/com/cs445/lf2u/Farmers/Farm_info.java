package com.cs445.lf2u.Farmers;

public class Farm_info {
	
	String name;
	String address;
	String phone;
	String web;
	
	public Farm_info() {
		
	}
	
	public Farm_info(String name, String address, String phone, String web) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.web = web;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
	

}
