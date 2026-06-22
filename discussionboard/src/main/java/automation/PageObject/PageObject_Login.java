package automation.PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import automation.BaseMethods.Controls;

public class PageObject_Login extends Controls
{
	private Properties pl;
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public PageObject_Login(WebDriver driver, Properties pl)
	{
		this.pl = pl;
	}
	
	public void login(String username, String password) throws IOException, InterruptedException
	{
		Controls.dropdown_byCompleteText(By.xpath(loginprop.getProperty("login_org_path")), loginprop.getProperty("org"));
		Controls.type(By.xpath(loginprop.getProperty("login_user_path")), loginprop.getProperty("user"));
	/*	WebElement user = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginprop.getProperty("login_user_path"))));
		user.sendKeys(loginprop.getProperty("user"));
		WebElement pass = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginprop.getProperty("login_pwd_path"))));
		pass.sendKeys(loginprop.getProperty("pwd"));
		Controls.clickElement(By.xpath(loginprop.getProperty("login_btn.xpath")));*/
	}
}