package com.wireshout.snipe4j;

import org.apache.http.message.BasicNameValuePair;

public class SupplierFactory extends SnipeObjectFactory {
	public SupplierFactory(String name) {
		super(name);
	}
	
	public Supplier create(SnipeInstance snipe) {
		return (Supplier) this.create(snipe, Supplier.class);
	}
	
	public void setAddress(String address) {
		super.add(new BasicNameValuePair("address", address));
	}
	
	public void setAddress2(String address2) {
		super.add(new BasicNameValuePair("address2", address2));
	}
	
	public void setCity(String city) {
		super.add(new BasicNameValuePair("city", city));
	}
	
	public void setState(String state) {
		super.add(new BasicNameValuePair("state", state));
	}
	
	public void setCountry(String country) {
		super.add(new BasicNameValuePair("country", country));
	}
	
	//This is not implemented yet - Issue #3853
	/*public void setZip(String zip) {
		super.add(new BasicNameValuePair("zip", zip));
	}*/
	
	public void setFax(String fax) {
		super.add(new BasicNameValuePair("fax", fax));
	}
	
	public void setPhone(String phone) {
		super.add(new BasicNameValuePair("phone", phone));
	}
	
	public void setEmail(String email) {
		super.add(new BasicNameValuePair("email", email));
	}
	
	public void setContact(String contact) {
		super.add(new BasicNameValuePair("contact", contact));
	}
	
	//This may be difficult
	/*public void setImage(String image) {
		super.add(new BasicNameValuePair("image", image));
	}*/
	
	//This is not implemented yet - Issue #3853
	/*public void setNotes(String image) {
		super.add(new BasicNameValuePair("image", image));
	}*/
}
