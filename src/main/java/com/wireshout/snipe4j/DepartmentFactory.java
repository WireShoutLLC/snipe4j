package com.wireshout.snipe4j;

public class DepartmentFactory extends SnipeObjectFactory {
	public DepartmentFactory(String name) {
		super(name);
	}
	
	public Department create(SnipeInstance snipe) {
		return (Department) this.create(snipe, Department.class);
	}
}
