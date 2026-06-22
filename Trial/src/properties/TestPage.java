package properties;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPage
{
	private WebDriver driver;
	private Properties properties;
	
	public TestPage(WebDriver driver, Properties properties)
	{
		this.driver=driver;
		this.properties=properties;
	}
	public void login(String username, String password)
	{
		driver.findElement(By.name(properties.getProperty("usernamelocator").split("=")[1])).sendKeys(username);
		driver.findElement(By.name(properties.getProperty("passwordlocator").split("=")[1])).sendKeys(password);
		driver.findElement(By.xpath(properties.getProperty("loginbuttonlocator").split("=")[1])).click();
	}
}