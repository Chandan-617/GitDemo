package com.qa.files;

public class Payload {

	public static String addPlace() {

		return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
				+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Chandan house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"sukhrali near choti mata mandir\",\r\n" + "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n" + "  \"language\": \"French-IN\"\r\n" + "}";

	}

	public static String coursePrice() {

		return "{\r\n" + "\r\n" + "\"dashboard\": {\r\n" + "\r\n" + "\"purchaseAmount\": 1210,\r\n" + "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n" + "\r\n" + "},\r\n" + "\r\n" + "\"courses\": [\r\n"
				+ "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"Selenium Python\",\r\n" + "\r\n" + "\"price\": 50,\r\n"
				+ "\r\n" + "\"copies\": 6\r\n" + "\r\n" + "},\r\n" + "\r\n" + "{\r\n" + "\r\n"
				+ "\"title\": \"Cypress\",\r\n" + "\r\n" + "\"price\": 40,\r\n" + "\r\n" + "\"copies\": 4\r\n" + "\r\n"
				+ "},\r\n" + "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"RPA\",\r\n" + "\r\n" + "\"price\": 45,\r\n"
				+ "\r\n" + "\"copies\": 10\r\n" + "\r\n" + "},\r\n" + "{\r\n" + "\r\n" + "\"title\": \"DJANJO\",\r\n"
				+ "\r\n" + "\"price\": 15,\r\n" + "\r\n" + "\"copies\": 20\r\n" + "\r\n" + "}\r\n" + "\r\n" + "\r\n"
				+ "]\r\n" + "\r\n" + "}\r\n" + "";

	}

	public static String addBook( String isbn, String aisle) {

		String libpayload = "{\r\n" + "\r\n" + "\"name\": \"Learn Appium Automation With Java\",\r\n" + "\r\n"
				+ "\"isbn\": \""+isbn+"\",\r\n" + "\r\n" + "\"aisle\": \""+aisle+"\",\r\n" + "\"author\" :\"John Foe\"\r\n"
				+ "\r\n" + "}";

		return libpayload;

	}

}
