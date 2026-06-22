package automation.tests;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import automation.BaseMethods.Controls;
import automation.ExtentReport.ReportsOriginal;
import automation.PageObject.PageObject_Login;
import automation.PageObject.PageObject_Terms;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

public class TermsTest extends BaseTest
{
	private PageObject_Terms pt;
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		super.setup();
		pt = new PageObject_Terms(driver);
	}
	
	@Test(priority = 0)
	public void verifylogin() throws Exception
	{
		login();
	}
	
	@Test(priority = 1, dependsOnMethods = {"verifylogin"})
	public void terms() throws IOException, InterruptedException
	{
		pt.openTerms();
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