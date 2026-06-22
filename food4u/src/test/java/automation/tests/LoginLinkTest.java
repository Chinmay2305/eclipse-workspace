package automation.tests;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automation.BaseMethods.Controls;
import automation.ExtentReport.ReportsOriginal;
import automation.PageObject.PageObject_LoginLinkVerification;
import automation.PageObject.PageObject_ProductSearch;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

public class LoginLinkTest extends BaseTest
{
	private PageObject_LoginLinkVerification pl;

	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		super.setup();
		PageObject_ProductSearch ps = new PageObject_ProductSearch(driver);
		pl = new PageObject_LoginLinkVerification(driver, ps);
	}

	@Test(priority = 0)
	public void loginlinktest() throws Exception
	{
//		pl.loginfromHome(); //passed testcase
//		pl.loginfromSearch(); //failed testcase
		pl.loginfromblogspage(); //failed testcase
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