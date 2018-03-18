package com.cs445.lf2u.Farmers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.cs445.lf2u.Manager.Catalog;
import com.cs445.lf2u.Manager.ManagerService;

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

	public Fspid addFarmProduct(String fid, JSONObject inputData) throws JSONException {
				
		ManagerService manager = new ManagerService();
		
		
		for(int i=0;i<manager.catalogs.size();i++) {
			Catalog catalog = manager.catalogs.get(i);
			String gcpid = (String) inputData.get("gcpid");
			if(catalog.getGcpid().equals(gcpid)) {
				FarmProducts farmProduct = new FarmProducts();
				Fspid fspid = new Fspid();
				farmProduct.setNote((String)inputData.get("note"));
				fspid.setFspid(farmProduct.getFspid());
				return fspid;
			}
		}
		return null;
	}
}
