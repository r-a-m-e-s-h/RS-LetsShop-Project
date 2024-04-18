	package TestCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2E_Tc {

	@Test(groups= {"Sanity"})
	public void e2e_test() throws InterruptedException {
		
		System.out.println("Driver Initilalized");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().setSize(new Dimension(144, 900));
		
		System.out.println("Browser opened");
		
		System.out.println("Driver Initilalized");

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/client/");

		WebElement emailId = driver.findElement(By.xpath("//input[@id='userEmail']"));
		emailId.sendKeys("testtom@test.com");

		WebElement pwd = driver.findElement(By.xpath("//input[@id='userPassword']"));
		pwd.sendKeys("Test@8795");

		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login']"));
		loginBtn.click();

		ewait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'col-lg-4')]")));

		List<WebElement> products = driver.findElements(
				By.xpath("//*[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().contains("ZARA COAT 3")) {
				List<WebElement> addtoCartBtn = driver.findElements(By.xpath(
						"//*[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']//button//i[@class='fa fa-shopping-cart']"));
				addtoCartBtn.get(i).click();
				break;
			}
		}
		//toast message
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		
		//animation
		ewait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		// ewait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		 Thread.sleep(10000);
		WebElement cartBtn = driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']"));
		cartBtn.click();

		String cartPage = driver.findElement(By.xpath("//h3[contains(text(),'ZARA COAT 3')]")).getText();
		System.out.println("product in the cart page is : "+cartPage);
		//Thread.sleep(3000);
		Assert.assertTrue(cartPage.equalsIgnoreCase("ZARA COAT 3"));

		//
		WebElement checkOutBtn = driver
				.findElement(By.xpath("//*[@class='totalRow']//button[@class='btn btn-primary']"));
		checkOutBtn.click();
		System.out.println("check out btn clicked");

		WebElement countrydd = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		countrydd.sendKeys("ind");
		
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ta-results list-group ng-star-inserted']")));


		/*
		 * ewait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
		 * "//*[@class='ta-backdrop']")));
		 * 
		 * List<WebElement> selectCountry = driver.findElements(By.
		 * xpath("//section[@class='ta-results list-group ng-star-inserted']//following::button//span/i"
		 * ));
		 * 
		 * for (WebElement element : selectCountry) {
		 * if(element.getText().equals("India")) { element.click(); } }
		 */ 


		//static way 
		driver.findElement(By.xpath("(//button[@class='ta-item list-group-item ng-star-inserted']//i)[2]")).click();
		System.out.println("India is selected from dd");
		
		//ewait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btnn.action__submit.ng-star-inserted")));
		
		WebElement placeOrderBtn = driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted"));
			//	driver.findElement(By.xpath("//a[normalize-space()='Place Order']"));
		//placeOrderBtn.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(placeOrderBtn).click().build().perform();
		
		
		System.out.println("place order btn clicked");

		ewait.until(ExpectedConditions.presenceOfElementLocated(By.className("hero-primary")));

		String successMsg = driver.findElement(By.xpath("//h1[contains(text(),' Thankyou for the order. ')]")).getText();
		Assert.assertTrue(successMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		driver.quit();

		// Java Stream concept below
		// WebElement desiredProd = products.stream().filter(product ->
		// product.findElement(By.tagName("b")).getText().equals("ZARA COAT
		// 3")).findFirst().orElse(null);

	}

}

/*
 * for(int j=0;j<cartPage.size();j++) {
 * if(cartPage.get(j).getText().contains("ZARA COAT 3")) { List<WebElement>
 * buyBtn = driver.findElements(By.xpath("//button[@class='btn btn-primary']"));
 * buyBtn.get(j).click(); } }
 */

/*
 * List<WebElement> cartPage =
 * driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
 * 
 * 
 * for(WebElement element : cartPage) { String cartproductText =
 * element.getText(); }
 */
