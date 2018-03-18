package com.cs445.lf2u.Farmers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cs445.lf2u.Manager.Catalog;
import com.cs445.lf2u.Manager.ManagerService;

@Service
public class FarmerService {

	private List<Farmer> farmers= new ArrayList<>();
	private List<FarmProducts> farmProd = new ArrayList<>();
	private List<FarmProductList> productList = new ArrayList<>(); 

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

	public Fspid addFarmProduct(String fid, InputDataBean inputData) {


		for(int j=0;j<farmers.size();j++) {
			Farmer farmer = farmers.get(j);
			if(farmer.getFid().equals(fid)) {				
				for(int i=0;i<ManagerService.catalogs.size();i++) {
					Catalog catalog = ManagerService.catalogs.get(i);			
					String gcpid = inputData.getGcpid();
					if(catalog.getGcpid().equals(gcpid)) {
						FarmProducts farmProduct = new FarmProducts();
						Fspid fspid = new Fspid();
						FarmProductList prodList = new FarmProductList();
						farmProduct.setName(catalog.getName());
						farmProduct.setNote(inputData.getNote());
						farmProduct.setStart_date(inputData.getStart_date());
						farmProduct.setEnd_date(inputData.getEnd_date());
						farmProduct.setPrice(inputData.getPrice());
						farmProduct.setProduct_unit(inputData.getProduct_unit());
						farmProduct.setImage(inputData.getImage());
						farmProd.add(farmProduct);
						prodList.setFid(fid);
						prodList.setFarmProduct(farmProduct);
						productList.add(prodList);
						fspid.setFspid(farmProduct.getFspid());
						return fspid;
					}
				}
			}

		}
		return null;
	}

	public List<FarmProducts> getFarmerProductsList(String fid){
		List<FarmProducts> temp = new ArrayList<>();
		for(int i = 0;i<productList.size();i++) {
			FarmProductList farmProduct = productList.get(i);			
			if(farmProduct.getFid().equals(fid)) {
				temp.add(farmProduct.getFarmProduct());

			}
		}
		return temp;
	}

	public FarmProducts getFarmProduct(String fid, String fspid) {
		for(int i=0;i<productList.size();i++) {
			FarmProductList prodList = productList.get(i);
			if(prodList.getFid().equals(fid)) {
				for(int j=0;j<farmProd.size();j++) {
					FarmProducts farmProducts = farmProd.get(j);
					if(farmProducts.getFspid().equals(fspid)) {
						return farmProducts;
					}
				}
			}
		}

		return null;
	}
}
