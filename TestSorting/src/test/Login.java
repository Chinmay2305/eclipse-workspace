package test;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login extends Properties
{
	Controls controls;
	Properties properties;
	
	public Login(Controls controls, Properties properties)
	{
		this.controls = controls;
		this.properties=properties;
	}
	
	public void login(String username, String password) throws InterruptedException
	{
		controls.enterText(By.name("email"), username);
		controls.enterText(By.name("password"), password);
		controls.clickElement(By.xpath(properties.getProperty("login_btn")));
	}
}