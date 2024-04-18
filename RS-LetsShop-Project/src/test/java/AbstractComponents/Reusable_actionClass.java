package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects_FR.CartPage;
import PageObjects_FR.OrdersPage;

public class Reusable_actionClass {

	
	WebDriver driver;
	
	public Reusable_actionClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartHeaderBtn;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement ordersBtn;
	
	
	
	
	public void waitForElementToAppear(By findby)
	{
		WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waitForElementToDisAppear(WebElement element)
	{
		WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	
	public CartPage gtoTOCartPage()
	{
		cartHeaderBtn.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	public OrdersPage gotoOrdersPage()
	{
		ordersBtn.click();
		OrdersPage op = new OrdersPage(driver);
		return op;
		
	}
	
}
