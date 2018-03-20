package com.cs445.lf2u.Customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs445.lf2u.Orders.InputStreamOrder;
import com.cs445.lf2u.Orders.Oid;
import com.cs445.lf2u.Orders.Order;
import com.cs445.lf2u.Orders.OutputOrderStream;


@RestController
@RequestMapping("/lf2u")
public class CustomerController {
	
	@Autowired
	private CustomerService customerSerive;
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers")
	public Cid createCustomer(@RequestBody Customer customer) {
		return customerSerive.createCustomer(customer);
	}

	@RequestMapping("/customers/{cid}")
	public Customer getCustomerDetails(@PathVariable String cid) {
		return customerSerive.getCustomerDetails(cid);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/customers/{cid}")
	public void updateCustomer(@PathVariable String cid, @RequestBody Customer customer) {
		
		customerSerive.updateCustomer(cid, customer);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers/{cid}/orders")
	public Oid createOrder(@PathVariable String cid, @RequestBody InputStreamOrder inputStream) {
		return customerSerive.createOrder(cid,inputStream);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers/{cid}/orders/{oid}")
	public Order getOrdersById(@PathVariable String cid, @PathVariable String oid) {
		return customerSerive.getOrdersById(cid,oid);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers/{cid}/orders")
	public List<OutputOrderStream> getOrders(@PathVariable String cid) {
		return customerSerive.getOrders(cid);
	}
	
	
}
