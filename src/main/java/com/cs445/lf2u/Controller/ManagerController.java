package com.cs445.lf2u.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs445.lf2u.Model.Catalog;
import com.cs445.lf2u.Model.Gcpid;
import com.cs445.lf2u.Model.Manager;
import com.cs445.lf2u.Model.Name;
import com.cs445.lf2u.Service.ManagerService;

@RestController
@RequestMapping("/lf2u/managers")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/accounts")
	public List<Manager> showAccounts() {
		return managerService.showAccounts();
	}
	
	
	@RequestMapping("/accounts/{mid}")
	public Manager getTopic(@PathVariable String mid) {
		return managerService.getManager(mid);
	}
	
	@RequestMapping(method = RequestMethod.POST, value= "/catalog")
	public Gcpid addProduct(@RequestBody Catalog catalog) {
		return managerService.addProduct(catalog);		
	}
	
	@RequestMapping ("/catalog/{gcpid}")
	public Name getProduct(@PathVariable String gcpid) {
		return managerService.getProduct(gcpid);
		
	}
	
	@RequestMapping ("/catalog")
	public List<Catalog> getProducts() {
		return managerService.getProducts();
		
	}
}
