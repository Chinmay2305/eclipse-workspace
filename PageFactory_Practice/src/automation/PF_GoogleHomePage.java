package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PF_GoogleHomePage
{
	WebDriver driver;
	
	public PF_GoogleHomePage(WebDriver driver)
	{
		this.driver=driver;
		
		//Call initElements() method by using PageFactory reference and pass driver and this as parameters
		PageFactory.initElements(driver, this);
	}
	
	//Locate elements with required locators
	@FindBy(how=How.NAME, using="q")
	WebElement searchbox;
	
	@FindBy(how=How.NAME, using="btnK")
	WebElement submit;
	
	public void search()
	{
		searchbox.sendKeys("AV Devs");
	}
	public void submit()
	{
		submit.click();
	}
}