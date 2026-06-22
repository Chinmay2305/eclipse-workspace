package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage
{
	private WebDriver driver;
	
	public GoogleHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locate search box
	@FindBy(how=How.NAME,using="q")
	WebElement searchbox;
	
	//Locate submit button
	@FindBy(how=How.NAME,using="btnK")
	WebElement submit;
	
	public void search()
	{
		searchbox.sendKeys("Testing again");
	}
	
	public void submit()
	{
		submit.click();
	}

}