package com.wireshout.snipe4j;

public class Company extends SnipeObject {
	public Company(SnipeInstance snipe, int id) {
		super(snipe, id, "companies");

	}
	
	public Company(SnipeInstance snipe, CompanyFactory create) {
		super(snipe, create);
	}
}
