package TestCases;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects_FR.CartPage;
import PageObjects_FR.checkOutPage;
import PageObjects_FR.LoginPage;
import PageObjects_FR.OrderConfirmationPage_RS;
import PageObjects_FR.OrdersPage;
import PageObjects_FR.productCataloguePage;
import Utilites.Readjson;

public class DataDriven_TC extends BaseClass{


	@Test(groups= {"Regression"},dataProvider = "getData")
	//public void confirmation_tc(String emailId, String pwd, String productName)
	public void confirmation_tc(HashMap<String, String> input) throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.goToURL("https://rahulshettyacademy.com/client/");
		productCataloguePage pc =	lp.loginApplication(input.get("emailId"), input.get("passWord"));
		//productCataloguePage pc = new productCataloguePage(driver);
		pc.getProductList();
		pc.getProductByNameandCickAddToCart(input.get("productName"));
		CartPage cp = new CartPage(driver);
		cp.checkProductPresent(input.get("productName"));
		checkOutPage ckp = cp.clickCheckOutBtn();
		//CheckOutpage ckp = new CheckOutpage(driver);
		ckp.enterCountry("India");
		OrderConfirmationPage_RS op = ckp.clickorderBtn();

		//OrderConfirmationPage_RS op = new OrderConfirmationPage_RS(driver);
		String txt =op.verifySuccessMsgDisplayed();
		Assert.assertTrue(txt.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		TakeScreenshot("OrderConfirmationPage");
	}

	@Test(dependsOnMethods="confirmation_tc")
	public void orderDisplayed() throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.goToURL("https://rahulshettyacademy.com/client/");
		productCataloguePage pc =	lp.loginApplication("testtom@test.com", "Test@8795");
		OrdersPage op = pc.gotoOrdersPage();
		Assert.assertTrue(op.verifyorderDisplayed("ZARA COAT 3"));
		TakeScreenshot("OrderConfirmationPage");


	}
	//using json file 
	@DataProvider
	public Object[][] getData() throws IOException
	{
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "java", "Utilites", "data.json");
		File floc = filePath.toFile();
		String filePathString = floc.getPath();
		
		Readjson rjs = new Readjson();
		List<HashMap<String, String>>data =rjs.getJsonDataToMap(filePathString);


		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
//using hashnap
/*
 * @DataProvider 
 * public Object[][] getData() 
 * { 
 * HashMap<String, String> map = newHashMap<String,String>(); 
 * map.put("emailId", "testtom@test.com");
 * map.put("passWord", "Test@8795");
 *  map.put("productName", "ZARA COAT 3");
 * 
 * HashMap<String, String> map1 = new HashMap<String, String>();
 * map1.put("emailId", "testtom@test.com");
 *  map1.put("passWord", "Test@8795");
 * map1.put("productName", "ADIDAS ORIGINAL");
 * 
 * return new Object[][] {{map},{map1}};
 * 
 * }
 */
/*
 * @DataProvider 
 * public Object[][] getData() 
 * { 
 * return new Object[][]
 * {{"testtom@test.com","Test@8795","ZARA COAT 3"},{"testtom@test.com",
 * "Test@8795","ADIDAS ORIGINAL"}}; 
 * }
 */



