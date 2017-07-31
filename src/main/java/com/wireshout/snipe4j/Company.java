package com.wireshout.snipe4j;

public class Company extends SnipeObject {
	public final static String ENDPOINT = "companies";
	
	public Company(SnipeInstance snipe, int id) {
		super(snipe, id);
		refresh(getEndpoint());
	}

	public static String getEndpoint() {
		return ENDPOINT;
	}
	
	public boolean delete() {
		return super.delete(getEndpoint());
	}
}
