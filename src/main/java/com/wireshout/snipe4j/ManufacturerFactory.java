package com.wireshout.snipe4j;

import org.apache.http.message.BasicNameValuePair;

public class ManufacturerFactory extends SnipeObjectFactory {
	public ManufacturerFactory(String name) {
		super(name);
	}
	
	public Manufacturer create(SnipeInstance snipe) {
		return (Manufacturer) this.create(snipe, Manufacturer.class);
	}
	
	public void setUrl(String url) {
		super.add(new BasicNameValuePair("url", url));
	}
	
	public void setSupportUrl(String support_url) {
		super.add(new BasicNameValuePair("support_url", support_url));
	}
	
	public void setSupportPhone(String support_phone) {
		super.add(new BasicNameValuePair("support_phone", support_phone));
	}
	
	public void setSupportEmail(String support_email) {
		super.add(new BasicNameValuePair("support_email", support_email));
	}
}
