package com.wireshout.snipe4j;

public class LicenseFactory extends SnipeObjectFactory {
	public LicenseFactory(String name) {
		super(name);
	}
	
	public License create(SnipeInstance snipe) {
		return (License) this.create(snipe, License.class);
	}
}
