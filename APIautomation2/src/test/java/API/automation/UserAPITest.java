package API.automation;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserAPITest extends automation.BaseMethods.BaseClass
{
	String token;
	String userid;
	
	//GET Products
	@Test(priority = 1)
	public void getproductlist()
	{
		Response response = given().header("Content-Type","application/json")
				.when().post("/api/productsList")
				.then().statusCode(200)
				.body("products", notNullValue())
				.extract().response();
		
		
		int id = response.jsonPath().getInt("products[0].id");
		String name = response.jsonPath().getString("products[0].name");
		
		System.out.println(response.asPrettyString());
		System.out.println("Product id: "+id);
		System.out.println("Product name: "+name);
	}
}