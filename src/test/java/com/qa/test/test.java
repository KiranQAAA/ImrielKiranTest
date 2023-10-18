package com.qa.test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Reuseable_compunents.propertiesOprations;

public class test extends BaseClass {


	
	@Test (enabled=true , priority =0)
	public void Validate_Url() throws Exception {
		String url = propertiesOprations.get_Properties_by_Key("url");
		driver.get(url);
		
		String title = "Swag Labsn";

		String actualTitle = driver.getTitle();
		System.out.println("Verifying the page title has started");

		Assert.assertEquals(actualTitle,title,"Page title");

		System.out.println("The page title has been successfully verified");

		System.out.println("User logged in successfully");
		
		ExtentTest test =extent.createTest("Page Tittle Test").assignAuthor("kiran").assignCategory("Smoke Testing");  //Create Test Node
        
		 
		test.pass("Page Tittle Test done  Successfully" ,MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScrenshotpatth()).build()) ; // Create Step Node 
	}
	
		
	@Test (enabled=true , priority =1 )
	public static void Validate_User_Checkout() throws IOException {

    	//Add product 
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click()	;
		//Click on Cart 	
		driver.findElement(By.xpath("//div[@class='shopping_cart_container']//a[1]")).click();

		//Click CheckOut
		driver.findElement(By.id("checkout")).click();	

		//Add User Details 
		driver.findElement(By.id("first-name")).sendKeys("Kiran");
		driver.findElement(By.id("last-name")).sendKeys("Pawar");
		driver.findElement(By.id("postal-code")).sendKeys("4162782");
		driver.findElement(By.id("continue")).click();

		//Click Finish On Final checkout 	
		driver.findElement(By.id("finish")).click();
		

		//Validate Response 	


		String Actual_Response = driver.findElement(By.xpath("//h2[@class='complete-header']/following-sibling::div[1]")).getText();	
		String Expected_Response = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

		
		ExtentTest test =extent.createTest("Page Check Out Test").assignAuthor("kiran").assignCategory("Regression Testing");  //Create Test Node
		 
		test.pass(" Product Check Out done  Successfully" ,MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScrenshotpatth()).build()) ; // Create Step Node 
		
		Assert.assertEquals(Actual_Response, Expected_Response ,"Response");
		System.out.println("The Product Check Out has been successfully verified");
		
		
	}
	   
	@Test (enabled=true , priority =2 )
	public void Validate_All_Products_count() throws IOException {

		List<WebElement>Products= driver.findElements(By.className("inventory_item_name"));
		ArrayList<String> List_of_Products= new ArrayList<String>();
		for(WebElement product:Products) {
		System.out.println("Products are: "+product.getText());
		List_of_Products.add(product.getText());

		}
		int count=List_of_Products.size();

		Assert.assertEquals(count, 6);

		System.out.println("The Product Count has been successfully verified");
		
		ExtentTest test =extent.createTest("Product Count Test").assignAuthor("kiran").assignCategory("Smoke Testing");  //Create Test Node
		 
		test.pass(" Product Count  done  Successfully" ,MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.getScrenshotpatth()).build()) ; // Create Step Node 
	}
	   
	   
	   

		

	 
}
