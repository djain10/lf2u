package com.cs445.lf2u.Customers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cs445.lf2u.Farmers.DeliveryCharge;
import com.cs445.lf2u.Farmers.FarmProduct;
import com.cs445.lf2u.Farmers.Farmer;
import com.cs445.lf2u.Farmers.FarmerService;
import com.cs445.lf2u.Farmers.Fid;
import com.cs445.lf2u.Orders.CustomerOrderList;
import com.cs445.lf2u.Orders.InputStreamOrder;
import com.cs445.lf2u.Orders.InputStreamOrderDetail;
import com.cs445.lf2u.Orders.Oid;
import com.cs445.lf2u.Orders.Order;
import com.cs445.lf2u.Orders.OrderDetail;
import com.cs445.lf2u.Orders.OrderFarmInfo;
import com.cs445.lf2u.Orders.OutputOrderStream;

@Service
public class CustomerService {

	private List<Customer> customers = new ArrayList<>(Arrays.asList());
	private static List<Order> orderList = new ArrayList<>();
	public static List<OrderDetail> orderDetailList= new ArrayList<>();
	public static List<CustomerOrderList> customerOrderList = new ArrayList<>();
	Customer c;

	public Cid createCustomer(Customer customer) {
		customers.add(customer);
		Cid cid =  new Cid();
		cid.setCid(customer.getCid());
		return cid;

	}

	public Customer getCustomerDetails(String cid) {		
		return customers.stream().filter(t->t.getCid().equals(cid)).findFirst().get();
	}

	public void updateCustomer(String cid,Customer customer) {
		try {
			for(int i=0;i<customers.size();i++) {
				c = customers.get(i);
				if(c.getCid().equals(cid)) {
					customer.setCid(cid);
					customers.set(i, customer);
					return;
				}
			}

		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Oid createOrder(String cid, InputStreamOrder inputStream) {

		for(int i=0;i<customers.size();i++) {
			Customer customer = customers.get(i);			
			if(customer.getCid().equals(cid)) {
				Order order = new Order();
				OrderFarmInfo order_farm_info = new OrderFarmInfo();
				for(int j=0;i<FarmerService.farmers.size();i++) {
					Farmer farmer = FarmerService.farmers.get(j);
					if(farmer.getFid().equals(inputStream.getFid())){
						Fid fid = new Fid();
						fid.setFid(inputStream.getFid());
						order_farm_info.setFid(fid);
						order_farm_info.setFaminfo(farmer.getFarm_info());
					}
				}
				//farm Info addded in order
				order.setFarm_info(order_farm_info);
				
				OrderDetail orderDetail = new OrderDetail();
				InputStreamOrder iso = new InputStreamOrder();
				for(int k=0;k<inputStream.getOrder_detail().size();k++) {
					InputStreamOrderDetail isod = inputStream.getOrder_detail().get(k);
					for(int l= 0; l<FarmerService.farmProd.size();l++) {
					FarmProduct farmProduct = FarmerService.farmProd.get(l);
					if(farmProduct.getFspid().equals(iso.getFid())) {
						orderDetail.setFspid(isod.getFspid());
						StringBuilder amount = new StringBuilder();
						amount.append(isod.getAmount()).append(" ").append(farmProduct.getProduct_unit());
						orderDetail.setAmount(amount.toString());
						orderDetail.setName(farmProduct.getName());
						StringBuilder price = new StringBuilder();
						price.append(farmProduct.getPrice()).append(" per ").append(farmProduct.getProduct_unit());						
						orderDetail.setPrice(price.toString());
						orderDetail.setLine_item_total(farmProduct.getPrice()*isod.getAmount());
						orderDetailList.add(orderDetail);						
						}
					}
				}
				//order details added in order.
				order.setOrderDetails(orderDetailList);
				
				order.setDeliveryNote(iso.getDelivery_note());
				double total =0;
				for(int m=0; m<order.getOrderDetails().size();m++) {
					 
					total += orderDetail.getLine_item_total();					
				}
				order.setProducts_total(total);
				for(int n=0;n<FarmerService.deliveryCharge.size();n++) {
				DeliveryCharge delivery_charge = FarmerService.deliveryCharge.get(n);
				if(delivery_charge.getFid().equals(order.getFarm_info().getFid())) {
					order.setDelivery_charge(delivery_charge);
				}				
				}
				order.setOrder_total(order.getProducts_total() + order.getDelivery_charge().getDeliveryCharge());
				
				orderList.add(order);
				CustomerOrderList col = new CustomerOrderList();
				col.setCid(cid);
				col.setOrder(order);
				
				Oid oid = new Oid();
				oid.setOid(order.getOid());
				return oid;
			}
		}

		return null;
	}

	public OutputOrderStream getOrderById(String cid, String oid) {
		for(int i=0;i<customers.size();i++) {
			Customer customer = customers.get(i);			
			if(customer.getCid().equals(cid)) {
				OutputOrderStream oos = new OutputOrderStream();
				for(int i=0;)
				Order order = orderList.get(i)
			}
		}
		return null;
	}


}
