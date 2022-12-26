package testpackage;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.baseURI;
import org.json.simple.JSONObject;

public class Demo2 {
//	baseURI = "https://reqres.in/api/users?page=2";

	@Test
	public void test2() {
		baseURI = "https://reqres.in/api/users?page=2";
		given().get(baseURI).then().assertThat()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responses.json")).statusCode(200);
//		statusCode(200).body("data[3].first_name", equalTo("Byron")).body("data.first_name",
//				hasItems("Byron", "Rachel"));

	}

//	@Test
	public void post() {
		JSONObject reqbody = new JSONObject();
		reqbody.put("name", "Piyush");
		reqbody.put("age", 20);
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(reqbody.toJSONString()).when().post(baseURI)
				.then().statusCode(201).log().all();
	}
}
