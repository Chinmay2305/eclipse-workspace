package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import automation.ResultsPage;
import automation.SearchPage;

public class SearchTest
{
	private WebDriver driver;
	private SearchPage searchpage;
	private ResultsPage resultspage;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		
		searchpage = new SearchPage(driver);
		resultspage = new ResultsPage(driver);
	}
	
	@Test
	public void testsearch() throws InterruptedException
	{
		searchpage.enterSearchQuery("Selenium Tests");
		searchpage.enterSearchButton();
		
		Thread.sleep(2000);
		
		String firstresulttitle = resultspage.getFirstResultTitle();
		System.out.println("The first title is: "+firstresulttitle);
		
		assertTrue(firstresulttitle.toLowerCase().contains("selenium"), "First result does contain expected text.");
	}
	
/*	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}*/
}