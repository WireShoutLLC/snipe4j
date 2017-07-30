package com.wireshout.snipe4j;

public class CompanySet extends SnipeObjectSet {
	public CompanySet(SnipeInstance snipe) {
		super(snipe, Company.class, "companies");
	}
}
