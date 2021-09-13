package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class Base {
	public static WebDriver driver;
	public static Properties properties; // We need Properties class to read from files 
										// which has .properties extension 
	private String pathToFrameworkProperty = ".\\src\\test\\resource\\inputData\\frameworkProperty.properties";
	private String pathToLog4JFile =".\\src\\test\\resource\\inputData\\log4J.properties";
	public static Logger logger;
	
	public Base() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(pathToFrameworkProperty));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger = logger.getLogger("logger_File");
		PropertyConfigurator.configure(pathToLog4JFile);
	}
	
	public static String getURL() {
		String url =properties.getProperty("url");
		return url;
	}
	
	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
	}
	
	public static Long getImplicitWait() {
		String impWait = properties.getProperty("impwait");
		return Long.parseLong(impWait);
	}
	
	public static Long getPLwait() {
		String plwait = properties.getProperty("plwait");
		return Long.parseLong(plwait);
	}
	
	public static void openBrowser() {
		driver.get(getURL());
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
	
	
}

