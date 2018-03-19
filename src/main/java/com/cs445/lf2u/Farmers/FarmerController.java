package com.cs445.lf2u.Farmers;

import java.util.List;

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
	
	@RequestMapping(method = RequestMethod.POST,value = "/farmers/{fid}/products" )
	public Fspid addFarmProduct(@PathVariable String fid, @RequestBody InputDataBean inputData) {
	
		return farmerService.addFarmProduct(fid, inputData);
	}
	
	@RequestMapping("/farmers/{fid}/products")
	public List<FarmProduct> getFarmerProductsList(@PathVariable String fid){
		return farmerService.getFarmerProductsList(fid);
	}
	
	@RequestMapping("/farmers/{fid}/products/{fspid}")
	public FarmProduct getFarmProduct(@PathVariable String fid,@PathVariable String fspid) {
		return farmerService.getFarmProduct(fid,fspid);
	}
	
	@RequestMapping(method = RequestMethod.POST,value ="/farmers/{fid}/products/{fspid}")
	public void updateFarmerProduct(@PathVariable String fid,@PathVariable String fspid, @RequestBody FarmProduct farmProduct){
		farmerService.updateFarmerProduct(fid,fspid, farmProduct);
	}
	
}
