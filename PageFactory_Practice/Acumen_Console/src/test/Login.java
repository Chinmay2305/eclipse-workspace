package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login
{
	private WebDriver driver;
	private Properties properties;
	
	public Login()
	{
		properties = new Properties();
		try
		{
			FileInputStream input = new FileInputStream("resources/properties.properties");
			properties.load(input);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void login()
	{
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement userfield = driver.findElement(By.name(properties.getProperty("usernamefield").split("=")[1]));
		WebElement passfield = driver.findElement(By.name(properties.getProperty("passwordfield").split("=")[1]));
		WebElement loginbutton = driver.findElement(By.xpath(properties.getProperty("loginbuttonlocator").split("=")[1]));
		userfield.sendKeys(properties.getProperty("username"));
		passfield.sendKeys(properties.getProperty("password"));
		loginbutton.click();
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	public void teardown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
}