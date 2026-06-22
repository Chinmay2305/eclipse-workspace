package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Controls
{
	private WebDriver driver;
	private Properties properties;
	
	public Controls(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public Controls(WebDriver driver, Properties properties)
	{
		this.driver=driver;
		this.properties=properties;
	}
	
	public void enterText(By locator, String text)
	{
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
	
	public void clickElement(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public void setup(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public WebElement waitForElement(By locator, int timeout)
	{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
	//SORTING PART
	public List<String> getColumnData(String tableLocator, int columnindex)
	{
		List<WebElement> cells = driver.findElements(By.xpath(tableLocator+"//tbody/tr/td["+columnindex+"]"));
		List<String> data = new ArrayList<>();
		for(WebElement cell:cells)
		{
			data.add(cell.getText().trim());
		}
		return data;
	}
	
	public void sortColumn(String tablelocator, int columnindex)
	{
		WebElement header = driver.findElement(By.xpath(tablelocator+"//thead/tr/th["+columnindex+"]"));
		header.click();
	}
	
	public boolean isSorted(List<String> data, boolean ascending)
	{
		List<String> sortedData = new ArrayList<>(data);
		if(ascending)
		{
			Collections.sort(sortedData);
		}
		else
		{
			Collections.sort(sortedData, Collections.reverseOrder());
		}
		return sortedData.equals(data);
	}
}