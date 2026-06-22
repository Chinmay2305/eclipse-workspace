package automation.tests;

import org.testng.annotations.Test;

import automation.PageObject.PageObject_PartsMaster;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PartsMasterTest extends BaseTest
{
	private PageObject_PartsMaster pm;

	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		super.setup();
		pm = new PageObject_PartsMaster(driver);
	}
	
	@Test(priority = 0)
	public void verifylogin() throws Exception
	{
		login();
	}

	@Test(priority = 1, dependsOnMethods = {"verifylogin"})
	public void partsmaster() throws Exception
	{
	//	pm.sorting();
		pm.multiplefilter();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		super.afterMethod(result);
	}
	
	@AfterTest
	public void afterTest()
	{
		super.afterTest();
	}
}