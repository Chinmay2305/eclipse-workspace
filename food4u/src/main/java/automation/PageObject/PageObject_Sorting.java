package automation.PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import automation.BaseMethods.Controls;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PageObject_Sorting extends Controls
{
	private Properties ps;
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public PageObject_Sorting(WebDriver driver)
	{
		this.ps = ps;
	}
	
	public void sorting() throws IOException, InterruptedException
	{
		String sortmethod = "Name (A - Z)";
		driver.get("https://food4u.uk/index.php?route=product/all_product");
		Select select = new Select(driver.findElement(By.xpath(locatorsprop.getProperty("sort_bar"))));
		
		switch(sortmethod.toLowerCase())
		{
		case "name (a - z)":
			select.selectByVisibleText("Name (A - Z)");
			break;
		case "name (z - a)":
			select.selectByVisibleText("Name (Z - A)");
			break;
		default:
				System.out.println("Invalid sorting option: "+sortmethod);
				return;
		}
		
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		//Get list of product titles
		List<WebElement> productTitleElements = driver.findElements(By.xpath("(//h4[contains(@class,'product-title')])"));
        List<String> actualTitles = new ArrayList<>();
        for (WebElement element : productTitleElements)
        {
            actualTitles.add(element.getText().trim());
        }

        // Validate the order
        List<String> sortedTitles = new ArrayList<>(actualTitles);
        if (sortmethod.equalsIgnoreCase("Name (A - Z)"))
        {
            Collections.sort(sortedTitles, String.CASE_INSENSITIVE_ORDER);
        }
        else if (sortmethod.equalsIgnoreCase("Name (Z - A)"))
        {
            Collections.sort(sortedTitles, String.CASE_INSENSITIVE_ORDER);
            Collections.reverse(sortedTitles);
        }

        // Check if the list matches the expected order
       	for(String title:actualTitles)
    	{
    		System.out.println(title);
    	}
        if (actualTitles.equals(sortedTitles))
        {
            System.out.println("Products are sorted correctly in " + sortmethod + " order.");
        }
        else
        {
            System.out.println("Products are NOT sorted correctly in " + sortmethod + " order.");
            System.out.println("Actual Order: " + actualTitles);
            System.out.println("Expected Order: " + sortedTitles);
        }
    }
}