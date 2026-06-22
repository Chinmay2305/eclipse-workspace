package com.maven.project.selenium_maven_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User
{
	public static WebElement element = null;
	
	public static WebElement adduserbutton(WebDriver driver)
	{
		element = driver.findElement(By.xpath("(//div[contains(@class,'MuiBox-root')])[9]/button[1]"));
		return element;
	}
	
	public static WebElement name(WebDriver driver)
	{
		element = driver.findElement(By.name("name"));
		return element;
	}
	public static WebElement email(WebDriver driver)
	{
		element = driver.findElement(By.name("email"));
		return element;
	}
	public static WebElement mobile(WebDriver driver)
	{
		element = driver.findElement(By.name("mobile_number"));
		return element;
	}
	public static WebElement designation(WebDriver driver)
	{
		element = driver.findElement(By.name("designation"));
		return element;
	}
	public static WebElement department(WebDriver driver)
	{
		element = driver.findElement(By.name("department"));
		return element;
	}
	public static WebElement access(WebDriver driver)
	{
		element = driver.findElement(By.name("roles"));
		return element;
	}
	public static WebElement savebtn(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[contains(@class,'MuiDialogActions-root')]/button[2]"));
		return element;
	}
	public static void click(WebDriver driver)
	{
		element = savebtn(driver);
		element.click();
	}
}