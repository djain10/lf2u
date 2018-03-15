package com.cs445.lf2u.Farmers;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lf2u")
public class FarmerController {

	@Autowired
	private FarmerService farmerService;
		
	@RequestMapping(method = RequestMethod.POST, value = "/farmers")
	public Fid addFarmer(@RequestBody Farmer farmer) {
		
		return farmerService.addFarmer(farmer);
	}
	
	@RequestMapping ("/farmers/{fid}")
	public Farmer getFarmer(@PathVariable String fid) {
		return farmerService.getFarmer(fid);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/farmers/{fid}")
	public void updateFarmer( @PathVariable String fid,@RequestBody Farmer farmer) {
		
		farmerService.updateFarmer(fid,farmer);
	}
	
	@RequestMapping ("/farmers")
	public ZipCodeFarm findviaZip(@QueryParam(value = "zip") String zip) {
		return farmerService.findviaZip(zip);
		
	}
}
