package com.cs445.lf2u.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
}
