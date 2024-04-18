package TestCases;

import org.testng.annotations.Test;

import PageObjects_FR.CartPage;
import PageObjects_FR.checkOutPage;
import PageObjects_FR.LoginPage;
import PageObjects_FR.productCataloguePage;

public class CheckoutPage_TC extends BaseClass{
	
	@Test(groups= {"Smoke"})
	public void checkOut_TC()
	{
		LoginPage lp = new LoginPage(driver);
		lp.goToURL("https://rahulshettyacademy.com/client/");
		lp.loginApplication("testtom@test.com", "Test@8795");
		productCataloguePage pc = new productCataloguePage(driver);
		pc.getProductList();
		pc.getProductByNameandCickAddToCart("ZARA COAT 3");
		CartPage cp = new CartPage(driver);
		cp.checkProductPresent("ZARA COAT 3");
		checkOutPage ckp = cp.clickCheckOutBtn();
		//CheckOutpage ckp = new CheckOutpage(driver);
		ckp.enterCountry("India");
		ckp.clickorderBtn();
	}

}
