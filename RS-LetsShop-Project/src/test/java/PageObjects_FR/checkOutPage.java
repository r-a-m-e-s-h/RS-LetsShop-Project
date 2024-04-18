package PageObjects_FR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Reusable_actionClass;

public class checkOutPage extends Reusable_actionClass {
	
	WebDriver driver;

	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countrydd;
	
	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement placeOrderBtn;
	
	public void enterCountry(String countryName)
	{
		countrydd.sendKeys(countryName);
		waitForElementToAppear(By.xpath("//*[@class='ta-results list-group ng-star-inserted']"));
		driver.findElement(By.xpath("(//button[@class='ta-item list-group-item ng-star-inserted']//i)[2]")).click();	
	}
	public OrderConfirmationPage_RS clickorderBtn()
	{
		placeOrderBtn.click();
		return new  OrderConfirmationPage_RS(driver);
	}
	

}
