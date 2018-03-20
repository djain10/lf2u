package com.cs445.lf2u.Model;

import com.cs445.lf2u.Util.UniqueIdGenerator;

public class Catalog {

	String gcpid;
	String name;
	
	public Catalog() {
		this.gcpid = UniqueIdGenerator.getUniqueGCID();
	}
	
	public String getGcpid() {
		return gcpid;
	}
	
	public void setGcpid(String gcpid) {
		this.gcpid = gcpid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
