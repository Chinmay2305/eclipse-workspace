package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs_POM
{
	private WebDriver driver;
	
	private By firstnamefield = By.id("first_name");
	private By lastnamefield = By.id("last_name");
	private By emailfield = By.id("email_id");
	private By contactfield = By.id("contact_number");
	private By messagefield = By.id("message");
	private By submitbutton = By.xpath("/html/body/div[1]/section[1]/div[2]/div/div/div[2]/form/div[5]/button");
	
	public ContactUs_POM(WebDriver driver)
	{
		this.driver=driver;
	}
	public void enterFName(String fn)
	{
		driver.findElement(firstnamefield).sendKeys(fn);
	}
	public void enterLName(String ln)
	{
		driver.findElement(lastnamefield).sendKeys(ln);
	}
	
	public void enterEmail(String email)
	{
		driver.findElement(emailfield).sendKeys(email);
	}
	public void enterContact(String mobile)
	{
		driver.findElement(contactfield).sendKeys(mobile);
	}
	public void enterMessage(String message)
	{
		driver.findElement(messagefield).sendKeys(message);
	}
	public void clickSubmit()
	{
		driver.findElement(submitbutton).click();
	}
}