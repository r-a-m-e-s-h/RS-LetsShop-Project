package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects_FR.CartPage;
import PageObjects_FR.checkOutPage;
import PageObjects_FR.LoginPage;
import PageObjects_FR.OrderConfirmationPage_RS;
import PageObjects_FR.OrdersPage;
import PageObjects_FR.productCataloguePage;

public class orderConfirmation_TC extends BaseClass{


	@Test(groups= {"Regression"},dataProvider = "getData")
	public void confirmation_tc(String emailId, String pwd, String productName)
	{
		LoginPage lp = new LoginPage(driver);
		lp.goToURL("https://rahulshettyacademy.com/client/");
		productCataloguePage pc =	lp.loginApplication(emailId, pwd);
		//productCataloguePage pc = new productCataloguePage(driver);
		pc.getProductList();
		pc.getProductByNameandCickAddToCart(productName);
		CartPage cp = new CartPage(driver);
		cp.checkProductPresent(productName);
		checkOutPage ckp = cp.clickCheckOutBtn();
		//CheckOutpage ckp = new CheckOutpage(driver);
		ckp.enterCountry("India");
		OrderConfirmationPage_RS op = ckp.clickorderBtn();

		//OrderConfirmationPage_RS op = new OrderConfirmationPage_RS(driver);
		String txt =op.verifySuccessMsgDisplayed();
		Assert.assertTrue(txt.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods="confirmation_tc")
	public void orderDisplayed()
	{
		LoginPage lp = new LoginPage(driver);
		lp.goToURL("https://rahulshettyacademy.com/client/");
		productCataloguePage pc =	lp.loginApplication("testtom@test.com", "Test@8795");
		OrdersPage op = pc.gotoOrdersPage();
		Assert.assertTrue(op.verifyorderDisplayed("ZARA COAT 3"));


	}
	
	  @DataProvider 
	  public Object[][] getData()
	  { 
		  return new Object[][]
	  {
			  {"testtom@test.com","Test@8795","ZARA COAT 3"},{"testtom@test.com",
	  "Test@8795","ADIDAS ORIGINAL"}
			  }; 
	  }
	 
	
	
	
}