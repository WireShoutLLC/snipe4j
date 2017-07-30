package com.wireshout.snipe4j;

public class DepartmentSet extends SnipeObjectSet {
	public DepartmentSet(SnipeInstance snipe) {
		super(snipe, Department.class, "departments");
	}
}
