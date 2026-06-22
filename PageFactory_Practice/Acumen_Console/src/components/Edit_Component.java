package components;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ContiguousSet;

public class Edit_Component
{
	private WebDriver driver;
	private Properties properties;
	
	public Edit_Component(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void editcomponent() throws InterruptedException
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
		
		Thread.sleep(3000);
		WebElement manufacturerfield = driver.findElement(By.name(properties.getProperty("manufacturerbox").split("=")[1]));
		manufacturerfield.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
		manufacturerfield.sendKeys(properties.getProperty("manufactureredited"));

		WebElement componentboxfield = driver.findElement(By.name(properties.getProperty("componentnamebox").split("=")[1]));
		componentboxfield.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
		componentboxfield.sendKeys(properties.getProperty("componentnameedited"));
		
		WebElement componentserailnofield = driver.findElement(By.id(properties.getProperty("componentserialnobox").split("=")[1]));
		componentserailnofield.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
		componentserailnofield.sendKeys(properties.getProperty("componentserialnoedited"));
				
		WebElement dateofmanufacturefield = driver.findElement(By.name(properties.getProperty("dateofmanufacturebox").split("=")[1]));
		dateofmanufacturefield.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
		dateofmanufacturefield.sendKeys(properties.getProperty("dateofmanufactureedited"));
		
		WebElement partnumberfield = driver.findElement(By.id(properties.getProperty("partnumberbox").split("=")[1]));
		partnumberfield.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
		partnumberfield.sendKeys(properties.getProperty("partnumberedited"));
		
		WebElement regionofoperationfield = driver.findElement(By.xpath(properties.getProperty("regionofoperationview")));
		regionofoperationfield.click();
		regionofoperationfield.sendKeys(Keys.DELETE, properties.getProperty("regionofoperationedited"), Keys.DOWN, Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement locationfield = driver.findElement(By.id(properties.getProperty("locationbox").split("=")[1]));
		locationfield.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
		locationfield.sendKeys(properties.getProperty("locationedited"));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("suggestion-item")));
		List<WebElement> suggestions = driver.findElements(By.className("suggestion-item"));
		for(WebElement suggestion:suggestions)
		{
			if(suggestion.getText().contains(properties.getProperty("locationedited")))
			{
				suggestion.click();
				break;
			}
		}
		Thread.sleep(1000);
		
