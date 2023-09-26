package Kiran.Imriel.test.Kiran.Imriel.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	static WebDriver driver ;
	@BeforeClass
	   public static void setup1() 
	   {
		   String Directory = System.getProperty("user.dir");		
		   System.setProperty("WebDriver.chrome.driver", Directory +"//chromedriver.exe");

		   ChromeOptions options = new ChromeOptions();
		   options.addArguments("--disable-notifications");
		   driver=new ChromeDriver(options);

		   driver.manage().window().maximize();
		   
		   //implicitlY Wait OF 30 SEC
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	   }
	

	   @AfterClass
	   public static void teardown() 
	   {
		   driver.quit();
	   }
}
