package components;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import javax.annotation.processing.SupportedSourceVersion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_Component
{
	private WebDriver driver;
	private Properties properties;
	
	public Add_Component(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void addcomponent() throws InterruptedException
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
		driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/div/div[2]/ul/li[1]/div/button")).click();
		driver.switchTo().activeElement();
		Actions a = new Actions(driver);
		for(int i=0;i<5;i++)
		{
			a.sendKeys(Keys.DOWN).perform();
		}
		driver.switchTo().activeElement().click();
		WebElement manufacturerfield = driver.findElement(By.id(properties.getProperty("manufacturerbox").split("=")[1]));
		manufacturerfield.sendKeys(properties.getProperty("manufacturer"));
		WebElement componentserailnofield = driver.findElement(By.id(properties.getProperty("componentserialnobox").split("=")[1]));
		componentserailnofield.sendKeys(properties.getProperty("componentserialno"));
		WebElement componentboxfield = driver.findElement(By.id(properties.getProperty("componentnamebox").split("=")[1]));
		componentboxfield.sendKeys(properties.getProperty("componentname"));
		WebElement dateofmanufacturefield = driver.findElement(By.id(properties.getProperty("dateofmanufacturebox").split("=")[1]));
		dateofmanufacturefield.sendKeys(properties.getProperty("dateofmanufacture"));
		WebElement partnumberfield = driver.findElement(By.id(properties.getProperty("partnumberbox").split("=")[1]));
		partnumberfield.sendKeys(properties.getProperty("partnumber"));
		WebElement regionofoperationfield = driver.findElement(By.id(properties.getProperty("regionofoperationbox").split("=")[1]));
		regionofoperationfield.sendKeys(properties.getProperty("regionofoperation"), Keys.DOWN, Keys.ENTER);
		Thread.sleep(3000);
		WebElement locationfield = driver.findElement(By.id(properties.getProperty("locationbox").split("=")[1]));
		locationfield.sendKeys(properties.getProperty("location"));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("suggestion-item")));
		List<WebElement> suggestions = driver.findElements(By.className("suggestion-item"));
		for(WebElement suggestion:suggestions)
		{
			if(suggestion.getText().contains(properties.getProperty("location")))
			{
				suggestion.click();
				break;
			}
		}
		Thread.sleep(1000);
		
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(properties.getProperty("ownership"), Keys.DOWN, Keys.ENTER);		
		
		Thread.sleep(1000);
		WebElement leasestatusfield = driver.findElement(By.id(properties.getProperty("leasestatusbox").split("=")[1]));
		leasestatusfield.sendKeys(properties.getProperty("leasestatus"), Keys.DOWN, Keys.ENTER);
		
		Thread.sleep(1000);
		WebElement substatusfield = driver.findElement(By.id(properties.getProperty("substatusbox").split("=")[1]));
		substatusfield.sendKeys(properties.getProperty("substatus"), Keys.DOWN, Keys.ENTER);
		WebElement tsnfield = driver.findElement(By.id(properties.getProperty("tsnbox").split("=")[1]));
		tsnfield.sendKeys(properties.getProperty("tsn"));
		WebElement csnfield = driver.findElement(By.id(properties.getProperty("csnbox").split("=")[1]));
		csnfield.sendKeys(properties.getProperty("csn"));
		WebElement avgmonthlyhrsfield = driver.findElement(By.id(properties.getProperty("avgmonthlyhrsbox").split("=")[1]));
		avgmonthlyhrsfield.sendKeys(properties.getProperty("avgmonthlyhours"));
		WebElement avgmonthlycyclesfield = driver.findElement(By.id(properties.getProperty("avgmonthlycyclesbox").split("=")[1]));
		avgmonthlycyclesfield.sendKeys(properties.getProperty("avgmonthlycycle"));
		
		driver.switchTo().activeElement();
		a.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		driver.switchTo().activeElement().click();
	}
	
	public void viewtoConfirm() throws InterruptedException
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
		
		if(properties.getProperty("manufacturer").equals(driver.findElement(By.name(properties.getProperty("manufacturerview"))).getAttribute("value")))
		{
			System.out.println("Manufacturer - Fine");
		}
		else
		{
			System.out.println("Manufacturer - Not fine");
		}
		if(properties.getProperty("componentserialno").equals(driver.findElement(By.id(properties.getProperty("componentserialnoview"))).getAttribute("value")))
		{
			System.out.println("Component Sr.No. - Fine");
		}
		else
		{
			System.out.println("Component Sr.No. - Not fine");
		}
		if(properties.getProperty("componentname").equals(driver.findElement(By.name(properties.getProperty("componentnameview"))).getAttribute("value")))
		{
			System.out.println("Component Name - Fine");
		}
		else
		{
			System.out.println("Component Name - Not fine");
		}
		if(properties.getProperty("dateofmanufacture").equals(driver.findElement(By.name(properties.getProperty("dateofmanufactureview"))).getAttribute("value")))
		{
			System.out.println("Date of Manufacture - Fine");
		}
		else
		{
			System.out.println("Date of Manufacture - Not fine");
		}
		if(properties.getProperty("partnumber").equals(driver.findElement(By.id(properties.getProperty("partnumberview"))).getAttribute("value")))
		{
			System.out.println("Part Number - Fine");
		}
		else
		{
			System.out.println("Part Number - Not fine");
		}
		if(properties.getProperty("regionofoperation").equals(driver.findElement(By.xpath(properties.getProperty("regionofoperationview"))).getAttribute("value")))
		{
			System.out.println("Region of Operation - Fine");
		}
		else
		{
			System.out.println("Region of Operation - Not fine");
		}
		if(driver.findElement(By.name(properties.getProperty("locationview"))).getAttribute("value").contains(properties.getProperty("location")))
		{
			System.out.println("Location - Fine");
		}
		else
		{
			System.out.println("Location - Not fine");
		}
		if(properties.getProperty("ownership").equals(driver.findElement(By.xpath(properties.getProperty("ownershipview"))).getAttribute("value")))
		{
			System.out.println("Ownership - Fine");
		}
		else
		{
			System.out.println("Ownership - Not fine");
		}
		if(properties.getProperty("leasestatus").equals(driver.findElement(By.xpath(properties.getProperty("leasestatusview"))).getAttribute("value")))
		{
			System.out.println("Lease Status - Fine");
		}
		else
		{
			System.out.println("Lease Status - Not fine");
		}
		if(properties.getProperty("substatus").equals(driver.findElement(By.xpath(properties.getProperty("substatusview"))).getAttribute("value")))
		{
			System.out.println("Sub Status - Fine");
		}
		else
		{
			System.out.println("Sub Status - Not fine");
		}
	}
}