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
import automation.PageObject.PageObject_Login;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

public class LoginTest extends BaseTest
{
	@Test(priority=1,groups= {"smoke"})
	public void verifyloginUI() throws Exception
	{
		pl.basicverifications();
	}
	
	@Test(priority=2,groups = {"regression"})
	public void verifyloginFunctionality()
	{
		pl.logintest();
	}
	
/*	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		super.afterMethod(result);
	}*/
	
	@AfterTest
	public void afterTest()
	{
		super.afterTest();
	}
}