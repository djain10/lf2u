package com.cs445.lf2u.Customers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private List<Customer> customers = new ArrayList<>(Arrays.asList());
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
}
