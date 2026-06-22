package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = "input[@name='email']")
	WebElement login_user;
	
	@FindBy(xpath = "input[@name='password']")
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
/*	
	login_user_path = email
	login_pwd_path = password
	user=support@acumen.aero
	pwd=Acumen@123
	login_btn = //button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-containedPrimary') and contains(@class, 'MuiButton-fullWidth')]
	login_success = //div[contains(@class,'MuiBox-root')]/h3
	
			login_user_path = email
			login_pwd_path = password
			user=support@acumen.aero
			pwd=Acumen@123
			login_btn = //button[contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-containedPrimary') and contains(@class, 'MuiButton-fullWidth')]
			login_success = //div[contains(@class,'MuiBox-root')]/h3

	
}