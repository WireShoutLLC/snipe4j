package com.wireshout.snipe4j;

public class ComponentFactory extends SnipeObjectFactory {
	public ComponentFactory(String name) {
		super(name);
	}
	
	public Component create(SnipeInstance snipe) {
		return (Component) this.create(snipe, Component.class);
	}
}
