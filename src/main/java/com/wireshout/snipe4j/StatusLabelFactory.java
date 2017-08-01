package com.wireshout.snipe4j;

public class StatusLabelFactory extends SnipeObjectFactory {
	public StatusLabelFactory(String name) {
		super(name);
	}
	
	public StatusLabel create(SnipeInstance snipe) {
		return (StatusLabel) this.create(snipe, StatusLabel.class);
	}
}
