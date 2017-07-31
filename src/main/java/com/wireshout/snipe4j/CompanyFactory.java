package com.wireshout.snipe4j;

public class CompanyFactory extends SnipeObjectFactory {
	public CompanyFactory(String name) {
		super(name);
	}
	
	public Company create(SnipeInstance snipe) {
		return (Company) this.create(snipe, Company.class);
	}
}
