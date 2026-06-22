package automation.PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.By;
import automation.BaseMethods.Controls;

public class PageObject_Dashboard extends Controls
{
	private Properties pl;
	WebDriverWait w;
	
	public PageObject_Dashboard(WebDriver driver)
	{
		this.driver = driver;
		this.w = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void basicverifications()
	{
		System.out.println("STUDENT DASHBOARD TEST - UI VERIFICATION");
		
	    Controls.confirmdata(By.xpath(dashboardprop.getProperty("title")), "Student Dashboard", "Main Title");
	    Controls.confirmdata(By.xpath(dashboardprop.getProperty("addstudenttitle")), "Add Student", "Add Title");
	    Controls.confirmdata(By.xpath(dashboardprop.getProperty("searchtitle")), "Search by Student name", "Search Title");
	    Controls.confirmdata(By.xpath(dashboardprop.getProperty("filtertitle")), "Filter by Result", "Filter Title");
	    Controls.confirmdata(By.xpath(dashboardprop.getProperty("tabletitle")), "Student Table", "Table Title");
	    
	    Controls.confirmplaceholders(By.xpath(dashboardprop.getProperty("name_textbox")), dashboardprop.getProperty("name_placeholder"), "Name Placeholder");
	    Controls.confirmplaceholders(By.xpath(dashboardprop.getProperty("percent_textbox")), dashboardprop.getProperty("percent_placeholder"), "Percent Placeholder");
	    Controls.confirmplaceholders(By.xpath(dashboardprop.getProperty("search_textbox")), dashboardprop.getProperty("search_placeholder"), "Search Placeholder");
	}
	
	public void studentaddtest()
	{
		System.out.println("ADDING STUDENT");
		
		Controls.type(By.xpath(dashboardprop.getProperty("name_textbox")),dashboardprop.getProperty("name"));
		Controls.type(By.xpath(dashboardprop.getProperty("percent_textbox")),dashboardprop.getProperty("percent"));
		Controls.clickElement(By.xpath(dashboardprop.getProperty("addbutton")));
	}
	
	public void studentconfirmtest()
	{
		System.out.println("LETS CONFIRM THE ADDED STUDENT IN THE TABLE");
	
		Controls.confirmdata(By.xpath(dashboardprop.getProperty("tablename")), dashboardprop.getProperty("name"), "Student name");
		Controls.confirmdata(By.xpath(dashboardprop.getProperty("tablepercent")), dashboardprop.getProperty("percent"), "Student percentage");
		
		System.out.println("LETS ALSO CONFIRM THE FINAL RESULT OF "+dashboardprop.getProperty("name"));
		int percent = Integer.parseInt(dashboardprop.getProperty("percent"));
		if(percent<80)
		{
			Controls.confirmdata(By.xpath(dashboardprop.getProperty("tableresult")), "FAIL", "Student result");
		}
		else
		{
			Controls.confirmdata(By.xpath(dashboardprop.getProperty("tableresult")), "PASS", "Student result");
		}
	}
	
/*	public void studentsearchtest()
	{
		
	}
	
	public void studentfiltertest()
	{
		
	}*/
}