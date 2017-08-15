package com.wireshout.snipe4j;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class CategoryFactory extends SnipeObjectFactory {
	public CategoryFactory(String name, CategoryType type) {
		super(name);
		super.add(new BasicNameValuePair("category_type", type.apiValue()));
	}
	
	public Category create(SnipeInstance snipe) {
		return (Category) this.create(snipe, Category.class);
	}
	
	public void setCategoryType(CategoryType type) {
	}
}
