package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ConfigProperties;
//import utilities.ConfigProperties;

public class LoginSteps extends BaseClass{
	//WebDriver driver;
	LoginPage loginpg ;//= new LoginPage(BaseClass.driver);
	BaseClass baseclass = new BaseClass();
	
	
	private ConfigProperties configprop;
	Properties prop;
	
	
	
	
	
	@Given("User launches the browser")
	public void user_launches_the_browser() throws IOException {
	 //   baseclass.setup();
		LoginPage loginpg = new LoginPage(driver);
	}
	
	
	

	@When("User opens sauce Labs url")
	public void user_opens_sauce_labs_url() throws InterruptedException {
	//	loginpg.openURL();
		System.out.println("sauceLabs");
		
		configprop=new ConfigProperties();
		prop = configprop.initializePropertyFile();
		String url = prop.getProperty("URL");
	    driver.get(url);	
	//    LoginPage loginpg = new LoginPage(driver);
	//	loginpg.enterUsername(username);
		Thread.sleep(5000);
		System.out.println("sauceLabs");
	}
	@And("user enters {string} and {string}")
	public void user_enters_and(String username, String password) throws InterruptedException {
		loginpg = new LoginPage(driver);
		loginpg.enterUsername(username);
		Thread.sleep(2000);
		loginpg.enterPassword(password);
		Thread.sleep(3000);
		System.out.println("sauceLabs");
	}

/*	@And("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
//prop = configprop.initializePropertyFile();
		
//		configprop=new ConfigProperties();
//		String username = prop.getProperty("username");
//		loginpg.enterUsername(username);
		Thread.sleep(3000);
		System.out.println("username entered");
	}*/

	@And("Clicks on login")
	public void clicks_on_login() {
		loginpg = new LoginPage(driver);
		loginpg.clickOnLoginButton();
		System.out.println("sauceLabs");
	}

	@Then("Homepage gets opened")
	public void homepage_gets_opened() {
		loginpg=new LoginPage(driver);
		loginpg.validateHomePage();
		System.out.println("verification of sauceLabs");
	}

}
