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
import org.openqa.selenium.JavascriptExecutor;

import automation.BaseMethods.Controls;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PageObject_LoginLinkVerification extends Controls
{
	private Properties p;
	private PageObject_ProductSearch ps;
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
	String searchitem = "Barbadoza";
	
	public PageObject_LoginLinkVerification(WebDriver driver, PageObject_ProductSearch ps)
	{
		this.p = p;
		this.ps = ps;
	}
	
	public void loginfromHome() throws IOException, InterruptedException
	{
		Controls.clickElement(By.xpath(locatorsprop.getProperty("loginbtn")));
		if(driver.findElement(By.xpath("(//h2)[1]")).getText().toString().equals("Log in"))
		{
			System.out.println("Correct link to login page");
		}
		else
		{
			System.out.println("Not linking to login page");
		}
	}
	public void loginfromSearch() throws IOException, InterruptedException
	{
		ps.productsearchbytyping();		
		Controls.clickElement(By.xpath(locatorsprop.getProperty("loginbtn")));
		if(driver.findElement(By.xpath("(//h2)[1]")).getText().toString().equals("Log in"))
		{
			System.out.println("Correct link to login page");
		}
		else
		{
			System.out.println("Not linking to login page");
		}
	}
	public void loginfromblogspage() throws IOException, InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("(//div[contains(@class,'blog-thumb')])[1]")));
		
		Controls.clickElement(By.xpath(locatorsprop.getProperty("home_blog_readmore")));
		if(driver.findElement(By.xpath("(//h2)[1]")).getText().toString().equals("Log in"))
		{
			System.out.println("Correct link to login page");
		}
		else
		{
			System.out.println("Not linking to login page");
		}
	}
}