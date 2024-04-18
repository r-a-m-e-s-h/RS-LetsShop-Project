package PageObjects_FR;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.Reusable_actionClass;

public class CartPage extends Reusable_actionClass {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@class='totalRow']//button[@class='btn btn-primary']")
	WebElement checkOutBtn;
	
	@FindBy(xpath="//div[@class='cart']//ul//li//h3")
	WebElement cartItems;
	
	public String checkProductPresent(String productName)
	{
		gtoTOCartPage();
		
		//return 
		//String cartPage = driver.findElement(By.xpath("//h3[contains(text(),'ZARA COAT 3')]")).getText();
		String cartPage=cartItems.getText();
		System.out.println("product in the cart page is : "+cartPage);
		return cartPage;
	}
	public checkOutPage clickCheckOutBtn()
	{
		checkOutBtn.click();
		return new checkOutPage(driver);
		
	}
	
}
