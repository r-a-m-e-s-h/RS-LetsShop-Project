package PageObjects_FR;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Reusable_actionClass;

public class productCataloguePage extends Reusable_actionClass {

	WebDriver driver;

	public productCataloguePage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")
	List<WebElement> productsList;
	
	@FindBy(xpath="//*[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']//button//i[@class='fa fa-shopping-cart']")
	List<WebElement> addToCartBtn;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(By.xpath("//div[contains(@class,'col-lg-4')]"));
		return productsList;
	}
	public CartPage getProductByNameandCickAddToCart(String productName)
	{
		for (int i = 0; i < productsList.size(); i++) 
		{
			if (productsList.get(i).getText().contains(productName)) 
			{
				addToCartBtn.get(i).click();
				break;
			}
		}
		waitForElementToAppear(By.xpath("//div[@id='toast-container']"));
		waitForElementToDisAppear(spinner);
		return new CartPage(driver);
	}
	
	
}
