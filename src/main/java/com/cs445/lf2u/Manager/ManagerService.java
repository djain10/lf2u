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
	
	public List<Manager> showAccounts() {
		
		return managers;
	}
	
	public Manager getManager(String mid) {
		return managers.stream().filter(t->t.getMid().equals(mid)).findFirst().get();
	}

}
