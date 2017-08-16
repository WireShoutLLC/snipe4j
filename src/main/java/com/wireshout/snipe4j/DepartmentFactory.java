package com.wireshout.snipe4j;

import org.apache.http.message.BasicNameValuePair;

public class DepartmentFactory extends SnipeObjectFactory {
	public DepartmentFactory(String name) {
		super(name);
	}
	
	public Department create(SnipeInstance snipe) {
		return (Department) this.create(snipe, Department.class);
	}
	
	public void setCompany(Company company) {
		super.add(new BasicNameValuePair("company_id", company.getId() + ""));
	}
	
	public void setLocation(Location location) {
		super.add(new BasicNameValuePair("location_id", location.getId() + ""));
	}
	
	public void setManager(User manager) {
		super.add(new BasicNameValuePair("manager_id", manager.getId() + ""));
	}
}
