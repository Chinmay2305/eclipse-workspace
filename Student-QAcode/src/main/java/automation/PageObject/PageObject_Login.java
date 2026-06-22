package automation.PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.By;
import automation.BaseMethods.Controls;

public class PageObject_Login extends Controls
{
	private Properties pl;
	WebDriverWait w;
	
	public PageObject_Login(WebDriver driver)
	{
		this.driver = driver;
		this.w = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void basicverifications()
	{
		System.out.println("LOGIN TEST - UI VERIFICATION");
		
	    Controls.confirmdata(By.xpath(loginprop.getProperty("title")), "Login Page", "Title");
	    Controls.confirmplaceholders(By.xpath(loginprop.getProperty("username")), loginprop.getProperty("username_placeholder"), "Username Placeholder");
	    Controls.confirmplaceholders(By.xpath(loginprop.getProperty("password")), loginprop.getProperty("password_placeholder"), "Password Placeholder");
	    Controls.confirmdata(By.xpath(loginprop.getProperty("login_button")), "Login", "Login button");
	}
	
	public void logintest()
	{
		System.out.println("LOGIN TEST - FUNCTIONALITY");
		
		Controls.type(By.xpath(loginprop.getProperty("username")),loginprop.getProperty("username_text"));
		Controls.type(By.xpath(loginprop.getProperty("password")),loginprop.getProperty("password_text"));
		Controls.clickElement(By.xpath(loginprop.getProperty("login_button")));
	}
}