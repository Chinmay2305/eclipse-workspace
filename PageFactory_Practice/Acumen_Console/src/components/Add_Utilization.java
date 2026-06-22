package components;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.annotation.processing.SupportedSourceVersion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Add_Utilization
{
	private WebDriver driver;
	private Properties properties;
	
	public Add_Utilization(WebDriver driver)
	{
		this.driver=driver;
	}	
	
	public void addutilization() throws InterruptedException
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
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[3]/div[1]/table/tbody/tr[1]/td[8]/div/ul/li/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/div/div/div/div[2]/div/p/span")).click();
		driver.findElement(By.xpath(properties.getProperty("util_link"))).click();
		driver.findElement(By.xpath(properties.getProperty("add_util_btn"))).click();
		Thread.sleep(2000);
		driver.findElement(By.name(properties.getProperty("start_date_locator"))).sendKeys(properties.getProperty("start_date"));
		driver.findElement(By.name(properties.getProperty("end_date_locator"))).sendKeys(properties.getProperty("end_date"));
		driver.findElement(By.name(properties.getProperty("tsn_locator"))).sendKeys(properties.getProperty("tsn"));
		driver.findElement(By.name(properties.getProperty("csn_locator"))).sendKeys(properties.getProperty("csn"));
		driver.findElement(By.name(properties.getProperty("util_type_locator"))).sendKeys(properties.getProperty("util_type"), Keys.DOWN, Keys.ENTER);
		driver.findElement(By.name(properties.getProperty("location_locator"))).sendKeys(properties.getProperty("location"));
		driver.findElement(By.name(properties.getProperty("service_locator"))).sendKeys(properties.getProperty("service"));
		driver.findElement(By.name(properties.getProperty("remarks_locator"))).sendKeys(properties.getProperty("remarks"));
		driver.findElement(By.xpath(properties.getProperty("save_btn"))).click();
	}
	
	public void viewtoConfirm() throws InterruptedException, ParseException
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
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[3]/div[1]/table/tbody/tr[1]/td[8]/div/ul/li/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/div/div/div/div[2]/div/p/span")).click();
		driver.findElement(By.xpath(properties.getProperty("util_link"))).click();
		
		SimpleDateFormat input = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat output = new SimpleDateFormat("MMM dd, yyyy");
		String formattedstart_date = output.format(input.parse(properties.getProperty("start_date")));
		String formattedend_date = output.format(input.parse(properties.getProperty("end_date")));
		
		DecimalFormat df = new DecimalFormat("#.00");
		String formattedtsn = df.format(Double.parseDouble(properties.getProperty("tsn")));
		String formattedcsn = df.format(Double.parseDouble(properties.getProperty("csn")));

		if((formattedstart_date+" to "+formattedend_date).equals(driver.findElement(By.xpath(properties.getProperty("datesview"))).getText().toString()))
		{
			System.out.println("Utilization dates - Fine");
		}
		else
		{
			System.out.println("Utilization dates - Not fine");
		}
		if(formattedtsn.equals(driver.findElement(By.xpath(properties.getProperty("tsnview"))).getText().toString()))
		{
			System.out.println("TSN - Fine");
		}
		else
		{
			System.out.println("TSN - Not Fine");
		}
		if(formattedcsn.equals(driver.findElement(By.xpath(properties.getProperty("csnview"))).getText().toString()))
		{
			System.out.println("CSN - Fine");
		}
		else
		{
			System.out.println("CSN - Not Fine");
		}
		if(properties.getProperty("util_type").equals(driver.findElement(By.xpath(properties.getProperty("utiltypeview"))).getText().toString()))
		{
			System.out.println("Util Type - Fine");
		}
		else
		{
			System.out.println("Util Type - Not Fine");
		}
		if(properties.getProperty("location").equals(driver.findElement(By.xpath(properties.getProperty("locationview"))).getText().toString()))
		{
			System.out.println("Location - Fine");
		}
		else
		{
			System.out.println("Location - Not Fine");
		}
		if(properties.getProperty("service").equals(driver.findElement(By.xpath(properties.getProperty("serviceview"))).getText().toString()))
		{
			System.out.println("Service - Fine");
		}
		else
		{
			System.out.println("Service - Not Fine");
		}
		if(properties.getProperty("remarks").equals(driver.findElement(By.xpath(properties.getProperty("remarksview"))).getText().toString()))
		{
			System.out.println("Remarks - Fine");
		}
		else
		{
			System.out.println("Remarks - Not Fine");
		}
	}
}