package com.cs445.lf2u.Farmers;

import com.cs445.lf2u.IdGenreator.UniqueIdGenerator;

public class FarmProduct {
	
	String fspid;
	String name;
	String note;
	String start_date;
	String end_date;
	double price;
	String product_unit;
	String image;
		
	public FarmProduct() {
		this.fspid = UniqueIdGenerator.getUniqueFSPID();
	}
	public String getFspid() {
		return fspid;
	}
	public void setFspid(String fspid) {
		this.fspid = fspid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProduct_unit() {
		return product_unit;
	}
	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
