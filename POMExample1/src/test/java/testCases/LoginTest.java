package testCases;

import java.lang.System.Logger;

import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass
{
	@Test
	public void verifylogin()
	{
		try
		{
			LoginPage lp = new LoginPage(driver);
			lp.enterusername(p.getProperty("email"));
			lp.enterpassword(p.getProperty("password"));
			lp.loginbtnclick();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}