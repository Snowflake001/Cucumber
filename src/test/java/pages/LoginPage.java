

package pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;
import utilities.ConfigProperties;

public class LoginPage extends BaseClass {
	WebDriver driver;
	Properties prop;
	private ConfigProperties configprop;
	public LoginPage(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	
	public void enterUsername(String usernameid) {
		username.clear();
		username.sendKeys(usernameid);
		
	}
	public void enterPassword(String passwordid) {
		password.clear();
		password.sendKeys(passwordid);
		
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public void validateHomePage() {
		configprop=new ConfigProperties();
		prop = configprop.initializePropertyFile();
		String Expected_Title = prop.getProperty("Expected_Title");
		String actual_title = driver.getTitle();
		if(prop.getProperty("Expected_Title").equalsIgnoreCase(actual_title)) {
			System.out.println("Verification Successful----Correct Title is Displayed on Home Page");
		}
		else
			System.out.println("Verification Failed------Incorrect Title is Displayed");
		
	}
     
	
}