package com.cs445.lf2u.Farmers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cs445.lf2u.Manager.Catalog;
import com.cs445.lf2u.Manager.ManagerService;

@Service
public class FarmerService {

	private List<Farmer> farmers= new ArrayList<>();
	private List<FarmProduct> farmProd = new ArrayList<>();
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
						FarmProduct farmProduct = new FarmProduct();
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

	public List<FarmProduct> getFarmerProductsList(String fid){
		List<FarmProduct> temp = new ArrayList<>();
		for(int i = 0;i<productList.size();i++) {
			FarmProductList farmProduct = productList.get(i);			
			if(farmProduct.getFid().equals(fid)) {
				temp.add(farmProduct.getFarmProduct());

			}
		}
		return temp;
	}

	public FarmProduct getFarmProduct(String fid, String fspid) {
		for(int i=0;i<productList.size();i++) {
			FarmProductList prodList = productList.get(i);
			if(prodList.getFid().equals(fid)) {
				for(int j=0;j<farmProd.size();j++) {
					FarmProduct farmProducts = farmProd.get(j);
					if(farmProducts.getFspid().equals(fspid)) {
						return farmProducts;
					}
				}
			}
		}

		return null;
	}

	public void updateFarmerProduct(String fid, String fspid, FarmProduct farmProduct) {
		for(int j=0;j<farmers.size();j++) {
			Farmer farmer = farmers.get(j);
			if(farmer.getFid().equals(fid)) {				   
				for(int i=0;i<farmProd.size();i++) {
					FarmProduct farmPro = farmProd.get(i);
					if(farmProduct.getFspid().equals(fspid)) {
						if(!farmProduct.getNote().equals(null)) {
							farmPro.setNote(farmProduct.getNote());
						}
						if(!farmProduct.getStart_date().equals(null)) {
							farmPro.setStart_date(farmProduct.getStart_date());
						}
						if(!farmProduct.getEnd_date().equals(null)) {
							farmPro.setEnd_date(farmProduct.getEnd_date());
						}
						double priceValue =farmProduct.getPrice();
						if(!(priceValue == 0)) {
						
							farmPro.setPrice(farmProduct.getPrice());
						}
						if(!farmProduct.getProduct_unit().equals(null)) {
							farmPro.setProduct_unit(farmProduct.getProduct_unit());
						}
						if(!farmProduct.getImage().equals(null)) {
							farmPro.setImage(farmProduct.getImage());
						}
						
						
					}
				}
			}
		}
		
	}
}
