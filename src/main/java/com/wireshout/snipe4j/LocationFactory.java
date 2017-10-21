package com.wireshout.snipe4j;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class LocationFactory extends SnipeObjectFactory {
	public LocationFactory(String name) {
		super(name);
	}
	
	public Location create(SnipeInstance snipe) {
		return (Location) this.create(snipe, Location.class);
	}
	
	public void setAddress(String const_address, String const_city, String const_state, String const_country) {
		super.add(new BasicNameValuePair("address", const_address));
		super.add(new BasicNameValuePair("city", const_city));
		super.add(new BasicNameValuePair("state", const_state));
		super.add(new BasicNameValuePair("country", const_country));
		super.add(new BasicNameValuePair("zip", const_address));
	}
	
	public void setParent(Location parent) {
		super.add(new BasicNameValuePair("parent_id", parent.getId() + ""));
	}
}
