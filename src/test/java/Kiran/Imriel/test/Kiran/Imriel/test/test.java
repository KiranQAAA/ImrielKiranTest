package Kiran.Imriel.test.Kiran.Imriel.test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test extends BaseClass {


	
		
	   @Test (enabled=true , priority =1 )
	   public static void Validate_User_Checkout() {

		   driver.get("https://www.saucedemo.com/");

		   driver.findElement(By.id("user-name")).sendKeys("standard_user");
		   driver.findElement(By.id("password")).sendKeys("secret_sauce");

		   driver.findElement(By.id("login-button")).click();		


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

		   Assert.assertEquals(Actual_Response, Expected_Response ,"Response");


	   }

		

	 
}
