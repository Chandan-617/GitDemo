package com.qa.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import com.qa.files.Payload;
import com.qa.files.ReuseableMethods;

public class Basics {

	public static void main(String[] args) {

		// validate if add place api is working as per expected

		// Given : input details
		// when : submit
		// then: validate

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.addPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();

		System.out.println("The response from the body is" + response);

		JsonPath js = new JsonPath(response);

		String placeid = js.getString("place_id");

		System.out.println("The place id is : " + placeid);

		// update place

		String newaddress = "Summer new walk africa";

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")

				.body("{\r\n" + "\"place_id\":\"" + placeid + "\",\r\n" + "\"address\":\"" + newaddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		// get place

		String getPlaceresonse = given().log().all().queryParam("key", "qaclick123")

				.queryParam("place_id", placeid).when().get("maps/api/place/get/json")

				.then().assertThat().statusCode(200).extract().response().asString();

		// JsonPath js1=new JsonPath(getPlaceresonse);
		JsonPath js1 = ReuseableMethods.rawToJson(getPlaceresonse);

		String actualaddress = js1.get("address");

		System.out.println("The actual address is : " + actualaddress);

		Assert.assertEquals(actualaddress, "Pacific ocean");

	}

}
