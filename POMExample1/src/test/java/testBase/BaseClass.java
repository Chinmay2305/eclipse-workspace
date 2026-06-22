package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass
{
	public static WebDriver driver;
	public Logger log;
	public Properties p;
	
	@BeforeClass
	public void setup() throws IOException
	{
		log =  LogManager.getLogger(this.getClass());
		
		FileReader f = new FileReader(".//resources//config.properties");
		p=new Properties();
		p.load(f);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("Url"));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
}