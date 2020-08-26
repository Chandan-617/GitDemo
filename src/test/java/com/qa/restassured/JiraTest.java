package com.qa.restassured;

import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class JiraTest {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://localhost:9090";

		SessionFilter session = new SessionFilter();

		String response = given().header("Content-Type", "application/json")
				.body("{ \"username\": \"Chandan617\", \"password\": \"Resonance@619\" }")

				.log().all().filter(session).when().post("/rest/auth/1/session").then().log().all().extract().response()
				.asString();

		given().pathParam("id", "10200").log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "    \"body\": \"This is my first comment.\",\r\n" + "    \"visibility\": {\r\n"
						+ "        \"type\": \"role\",\r\n" + "        \"value\": \"Administrators\"\r\n" + "    }\r\n"
						+ "}")
				.filter(session).when().post("/rest/api/2/issue/{id}/comment").then().log().all().assertThat()
				.statusCode(201);

		// add attachment

		String addCooment=given().header("X-Atlassian-Token", "no-check").filter(session).pathParam("id", "10200")
				.queryParam("fields", "comment").header("Content-Type", "multipart/form-data").multiPart("file", new File("jira.txt")).when()
				.post("rest/api/2/issue/{id}/attachments")

				.then().log().all()
		
		.assertThat().statusCode(403).extract().response().asString();
		
		JsonPath js1=new JsonPath(addCooment);
		String commentid=js1.getString("id");
		
		
		 
		
		
		
		// Get issue
		
		String issuedetails=given().filter(session).pathParam("id", "10200").when().get("/rest/api/2/issue/{id}").then()
		
		.log().all().extract().response().asString();
		
		System.out.println(issuedetails);
		
		JsonPath js=new JsonPath(issuedetails);
		
		int commentscount=js.get("fields.comment.comments.size()");
		
		for(int i=0;i<commentscount;i++)
		{
			
			int totalid=js.getInt("fields.comment.comments["+i+"].id");
			
			System.out.println("The total id is :" +totalid );
		}
		
		
		

	}

}
