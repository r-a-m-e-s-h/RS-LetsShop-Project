package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects_FR.CartPage;
import PageObjects_FR.LoginPage;
import PageObjects_FR.productCataloguePage;

public class CartPage_TC extends BaseClass{
	
	@Test(groups= {"Smoke"})
	public void cart_TC()
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.goToURL("https://rahulshettyacademy.com/client/");
		lp.loginApplication("testtom@test.com", "Test@8795");
		productCataloguePage pc = new productCataloguePage(driver);
		pc.getProductList();
		CartPage cp = pc.getProductByNameandCickAddToCart("ZARA COAT 3");
//		CartPage cp = new CartPage(driver);
		String expectedProduct = cp.checkProductPresent("ZARA COAT 3");
		Assert.assertTrue(expectedProduct.equalsIgnoreCase("ZARA COAT 3"));
		cp.clickCheckOutBtn();
	}

}
