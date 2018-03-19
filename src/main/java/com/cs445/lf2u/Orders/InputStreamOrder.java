package com.cs445.lf2u.Orders;

import java.util.List;

public class InputStreamOrder {

	String fid;
	List<InputStreamOrderDetail> order_detail;
	String delivery_note;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public List<InputStreamOrderDetail> getOrder_detail() {
		return order_detail;
	}
	public void setOrder_detail(List<InputStreamOrderDetail> order_detail) {
		this.order_detail = order_detail;
	}
	public String getDelivery_note() {
		return delivery_note;
	}
	public void setDelivery_note(String delivery_note) {
		this.delivery_note = delivery_note;
	}
	
}
