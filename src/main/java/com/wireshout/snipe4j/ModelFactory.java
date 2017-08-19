package com.wireshout.snipe4j;

import org.apache.http.message.BasicNameValuePair;

public class ModelFactory extends SnipeObjectFactory {
	public ModelFactory(String name, Manufacturer mfg, Category category) {
		super(name);
		super.add(new BasicNameValuePair("manufacturer_id", mfg.getId() + ""));
		super.add(new BasicNameValuePair("category_id", category.getId() + ""));
	}
	
	public void setNotes(String notes) {
		super.add(new BasicNameValuePair("notes", notes));
	}
	
	public void setDepreciation(Depreciation depreciation) {
		super.add(new BasicNameValuePair("depreciation_id", depreciation.getId() + ""));
	}
	
	public void setModelNumber(String model_number) {
		super.add(new BasicNameValuePair("model_number", model_number));
	}
	
	public Model create(SnipeInstance snipe) {
		return (Model) this.create(snipe, Model.class);
	}
}
