package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utilites.ReadConfig_RH;

public class BaseClass {

	public WebDriver driver;
	
	ReadConfig_RH config = new ReadConfig_RH();
	String emailId = config.getUserMailId();
	String passWord = config.getPassWord();
	String browserName_cp = config.browserName();

	@BeforeMethod(alwaysRun=true)
	public void setup()
	{
		String browser = System.getProperty("browserName")!=null ? System.getProperty("browserName"):browserName_cp;
		
		// above code is to get browser name from maven (if given or  it will get from the code) 
		// command => mvn clean install -PDataDriven -DbrowserName=chrome
		// -D(used for parameter)
		//-P denote profile 
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		System.out.println("Chrome driver started");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			System.out.println("FireFox driver started");
		}
		else
		{
			driver = new EdgeDriver();
			System.out.println("Edge driver started");
		}

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void TakeScreenshot(String testcaseName) throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//Screenshots"+testcaseName+".png");
		FileUtils.copyFile(src, dest);
		
		
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}

}
