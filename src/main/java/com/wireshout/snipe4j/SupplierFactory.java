package com.wireshout.snipe4j;

public class SupplierFactory extends SnipeObjectFactory {
	public SupplierFactory(String name) {
		super(name);
	}
	
	public Supplier create(SnipeInstance snipe) {
		return (Supplier) this.create(snipe, Supplier.class);
	}
}
