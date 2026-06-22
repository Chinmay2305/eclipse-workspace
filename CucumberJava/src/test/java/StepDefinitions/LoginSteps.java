package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps
{
	@Given("user is on login page")
	public void user_is_on_login_page()
	{
		System.out.println("Inside step - user is on login page");
	}

	@When("user enters {string} and {string}")
	public void user_enters_username_and_password(String username, String password)
	{
		System.out.println("Inside step - user enters username: "+username+" and password: "+password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button()
	{
		System.out.println("Inside step - user clicks on login button");
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page()
	{
		System.out.println("Inside step - user is navigated to home page");
	}

	@When("user enters user1 and pass1")
	public void user_enters_user1_and_pass1()
	{
		System.out.println("Inside step - user is on login page");
	}

	@When("user enters user2 and pass2")
	public void user_enters_user2_and_pass2()
	{
		System.out.println("Inside step - user is on login page");
	}

	@When("user enters support@acumen.aero and Acumen@{int}")
	public void user_enters_support_acumen_aero_and_acumen(Integer int1)
	{
		System.out.println("Inside step - user is on login page");
	}
}