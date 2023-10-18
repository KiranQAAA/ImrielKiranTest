package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.test.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath="//div[@class='login_logo']")
	WebElement PageTittle;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement Username_Placeholder;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password_Placeholder;
	
	@FindBy(xpath="//input[@class='submit-button btn_action']")
	WebElement Login_Placeholder;

	
	
    WebDriverWait wait;
	
	WebDriver driver;
	
  public LoginPage(WebDriver driver) {
     
		
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
	}
  
  
  public String fetchTitleOfPage()
	{
		String titleOfPage = driver.getTitle();
		
		return titleOfPage;
	}


public Boolean isUsername_PlaceholderDisplayed()
{
	Boolean isdisplayed = Username_Placeholder.isDisplayed();
	
	return isdisplayed;
}


public Boolean ispassword_PlaceholderDisplayed()
{
	Boolean isdisplayed = password_Placeholder.isDisplayed();
	
	return isdisplayed;
}

public Boolean isLogin_PlaceholderrDisplayed()
{
	Boolean isdisplayed = Login_Placeholder.isDisplayed();
	
	return isdisplayed;
}



}
