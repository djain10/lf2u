package com.cs445.lf2u.Orders;

import java.util.List;

public class CustomerOrderList {
	String cid;
	List<Order> order;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
}
