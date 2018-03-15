package com.cs445.lf2u.Customers;

import com.cs445.lf2u.IdGenreator.UniqueIdGenerator;

public class Customer {

	String cid;
	String name;
	String street;
	String zip;
	String phone;
	String email;
	
	public Customer() {
		this.cid = UniqueIdGenerator.getUniqueID();
	}
	
	
/*	public Customer(String cid, String name, String street, String zip, String phone, String email) {
		super();
		this.cid = cid;
		this.name = name;
		this.street = street;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}

	public Customer(String name, String street, String zip, String phone, String email) {
		super();
		
		this.name = name;
		this.street = street;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}
*/
	public String getCid() {
		return cid;
	}
	
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
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
