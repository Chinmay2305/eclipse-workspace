package automation.tests;

import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automation.BaseMethods.Controls;
import automation.ExtentReport.ReportsOriginal;
import automation.PageObject.PageObject_Test;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

public class LoginTest extends BaseTest
{
	PageObject_Test pt = new PageObject_Test(driver, null);
	
	@Test
	public void verifylogin() throws Exception
	{
		login();
		pt.tabletest();
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