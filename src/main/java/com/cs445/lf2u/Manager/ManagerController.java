package com.cs445.lf2u.Manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
