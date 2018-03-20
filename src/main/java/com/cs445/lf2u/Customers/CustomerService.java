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
	public static List<OutputOrderStream> outputOrderStreamList= new ArrayList<>();

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
						for(int n =0;n<FarmerService.deliveryCharge.size();n++) {
							DeliveryCharge delivery_charge = FarmerService.deliveryCharge.get(i);
							String farmerId = inputStream.getFid();
							if(delivery_charge.getFid().equals(farmerId)) {
								order.setDelivery_charge(delivery_charge.getDeliveryCharge());
							}
						}
					}
					//farm Info addded in order
					order.setFarm_info(order_farm_info);

					double total =0;			
					for(int k=0;k<inputStream.getOrder_detail().size();k++) {
						InputStreamOrderDetail isod = inputStream.getOrder_detail().get(k);
						for(int l= 0; l<FarmerService.farmProd.size();l++) {
							FarmProduct farmProduct = FarmerService.farmProd.get(l);
							if(farmProduct.getFspid().equals(isod.getFspid())) {
								OrderDetail orderDetail = new OrderDetail();
								orderDetail.setFspid(isod.getFspid());
								StringBuilder amount = new StringBuilder();
								amount.append(isod.getAmount()).append(" ").append(farmProduct.getProduct_unit());
								orderDetail.setAmount(amount.toString());
								orderDetail.setName(farmProduct.getName());
								StringBuilder price = new StringBuilder();
								price.append(farmProduct.getPrice()).append(" per ").append(farmProduct.getProduct_unit());						
								orderDetail.setPrice(price.toString());
								orderDetail.setLine_item_total(farmProduct.getPrice()*isod.getAmount());
								total += orderDetail.getLine_item_total();
								orderDetailList.add(orderDetail);
								//break;
							}

						}
					}
					//order details added in order.
					order.setOrderDetails(orderDetailList);

					order.setDeliveryNote(inputStream.getDelivery_note());

					order.setProducts_total(total);

				}
				order.setOrder_total(order.getProducts_total() + order.getDelivery_charge());
				orderList.add(order);
				CustomerOrderList col = new CustomerOrderList();
				col.setCid(cid);
				col.setOrder(orderList);
				customerOrderList.add(col);
				Oid oid = new Oid();
				oid.setOid(order.getOid());
				return oid;
			}
		}

		return null;
	}

	public List<OutputOrderStream> getOrders(String cid) {
		for(int i=0;i<customers.size();i++) {
			Customer customer = customers.get(i);			
			if(customer.getCid().equals(cid)) {				
				for(int j=0;j<customerOrderList.size();j++) {
					CustomerOrderList list = customerOrderList.get(j);					
					if(list.getCid().equals(cid)) {
						for(int l=0;l<list.getOrder().size();l++) {
							Order order = list.getOrder().get(l);
							OutputOrderStream oos = new OutputOrderStream();
							oos.setOid(order.getOid());
							oos.setOrder_date(order.getOrder_date());
							oos.setActual_delivery_date(order.getActual_planned_date());
							oos.setPlanned_delivery_date(order.getPlanned_delivery_date());
							oos.setStatus(order.getStatus());
							oos.setFid(order.getFarm_info().getFid().getFid());
							outputOrderStreamList.add(oos);
							
						}
						return outputOrderStreamList;
					}
				}
			}
		}
		return null;
	}

	public Order getOrdersById(String cid, String oid) {
		for(int j=0;j<customerOrderList.size();j++) {
			CustomerOrderList list = customerOrderList.get(j);					
			if(list.getCid().equals(cid)) {
				for(int i =0;i<orderList.size();i++) {
					Order order= orderList.get(i);
					if(order.getOid().equals(oid))
						return order;
				}
			}
		}
		return null ;
	}


}
