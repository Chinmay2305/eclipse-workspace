package com.maven.project.selenium_maven_example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login
{
	public static WebElement element = null;
	
	public static WebElement loginuserbox(WebDriver driver)
	{
		element = driver.findElement(By.name("email"));
		return element;
	}
	
	public static WebElement loginpasswordbox(WebDriver driver)
	{
		element = driver.findElement(By.name("password"));
		return element;
	}
	
	public static WebElement loginbtn(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-containedPrimary') and contains(@class, 'MuiButton-fullWidth')]"));
		return element;
	}
	
	public static void click(WebDriver driver)
	{
		element = loginbtn(driver);
		element.click();
	}
}