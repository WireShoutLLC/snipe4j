package com.wireshout.snipe4j;

public class CategorySet extends SnipeObjectSet {
	public CategorySet(SnipeInstance snipe) {
		super(snipe, Category.class, "categories");
	}
}
