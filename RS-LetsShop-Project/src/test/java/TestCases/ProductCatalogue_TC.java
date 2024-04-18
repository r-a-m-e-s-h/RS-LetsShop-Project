package TestCases;


import org.testng.annotations.Test;

import PageObjects_FR.LoginPage;
import PageObjects_FR.productCataloguePage;

public class ProductCatalogue_TC  extends BaseClass {
	
	

	
	@Test(groups= {"Smoke","Regression"})
	public void productCatalogue_TC()
	{
		LoginPage lp = new LoginPage(driver);
		lp.goToURL("https://rahulshettyacademy.com/client/");
		productCataloguePage pc=	lp.loginApplication("testtom@test.com", "Test@8795");
//		productCataloguePage pc = new productCataloguePage(driver);
		pc.getProductList();
		pc.getProductByNameandCickAddToCart("ZARA COAT 3");
	}

}
