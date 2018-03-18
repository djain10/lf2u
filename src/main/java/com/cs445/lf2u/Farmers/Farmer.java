package com.cs445.lf2u.Farmers;

import com.cs445.lf2u.IdGenreator.UniqueIdGenerator;

public class Farmer {

	String fid;
	Farm_info farm_info;
	Personal_info personal_info;				
	String[] delivers_to;
	
	public Farmer(){
		this.fid = UniqueIdGenerator.getUniqueID();
	}
		 
	public String getFid() {
		return fid;
	}


	public void setFid(String fid) {
		this.fid = fid;
	}


	public Farm_info getFarm_info() {
		return farm_info;
	}

	public void setFarm_info(Farm_info farm_info) {
		this.farm_info = farm_info;
	}

	public Personal_info getPersonal_info() {
		return personal_info;
	}

	public void setPersonal_info(Personal_info personal_info) {
		this.personal_info = personal_info;
	}

	public String[] getDelivers_to() {
		return delivers_to;
	}

	public void setDelivers_to(String[] delivers_to) {
		this.delivers_to = delivers_to;
	}
	
	
	
}
