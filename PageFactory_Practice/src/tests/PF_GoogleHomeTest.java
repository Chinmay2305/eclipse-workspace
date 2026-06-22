package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automation.PF_GoogleHomePage;

public class PF_GoogleHomeTest
{
	static WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://www.google.com";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=0)
	public void googlesearch()
	{
		PF_GoogleHomePage p = new PF_GoogleHomePage(driver);
		p.search();
		p.submit();
	}
	@AfterTest
	public void closing() throws InterruptedException
	{
		driver.quit();
	}
}