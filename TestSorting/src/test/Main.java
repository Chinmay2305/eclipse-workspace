package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import components.Sort;

public class Main
{
	public static void main(String[] args) throws InterruptedException, IndexOutOfBoundsException
	{
		String propertiesPath = Paths.get("resources", "locators.properties").toString();
		PropertiesLoader pl = new PropertiesLoader(propertiesPath);
		Properties properties = pl.getProperties();
		
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String pwd = properties.getProperty("pwd");
		String tablelocator =  properties.getProperty("tablename");
		int columnindex = Integer.parseInt(properties.getProperty("columnindex"));
		
		
		WebDriver driver = new ChromeDriver();
		Controls c = new Controls(driver, properties);
		c.setup(url);
		Thread.sleep(2000);
		
		Login l = new Login(c,properties);
		l.login(user, pwd);
		Sort s = new Sort(driver, c);
		s.sort(tablelocator, columnindex);
	}
}