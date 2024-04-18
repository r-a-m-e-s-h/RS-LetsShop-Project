package PageObjects_FR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {


	WebDriver driver;


	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement emailId;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement loginBtn;
	
	public productCataloguePage loginApplication(String email, String password)
	{
		emailId.sendKeys(email);
		pwd.sendKeys(password);
		loginBtn.click();
		return new productCataloguePage(driver);
	}
	public void goToURL(String url)
	{
		driver.get(url);
	}
	
	


}
