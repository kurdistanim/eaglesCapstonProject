package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import core.Base;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Initializer extends Base {

	// Cucumber Provides @Before and @After hooks
	// @Before Hooks will execute line of codes before each scenario
	// @After Hooks will execute line of codes after each scenario
	@Before
	public void beforeHooks(Scenario scenario) {

		logger.info("Scenario " + scenario.getName() + " Started");
		String browser = getBrowser();
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(getPLwait(), TimeUnit.SECONDS);

	}
	
	@After
	public void afterHooks(Scenario scenario) {
		tearDown();
		logger.info(scenario.getName() + "   " + scenario.getStatus());
		
	}
	

}







