package test.yourpackage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.*;

import properties.BaseTest;
import properties.TestPage;

public class YourTest extends BaseTest
{
	private TestPage testpage;
	
	@BeforeTest
	public void setup1()
	{
		setup();
		testpage = new TestPage(driver, properties);
	}
	
	
	@Test
	public void testLogin()
	{
		
		testpage.login("chinmay.agrawal@acumen.aero", "Abcde1234$");
		
		//Check URL after correct login
		String expectedurl = "https://qa.console.sparta.aero/";
		String actualurl = driver.getCurrentUrl();
		assertEquals(expectedurl, actualurl);	
	}
	
	@AfterTest
	public void teardown()
	{
		teardown();
	}
}