package automation.PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import automation.BaseMethods.Controls;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PageObject_ProductSearch extends Controls
{
	private Properties ps;
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
	String searchitem = "Barbadoza";
	
	public PageObject_ProductSearch(WebDriver driver)
	{
		this.ps = ps;
	}
	
	public void productsearchbytyping() throws IOException, InterruptedException
	{
		WebElement searchbar = driver.findElement(By.xpath(locatorsprop.getProperty("searchbox")));
		searchbar.sendKeys(searchitem);
		Controls.clickElement(By.xpath(locatorsprop.getProperty("searchbutton")));
		
		// Locate elements matching the XPath
        List<WebElement> productTitles = driver.findElements(By.xpath("//h4[contains(@class,'product-title')]"));

        // Compare each element's text with the input string
        boolean allMatch = true;
        for (WebElement title : productTitles)
        {
        	String text = title.getText();
            if (!text.toLowerCase().contains(searchitem.toLowerCase()))
            {
            	System.out.println("Mismatch found: " + text);
                allMatch = false;
            }
            else
            {
                System.out.println("Match found: " + text);
            }
        }
	}
	public void productsearchfrommenu() throws IOException, InterruptedException
	{
		int i = 0;
		String normalizedsearchitem = searchitem.toLowerCase();
		switch(normalizedsearchitem)
		{
		case "all products":
			i=1;
			break;
		case "barbadoza":
			i=2;
			break;
		case "barska":
			i=3;
			break;
		case "blindos":
			i=4;
			break;
		case "cepkeliu":
			i=5;
			break;
		case "helles burg":
			i=6;
			break;
		case "kiss":
			i=7;
			break;
		case "pasvalio alus":
			i=8;
			break;
		default:
			System.out.println("Search item not found: " + searchitem);
            return;	
		}
		
		Controls.clickElement(By.xpath(locatorsprop.getProperty("menuslider")+i+"]/a"));
		
		// Locate elements matching the XPath
        List<WebElement> productTitles = driver.findElements(By.xpath("//h4[contains(@class,'product-title')]"));

        // Compare each element's text with the input string
        boolean allMatch = true;
        for (WebElement title : productTitles)
        {
        	String text = title.getText();
            if (!text.toLowerCase().contains(searchitem.toLowerCase()))
            {
            	System.out.println("Mismatch found: " + text);
                allMatch = false;
            }
            else
            {
                System.out.println("Match found: " + text);
            }
        }
	}
	
	public void breadcrumbverificationaftersearch()
	{
		String breadcrumb = driver.findElement(By.xpath(locatorsprop.getProperty("breadcrumb"))).getText().toString();
		
		if(breadcrumb.contains(searchitem))
		{
			System.out.println("Breadcrumb is coming correctly as per the searched text");
		}
		else
		{
			System.out.println("Breadcrumb is coming wrong or not as per the searched text");
		}
	}
}