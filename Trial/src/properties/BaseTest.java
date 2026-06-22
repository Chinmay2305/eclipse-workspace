package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest
{
	public static WebDriver driver;
	public static Properties properties = new Properties();
	
	public void setup()
	{
		properties = new Properties();
		
		try
		{
		
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//Resources//PropertyFiles//config.properties");
			System.out.println(fis);
			properties.get(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chinmay\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		String QA_url = null;
		driver.get(properties.getProperty(QA_url));
		System.out.println(QA_url);
		System.out.println("test");
//		driver.get(properties.getProperty("url"));
	}
	
	public void teardown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
}