package com.qa.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo {
	ExtentReports extent;
	WebDriver driver ;
	@BeforeSuite
	public void setupreports() throws IOException {
		 extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
	//	spark.loadXMLConfig(new File ("extentConfig.xml"));
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
	}
	@Test
	public void AttachScrenshotAs() throws Exception{
		// TODO Auto-generated method stub
		ExtentTest test =extent.createTest("login Test").assignAuthor("kiran").assignCategory("Smoke Testing");  //Create Test Node
		
		String Directory = System.getProperty("user.dir");		
		System.setProperty("WebDriver.chrome.driver", Directory +"//chromedriver.exe");
	//	String url = propertiesOprations.get_Properties_by_Key("url");
	//	System.out.println(url);
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

		ExtentSparkReporter Failed = new ExtentSparkReporter("failed_Testcases.html");
		Failed.filter().statusFilter().as(  new Status[] {Status.FAIL});  //not working 




		 
		test.pass("Browser Started Successfully" ,MediaEntityBuilder.createScreenCaptureFromPath(getScrenshotpatth()).build()) ; // Create Step Node 
		test.fail("Browser not Started Successfully" ,MediaEntityBuilder.createScreenCaptureFromPath(getScrenshotpatth()).build()) ; // Create Step Node , null)
		//LOgin_report.info("URL Loaded");
		//LOgin_report.info("Values Entered");
		//LOgin_report.pass("Login Test done Successfully");

		

		/*ExtentTest CheckOut_report =extent.createTest("CHeck_Out Test").assignAuthor("kiran").assignCategory("Regression Testing"); //Create Test Node 
		CheckOut_report.pass("CheckOut  Test Started Successfully");  // Create Step Node 
		CheckOut_report.info("Product Selected ");
		CheckOut_report.info("Clicked Add to Cart Button ");
		CheckOut_report.info("Clicked Add to CheckOut Button ");
		CheckOut_report.info("Values Entered");
		CheckOut_report.info("Clicked Add to Finish Button ");
		CheckOut_report.pass("CheckOut Test done Successfully");
		CheckOut_report.fail("Test Failed ");*/
	}	
	
	public String getScrenshotpatth() throws IOException {
	File Source=	((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String Dest=System.getProperty("user.dir")+"/Screenshots/image.png";
	FileHandler.copy(Source, new File (Dest) );
	return Dest;
	}
	
	@AfterSuite
	public void TearDownreports() throws IOException {	
	{
		extent.flush();
		Desktop.getDesktop().browse( new File("index.html").toURI()); //open the file in desktop default browser 
	}
	
	


}
}
