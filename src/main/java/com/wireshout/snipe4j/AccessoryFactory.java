package com.wireshout.snipe4j;

import org.apache.http.message.BasicNameValuePair;

public class AccessoryFactory extends SnipeObjectFactory {
	public AccessoryFactory(String name, Category category, int qty) {
		super(name);
		super.add(new BasicNameValuePair("category_id", category.getId() + ""));
		super.add(new BasicNameValuePair("qty", qty + ""));
	}
	
	public Accessory create(SnipeInstance snipe) {
		return (Accessory) this.create(snipe, Accessory.class);
	}
	
	public void setCompany(Company company) {
		super.add(new BasicNameValuePair("company_id", company.getId() + ""));
	}
	
	public void setManufacturer(Manufacturer manufacturer) {
		super.add(new BasicNameValuePair("manufacturer_id", manufacturer.getId() + "")); //This is broken in snipe - Issue #3849
	}
	
	public void setModelNumber(String model_number) {
		super.add(new BasicNameValuePair("model_number", model_number));
	}
	
	public void setLocation(Location location) {
		super.add(new BasicNameValuePair("location_id", location.getId() + ""));
	}
	
	public void setOrderNumber(String order_number) {
		super.add(new BasicNameValuePair("order_number", order_number + ""));
	}
	
	public void setNotes(String notes) {
		super.add(new BasicNameValuePair("notes", notes)); //This is broken in snipe - Issue #3849
	}
}
