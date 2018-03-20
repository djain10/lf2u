package com.cs445.lf2u.Orders;

import java.util.List;

import com.cs445.lf2u.Util.UniqueIdGenerator;

public class Order {
	
	String oid;
	String order_date;
	String planned_delivery_date;
	String actual_planned_date;
	String status;
	OrderFarmInfo farm_info;
	List<OrderDetail> orderDetails;	
	String deliveryNote;
	double products_total; 
	double delivery_charge;
	double order_total;
	
	public Order(){
		this.oid = UniqueIdGenerator.getUniqueOID();
		this.order_date = UniqueIdGenerator.getTodayDate();
		this.planned_delivery_date = UniqueIdGenerator.getNextDayDate();
		this.actual_planned_date=null;
		this.status = "open";
	}
	
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getPlanned_delivery_date() {
		return planned_delivery_date;
	}
	public void setPlanned_delivery_date(String planned_delivery_date) {
		this.planned_delivery_date = planned_delivery_date;
	}
	public String getActual_planned_date() {
		return actual_planned_date;
	}
	public void setActual_planned_date(String actual_planned_date) {
		this.actual_planned_date = actual_planned_date;
	}
	
	public double getProducts_total() {
		return products_total;
	}

	public void setProducts_total(double products_total) {
		this.products_total = products_total;
	}
	
	public double getDelivery_charge() {
		return delivery_charge;
	}

	public void setDelivery_charge(double delivery_charge) {
		this.delivery_charge = delivery_charge;
	}

	public double getOrder_total() {
		return order_total;
	}
	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getDeliveryNote() {
		return deliveryNote;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderFarmInfo getFarm_info() {
		return farm_info;
	}

	public void setFarm_info(OrderFarmInfo farm_info) {
		this.farm_info = farm_info;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}
	
}
