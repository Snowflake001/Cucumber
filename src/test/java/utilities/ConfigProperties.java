package utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	private Properties property;
	private String configpath = "C:\\Users\\Nikhil\\eclipse-workspace\\Cucumber\\src\\test\\java\\utilities\\config.properties";
	



	

	public Properties initializePropertyFile()	  {
		property = new Properties();
		try {
			InputStream  input = new FileInputStream(configpath);
			property.load(input);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		return property;
	
	}
	
	public String getBrowser() {
		String browser = property.getProperty("browser");
		if(browser!=null)
			return browser;
		else
			throw new RuntimeException("Browser info is not specified in config file");
	}
	
	

}
