package com.qa.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Reuseable_compunents.propertiesOprations;

public class BaseClass {
	
	static WebDriver driver ;
	static ExtentReports extent;
	
	@BeforeSuite
	public void setupreports() throws IOException {
		 extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
	//	spark.loadXMLConfig(new File ("extentConfig.xml"));
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
	}
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
	
	
	@BeforeMethod
		public void Launch_browser() throws Exception	
		{
		String url = propertiesOprations.get_Properties_by_Key("url");
		
		driver.get(url);

		   driver.findElement(By.id("user-name")).sendKeys(propertiesOprations.get_Properties_by_Key("user1.username"));
		   driver.findElement(By.id("password")).sendKeys(propertiesOprations.get_Properties_by_Key("user1.password"));

		   driver.findElement(By.id("login-button")).click();	
	}
	
	
	@AfterMethod
	public void closemethod(ITestResult result) throws IOException {
		
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			Screenshot.getScrenshotpatth();
		}
	}
	   @AfterClass
	   public static void teardown() 
	   {
		   driver.close();
		   driver.quit();
	   }
	   
	   @AfterSuite
		public void TearDownreports() throws IOException {	
		{
			extent.flush();
			Desktop.getDesktop().browse( new File("index.html").toURI()); //open the file in desktop default browser 
		}

}
	   
}
