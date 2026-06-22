package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import automation.ContactUs_POM;

public class ContactUs_Test_POM
{
	private WebDriver driver;
	private ContactUs_POM c;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.holadata.co.za/contact-us");
		c = new ContactUs_POM(driver);
	}
	
	@Test
	public void testContactForm() throws InterruptedException
	{
		c.enterFName("Chinmay");
		c.enterLName("Agrawal");
		c.enterEmail("chinmay230587@gmail.com");
		c.enterContact("8238997664");
		c.enterMessage("This is testing using POM.");
		c.clickSubmit();
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
}