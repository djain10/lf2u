package com.cs445.lf2u.Orders;

import com.cs445.lf2u.Farmers.Farm_info;
import com.cs445.lf2u.Farmers.Fid;

public class OrderFarmInfo {
	
	Fid fid;
	Farm_info faminfo;
	public Fid getFid() {
		return fid;
	}
	public void setFid(Fid fid) {
		this.fid = fid;
	}
	public Farm_info getFaminfo() {
		return faminfo;
	}
	public void setFaminfo(Farm_info faminfo) {
		this.faminfo = faminfo;
	}
	
}
