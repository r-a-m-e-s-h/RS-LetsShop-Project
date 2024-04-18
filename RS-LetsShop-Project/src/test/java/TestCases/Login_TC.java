package TestCases;


import org.testng.annotations.Test;

import PageObjects_FR.LoginPage;


public class Login_TC extends BaseClass{

	
	
	
	
	@Test(groups= {"Smoke","Sanity","Regression"})
	public void login_TC()
	{
		LoginPage lp = new LoginPage(driver);
		lp.goToURL("https://rahulshettyacademy.com/client/");
		lp.loginApplication("testtom@test.com", "Test@8795");	
	}
	
	
	
	
	
	

}
