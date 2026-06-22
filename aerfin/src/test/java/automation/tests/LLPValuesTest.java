package automation.tests;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import automation.PageObject.PageObject_AirframeCashflow;
import automation.PageObject.PageObject_Asset;
import automation.PageObject.PageObject_LLPValues;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import automation.BaseMethods.Controls;
import automation.ExtentReport.ReportsOriginal;
import automation.PageObject.PageObject_Asset;
import automation.PageObject.PageObject_Login;
import automation.PageObject.PageObject_Projects;

public class LLPValuesTest extends BaseTest
{
	private PageObject_LLPValues pa;

	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		super.setup();
		pa = new PageObject_LLPValues(driver);
	}
	
	@Test(priority = 0)
	public void verifylogin() throws IOException, InterruptedException
	{
		login();
	}
	
	@Test(priority = 1)
	public void addllpvalues() throws InterruptedException, IOException
	{
		pa.addllpvalue();
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