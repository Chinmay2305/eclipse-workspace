package automation.PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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

public class PageObject_Terms extends Controls
{
	public PageObject_Terms(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void openTerms() throws IOException, InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement academic_menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuprop.getProperty("academicstructure"))));
		academic_menu.click();
		
		WebElement termslink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuprop.getProperty("academic_terms"))));
		termslink.click();
	}
}