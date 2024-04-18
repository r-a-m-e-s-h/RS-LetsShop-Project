package PageObjects_FR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.Reusable_actionClass;

public class OrderConfirmationPage_RS extends Reusable_actionClass{
	
	WebDriver driver;
	
	public OrderConfirmationPage_RS(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
	@FindBy(xpath="//h1[contains(text(),' Thankyou for the order. ')]")
	WebElement successMsg;
	
	public String verifySuccessMsgDisplayed()
	{
		String txt = successMsg.getText();
		return txt;

	}

}
