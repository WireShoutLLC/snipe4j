package com.wireshout.snipe4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Runner {
	public static void main(String[] args) throws Exception {
		Properties defaultProps = new Properties();
		FileInputStream in = new FileInputStream("snipe4j.properties");
		defaultProps.load(in);
		in.close();

		Properties applicationProps = new Properties(defaultProps);
		
		String apiEndpoint = applicationProps.getProperty("apiEndpoint");
		String apiKey = applicationProps.getProperty("apiKey");
		SnipeInstance mims = new SnipeInstance(apiEndpoint, apiKey);
		
		/* AccessorySet accessories = new AccessorySet(mims);
		AssetSet assets = new AssetSet(mims);
		CategorySet categories = new CategorySet(mims);
		CompanySet companies = new CompanySet(mims);
		ComponentSet components = new ComponentSet(mims);
		ConsumableSet consumables = new ConsumableSet(mims);
		DepartmentSet departments = new DepartmentSet(mims);
		DepreciationSet depreciations = new DepreciationSet(mims);
		//FieldSetSet???
		GroupSet groups = new GroupSet(mims);
		LicenseSet licenses = new LicenseSet(mims);
		LocationSet locations = new LocationSet(mims);
		ManufacturerSet manufacturers = new ManufacturerSet(mims);
		ModelSet models = new ModelSet(mims);
		StatusLabelSet statuslabels = new StatusLabelSet(mims);
		SupplierSet suppliers = new SupplierSet(mims);
		UserSet users = new UserSet(mims); */
		
		//Test full lifecycle
		CategorySet categoryList = new CategorySet(mims);
		CategoryFactory testFactory = new CategoryFactory("Test");
		testFactory.setCategoryType(CategoryType.Accessory);
		Category testObject = testFactory.create(mims);
		System.out.println("New Category! ID: " + testObject.getId());
		boolean diditwork = testObject.delete();
		testObject = null;
		System.out.println("Did it delete?    " + diditwork);
	}
}
