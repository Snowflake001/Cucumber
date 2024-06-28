package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utilities.ConfigProperties;


public class BaseClass extends AbstractTestNGCucumberTests{
	
	private ConfigProperties configprop;
	Properties prop;
	public static WebDriver driver;
	public LoginPage loginpg;
//	public Logger logger;
	
	
	
	
/*	{
		logger = Logger.getLogger("SauceLabs");
		PropertyConfigurator.configure("log4j.properties");
	}*/
	@BeforeClass
	public void setup() throws IOException {
	//	logger.info("-------*******Launching Browser***********---------------");
		configprop=new ConfigProperties();
		prop = configprop.initializePropertyFile();
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			loginpg = new LoginPage(driver);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			loginpg = new LoginPage(driver);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			loginpg = new LoginPage(driver);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
			System.out.println("it didn't find any webdriver so return null***********");
	}
	@AfterClass
	public void teardown() {
//	logger.info("************closing the browser******************");
		driver.close();
		System.out.println("browser is closed succesfully");
	}

}
