package com.qa.restassured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.files.Payload;
import com.qa.files.ReuseableMethods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";

		String response = given().log().all().header("Content-Type", "application/json")

				.body(Payload.addBook(isbn, aisle)).when().post("/Library/Addbook.php").then().log().all()

				.assertThat().statusCode(200).extract().response().asString();

		JsonPath js = ReuseableMethods.rawToJson(response);

		String id = js.getString("ID");

		System.out.println(id);

	}

	@DataProvider(name = "BooksData")
	public Object[][] getData() {

		Object[][] obj = new Object[][] { { "gyg77", "87g8" }, { "uh7g7", "uu89h" }, { "56ggf", "jiou8hh" } };

		return obj;
	}

}
