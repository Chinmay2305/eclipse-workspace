package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(login_user));
	}
	
	//Locators
	@FindBy(xpath = "//input[@name='email']")
	WebElement login_user;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement login_pwd;
	
	@FindBy(xpath = "//button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-containedPrimary') and contains(@class, 'MuiButton-fullWidth')]")
	WebElement login_btn;
	
	//Actions
	public void enterusername(String user) 
	{
		login_user.sendKeys(user);
	}
	
	public void enterpassword(String password)
	{
		login_pwd.sendKeys(password);
	}
	
	public void loginbtnclick()
	{
		login_btn.click();
	}	
}