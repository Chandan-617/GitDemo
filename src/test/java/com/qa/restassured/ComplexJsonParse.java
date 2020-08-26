package com.qa.restassured;

import com.qa.files.Payload;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath jp = new JsonPath(Payload.coursePrice());

		// 1. Print No of courses returned by API

		int count = jp.getInt("courses.size()");

		System.out.println("The total number of courses count is : " + count);

		// 2.Print Purchase Amount

		int courseamount = jp.getInt("dashboard.purchaseAmount");

		System.out.println("The total course purcgase amount is :" + courseamount);

		String title = jp.get("courses[0].title");

		System.out.println("The title of first course is : " + title);

		for (int i = 0; i < count; i++) {

			String coursetitle = jp.get("courses[" + i + "].title");

			System.out.println("The title of all courses is : " + coursetitle);

			int courseprice = jp.getInt("courses[" + i + "].price");

			System.out.println("The total courses prices is : " + courseprice);

		}

		System.out.println("The number of copies sold by RPA ");

		for (int i = 0; i < count; i++) {

			String coursetitle = jp.get("courses[" + i + "].title");
			if (coursetitle.equalsIgnoreCase("RPA")) {
				int totalcopies = jp.getInt("courses[" + i + "].copies");

				System.out.println("The total copies is : " + totalcopies);
				break;
			}
		}

	}

}
