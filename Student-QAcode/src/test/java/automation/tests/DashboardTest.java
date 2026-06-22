package automation.tests;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automation.BaseMethods.Controls;
import automation.ExtentReport.ReportsOriginal;
import automation.PageObject.PageObject_Dashboard;
import automation.PageObject.PageObject_Login;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

public class DashboardTest extends BaseTest
{
//	PageObject_Dashboard pd = new PageObject_Dashboard(driver);
	
	@BeforeClass
	public void init()
	{
		pd = new PageObject_Dashboard(driver);
	}
	
	@BeforeMethod
	public void ensureLogin() throws IOException, InterruptedException
	{
		login();
	}
	
	@Test(priority=1,groups= {"smoke"})
	public void verifydashboardUI() throws Exception
	{
		pd.basicverifications();
	}
	
	@Test(priority=2,groups = {"smoke"})
	public void verifystudentaddition()
	{
		pd.studentaddtest();
	}
	
	@Test(priority=3,groups = {"smoke"})
	public void verifystudentconfirmation()
	{
		pd.studentconfirmtest();
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