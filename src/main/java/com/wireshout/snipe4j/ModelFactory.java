package com.wireshout.snipe4j;

public class ModelFactory extends SnipeObjectFactory {
	public ModelFactory(String name) {
		super(name);
	}
	
	public Model create(SnipeInstance snipe) {
		return (Model) this.create(snipe, Model.class);
	}
}
