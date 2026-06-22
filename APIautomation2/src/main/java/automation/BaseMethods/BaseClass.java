package automation.BaseMethods;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BaseClass {
  @BeforeClass
  public void setup()
  {
	  RestAssured.baseURI="https://automationexercise.com";
  }
}