package com.cs445.lf2u.Farmers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {

	private List<Farmer> farmers= new ArrayList<>();
	private List<FarmProducts> farmProd = new ArrayList<>();
	
	public Fid addFarmer(Farmer farmer) {
		farmers.add(farmer);
		Fid fi = new Fid();
		fi.setFid(farmer.getFid());
		return fi;		
	}
	
	public Farmer getFarmer(String fid) {
		 return farmers.stream().filter(t->t.getFid().equals(fid)).findFirst().get();
	}

	public void updateFarmer(String fid, Farmer farmer) {		
		try {
		for(int i=0;i<farmers.size();i++) {
			Farmer f = farmers.get(i);
			if(f.getFid().equals(fid)) {
				farmer.setFid(fid);
				farmers.set(i, farmer);				
				return; 
			}
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ZipCodeFarm findviaZip(String zip) {
		
		for(int i=0;i<farmers.size();i++) {
			Farmer f = farmers.get(i);			
			ZipCodeFarm zcf = new ZipCodeFarm();
			for(int j=0;j<f.delivers_to.length;j++) {
				if(f.delivers_to[j].equals(zip)) {
					
					zcf.setFid(f.getFid());
					zcf.setName(f.getFarm_info().getName());
					return zcf;
				}
				
			}
			
		
		}
		return null;
		
		
	}

	public FarmProducts addFarmProduct(String fid, JSONArray farmProducts) throws JSONException {
		FarmProducts farmProduct = new FarmProducts();
		JSONArray list = new JSONArray();
		JSONArray jsonArray = new JSONArray(farmProducts);
		int length = jsonArray.length();
		if(jsonArray !=null) {
			for(int i = 0;i<length;i++) {
				if(i!=0) {
					farmProduct
				}
			}
		}
		return null;
	}
}
