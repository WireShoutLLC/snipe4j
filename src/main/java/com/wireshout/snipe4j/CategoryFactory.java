package com.wireshout.snipe4j;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class CategoryFactory extends SnipeObjectFactory {
	public CategoryFactory(String name) {
		super(name);
	}
	
	public Category create(SnipeInstance snipe) {
		return (Category) this.create(snipe, Category.class);
	}
	
	public void setCategoryType(CategoryType type) {
		NameValuePair field = new BasicNameValuePair("category_type", type.apiValue());
		super.add(field);
	}
}
