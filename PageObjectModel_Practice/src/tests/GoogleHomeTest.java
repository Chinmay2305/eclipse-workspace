package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.GoogleHomePage;

public class GoogleHomeTest
{
	static WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://www.google.com";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//Actual test steps - It creates an object of GoogleHomePage class and calls its respective methods
	@Test(priority=0)
	public void googlesearch()
	{
		GoogleHomePage gs = new GoogleHomePage(driver);
		gs.search();
		gs.submit();
	}
	
	@AfterTest
	public void closing()
	{
		driver.quit();
	}
}