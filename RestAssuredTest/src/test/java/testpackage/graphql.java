package testpackage;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class graphql {
	@Test
	public void test1()
	{
		Response res=RestAssured.get("https://reqres.in/api/users?page=1");
		System.out.println(res.getBody().asPrettyString());
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.statusCode(), 200);
	}

}
