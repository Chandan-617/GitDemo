package com.qa.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.files.Payload;

import io.restassured.path.json.JsonPath;

public class SumValidation {

	
	@Test
	public void sumPurchaseamount() {	
		
		int sum=0;
		JsonPath jp = new JsonPath(Payload.coursePrice());
		int count = jp.getInt("courses.size()");
		
		
		for(int i=0;i<count;i++)
		{
			
		int cprice=jp.getInt("courses["+i+"].price")	;
		
		
		int ccopies=jp.getInt("courses["+i+"].copies")	;
		
		
		int amount=cprice*ccopies;
		
		System.out.println(amount);
		
		sum=sum+amount;
			
		}
		
		System.out.println("The total sum is : " + sum);
		
		int purchaseamount=jp.getInt("dashboard.purchaseAmount");
		
		System.out.println("The purchase amount is : " + purchaseamount);
		
		Assert.assertEquals(purchaseamount, sum);
		
		
		
		
	}
}