		WebElement lessorfield = driver.findElement(By.xpath(properties.getProperty("lessorview")));
		lessorfield.click();
		lessorfield.sendKeys(properties.getProperty("lessor"),Keys.DOWN,Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement ownerfield = driver.findElement(By.xpath(properties.getProperty("ownerspv")));
		ownerfield.click();
		ownerfield.sendKeys(properties.getProperty("owner"),Keys.DOWN,Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement ownershipfield = driver.findElement(By.xpath(properties.getProperty("ownershipview")));
		ownershipfield.click();
		ownershipfield.sendKeys(properties.getProperty("ownershipedited"),Keys.DOWN,Keys.ENTER);
		
		switch(properties.getProperty("ownershipedited").toString())
		{
		case "Third Party":
			WebElement leasefield = driver.findElement(By.xpath(properties.getProperty("leasestatusview")));
			leasefield.click();
			leasefield.sendKeys("Installed Only",Keys.DOWN,Keys.ENTER);
			
			WebElement substatusfield = driver.findElement(By.xpath(properties.getProperty("substatusview")));
			substatusfield.click();
			substatusfield.sendKeys("Installed On-Wing",Keys.DOWN,Keys.ENTER);
			
		case "Owned":
		case "Managed":
			WebElement leasefield2 = driver.findElement(By.xpath(properties.getProperty("leasestatusview")));
			leasefield2.click();
			leasefield2.sendKeys(properties.getProperty("leasestatusedited"),Keys.DOWN,Keys.ENTER);	
		}
		
		switch(properties.getProperty("leasestatusedited").toString())
		{
		case "Off Lease":
		case "Part out":
		case "Written Off":
			WebElement substatusfield = driver.findElement(By.xpath(properties.getProperty("substatusview")));
			substatusfield.click();
			substatusfield.sendKeys(properties.getProperty("substatusedited"),Keys.DOWN,Keys.ENTER);
			
		case "On Lease":
			WebElement substatusfield2 = driver.findElement(By.xpath(properties.getProperty("substatusview")));
			substatusfield2.click();
			substatusfield2.sendKeys(properties.getProperty("substatusedited"),Keys.DOWN,Keys.ENTER);
			WebElement lessee = driver.findElement(By.id(properties.getProperty("lesseeview")));
			lessee.click();
			lessee.sendKeys(properties.getProperty("lessee"), Keys.DOWN, Keys.ENTER);
			WebElement operatorsamelesse = driver.findElement(By.xpath("operatorsameaslesseview"));
			operatorsamelesse.click();
			operatorsamelesse.sendKeys(properties.getProperty("operatorsameaslesse"),Keys.DOWN, Keys.ENTER);
		}
		
		switch(properties.getProperty("operatorsameaslesse").toString())
		{
		case "Yes":
			break;
		case "No":
			WebElement operator = driver.findElement(By.name(properties.getProperty("operator")));
			operator.click();
			operator.sendKeys(properties.getProperty("operator"),Keys.DOWN,Keys.ENTER);
		}
		
		
		
		WebElement dateofpurchasefield = driver.findElement(By.name(properties.getProperty("dateofpurchaseview")));
		dateofpurchasefield.sendKeys(properties.getProperty("purchasedateedited"));
		
		
/*		WebElement substatusfield = driver.findElement(By.xpath(properties.getProperty("substatusview")));
		substatusfield.click();
		substatusfield.sendKeys(properties.getProperty("substatusedited"),Keys.DOWN,Keys.ENTER);
		
		WebElement technicaldisclaimerfield = driver.findElement(By.name(properties.getProperty("technicaldisclaimer")));
		technicaldisclaimerfield.sendKeys(Keys.CONTROL+"A", Keys.DELETE);
		technicaldisclaimerfield.sendKeys(properties.getProperty("technicaldisclaimeredited"));
		
		WebElement editsave = driver.findElement(By.xpath(properties.getProperty("editsavebtn")));
		editsave.click();*/
	}
	
	public void viewtoconfirm() throws InterruptedException
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
		
		if(properties.getProperty("manufactureredited").equals(driver.findElement(By.name(properties.getProperty("manufacturerview"))).getAttribute("value")))
		{
			System.out.println("Manufacturer - Fine");
		}
		else
		{
			System.out.println("Manufacturer - Not fine");
		}
		if(properties.getProperty("componentserialnoedited").equals(driver.findElement(By.id(properties.getProperty("componentserialnoview"))).getAttribute("value")))
		{
			System.out.println("Component Sr.No. - Fine");
		}
		else
		{
			System.out.println("Component Sr.No. - Not fine");
		}
		if(properties.getProperty("componentnameedited").equals(driver.findElement(By.name(properties.getProperty("componentnameview"))).getAttribute("value")))
		{
			System.out.println("Component Name - Fine");
		}
		else
		{
			System.out.println("Component Name - Not fine");
		}
		if(properties.getProperty("dateofmanufactureedited").equals(driver.findElement(By.name(properties.getProperty("dateofmanufactureview"))).getAttribute("value")))
		{
			System.out.println("Date of Manufacture - Fine");
		}
		else
		{
			System.out.println("Date of Manufacture - Not fine");
		}
		if(properties.getProperty("partnumberedited").equals(driver.findElement(By.id(properties.getProperty("partnumberview"))).getAttribute("value")))
		{
			System.out.println("Part Number - Fine");
		}
		else
		{
			System.out.println("Part Number - Not fine");
		}
		if(properties.getProperty("regionofoperationedited").equals(driver.findElement(By.xpath(properties.getProperty("regionofoperationview"))).getAttribute("value")))
		{
			System.out.println("Region of Operation - Fine");
		}
		else
		{
			System.out.println("Region of Operation - Not fine");
		}
		if(driver.findElement(By.name(properties.getProperty("locationview"))).getAttribute("value").contains(properties.getProperty("locationedited")))
		{
			System.out.println("Location - Fine");
		}
		else
		{
			System.out.println("Location - Not fine");
		}
		if(properties.getProperty("lessor").equals(driver.findElement(By.xpath(properties.getProperty("lessorview"))).getAttribute("value")))
		{
			System.out.println("Lessor - Fine");
		}
		else
		{
			System.out.println("Lessor - Not fine");
		}
		if(properties.getProperty("owner").equals(driver.findElement(By.xpath(properties.getProperty("ownerspv"))).getAttribute("value")))
		{
			System.out.println("Owner/SPV - Fine");
		}
		else
		{
			System.out.println("Owner/SPV - Not fine");
		}
		if(properties.getProperty("ownershipedited").equals(driver.findElement(By.xpath(properties.getProperty("ownershipview"))).getAttribute("value")))
		{
			System.out.println("Ownership - Fine");
		}
		else
		{
			System.out.println("Ownership - Not fine");
		}
		if(properties.getProperty("leasestatusedited").equals(driver.findElement(By.xpath(properties.getProperty("leasestatusview"))).getAttribute("value")))
		{
			System.out.println("Lease Status - Fine");
		}
		else
		{
			System.out.println("Lease Status - Not fine");
		}
		if(properties.getProperty("substatusedited").equals(driver.findElement(By.xpath(properties.getProperty("substatusview"))).getAttribute("value")))
		{
			System.out.println("Sub Status - Fine");
		}
		else
		{
			System.out.println("Sub Status - Not fine");
		}
		if(properties.getProperty("purchasedateedited").equals(driver.findElement(By.name(properties.getProperty("dateofpurchaseview"))).getAttribute("value")))
		{
			System.out.println("Purchase Date - Fine");
		}
		else
		{
			System.out.println("Purchase Date - Not fine");
		}
		if(properties.getProperty("technicaldisclaimeredited").equals(driver.findElement(By.name(properties.getProperty("technicaldisclaimer"))).getAttribute("value")))
		{
			System.out.println("Technical Disclaimer - Fine");
		}
		else
		{
			System.out.println("Technical Disclaimer - Not fine");
		}
	}
}