package PageObjects_FR;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Reusable_actionClass;


public class OrdersPage extends Reusable_actionClass{
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']//following::td[2]")
	List<WebElement> product;
	
	public boolean verifyorderDisplayed(String item)
	{
		for(int i=0;i<product.size();i++)
		{
			if(product.get(i).getText().equalsIgnoreCase(item))
			{
				System.out.println("The Products in the orders page are : "+product.get(i).getText());
				break;
			}
		}
		return true;
		
	}
	

}
