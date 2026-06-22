package API.automation;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UserAPITest extends automation.BaseMethods.BaseClass
{
	String token;
	String userid;
	
	//LOGIN API
	@Test(priority = 1)
	public void login()
	{
		Map<String,String> payload = new HashMap<>();
		payload.put("email", "kminchelle");
		payload.put("password", "0lelplR");
		
		Response response = given().header("Content-Type","application/json")
				.body(payload)
				.when().post("https://dummyjson.com/auth/login");
//				.then().statusCode(200).extract().response();
		
//		token = response.jsonPath().getString("token");
//		System.out.println("Token is: "+token);
		System.out.println(response.asPrettyString());
	}
}