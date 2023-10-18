package com.qa.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler; 
public class Screenshot extends BaseClass {

	
	public static String getScrenshotpatth() throws IOException {
		File Source=	((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String Dest=System.getProperty("user.dir")+"/Screenshots/image.png";
		FileHandler.copy(Source, new File (Dest) );
		return Dest;
		}
}
