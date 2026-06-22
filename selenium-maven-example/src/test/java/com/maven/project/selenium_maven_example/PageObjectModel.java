package com.maven.project.selenium_maven_example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PageObjectModel
{
	private WebDriver driver;
	private String baseurl;
	private Properties properties;
	
	@BeforeTest
	public void beforeTest()
	{
		driver = new ChromeDriver();
		baseurl = "https://qa.aerfinity.acumenaviation.in";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void logintest()
	{
		driver.get(baseurl);
		Login.loginuserbox(driver).sendKeys("support@acumen.aero");
		Login.loginpasswordbox(driver).sendKeys("Acumen@123");
		Login.click(driver);
	}
	
	@Test(priority = 2)
	public void adduser() throws InterruptedException
	{
		properties = new Properties();
		try
		{
			FileInputStream input = new FileInputStream("./properties.properties");
			properties.load(input);
			Thread.sleep(3000);
			driver.get(properties.getProperty("user_url"));
			User.adduserbutton(driver).click();
			User.name(driver).sendKeys(properties.getProperty("user_name"));
			User.email(driver).sendKeys(properties.getProperty("user_email"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
/*	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}*/
}