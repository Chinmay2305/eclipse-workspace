package testBase;

import java.io.FileReader;
import java.lang.System.Logger;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;

public class BaseClass
{
	public static WebDriver driver;
	public Logger l;
	public Properties p;
	
	public void setup()
	{
		l = (Logger) LogManager.getLogger(this.getClass());
		
		FileReader f = new FileReader(".//src//test//resources")
		
	}
	
}