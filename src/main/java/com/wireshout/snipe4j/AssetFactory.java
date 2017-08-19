package com.wireshout.snipe4j;

import org.apache.http.message.BasicNameValuePair;

public class AssetFactory extends SnipeObjectFactory {
	public AssetFactory(String asset_tag) {
		super("");
		super.add(new BasicNameValuePair("asset_tag", asset_tag));
	}
	
	public AssetFactory(String asset_tag, String name) {
		super(name);
		super.add(new BasicNameValuePair("asset_tag", asset_tag));
	}
	
	public void setNotes(String notes) {
		super.add(new BasicNameValuePair("notes", notes));
	}
	
	public void setSerial(String serial) {
		super.add(new BasicNameValuePair("serial", serial));
	}
	
	public void setModel(Model model) {
		super.add(new BasicNameValuePair("model_id", model.getId() + ""));
	}
	
	public void setStatusLabel(StatusLabel status) {
		super.add(new BasicNameValuePair("status_id", status.getId() + ""));
	}
	
	public void setDefaultLocation(Location location) {
		super.add(new BasicNameValuePair("rtd_location_id", location.getId() + ""));
	}
	
	public void setSupplier(Supplier supplier) {
		super.add(new BasicNameValuePair("supplier_id", supplier.getId() + ""));
	}
	
	public void setCompany(Company company) {
		super.add(new BasicNameValuePair("company_id", company.getId() + ""));
	}
	
	public Asset create(SnipeInstance snipe) {
		return (Asset) this.create(snipe, Asset.class);
	}
}
