package com.cs445.lf2u.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
	
	private List<Manager> managers = new ArrayList<>(Arrays.asList(
			new Manager( "0","Super User","System","20161001","123-0987-654","superuser@example.com"),
			
			new Manager("79","Johnny Smith","Super User","20161015","123-0987-659","johnny.smith@example.com")
			));
	
	private List<Catalog> catalogs = new ArrayList<>(Arrays.asList());
	
	public List<Manager> showAccounts() {
		
		return managers;
	}
	
	public Manager getManager(String mid) {
		return managers.stream().filter(t->t.getMid().equals(mid)).findFirst().get();
	}

	public Gcpid addProduct(Catalog catalog) {
		catalogs.add(catalog);		
		Gcpid gcpid = new Gcpid();
		gcpid.setGcpid(catalog.getGcpid());
		
		return gcpid;
	}

	public Name getProduct(String gcpid) {
		 //return catalogs.stream().filter(t->t.getGcpid().equals(gcpid)).findFirst().get();
		
		Name name = new Name();
		for(int i = 0; i<catalogs.size();i++) {
			Catalog catalog = catalogs.get(i);
			if(catalogs.get(i).getGcpid().equals(gcpid)){
				name.setName(catalog.getName());
				return name;
			}
		}
		return null;
	}

	public List<Catalog> getProducts() {
		// TODO Auto-generated method stub
		
		return catalogs;
	}
}
