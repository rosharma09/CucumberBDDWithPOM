package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.driverfactory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	public ConfigReader configReaderObj;
	public Properties propObj;
	public DriverFactory driverFactoryObj;
	public WebDriver driverObj;
	
	@Before(order = 0)
	public void setProperties() {
		configReaderObj = new ConfigReader();
		propObj = configReaderObj.init_prop();
	}
	
	@Before(order = 1)
	public void lauchBrowser() {
		driverFactoryObj = new DriverFactory();
		driverObj = driverFactoryObj.init_driver(propObj.getProperty("browserName"));
	}
	
	@After(order = 0)
	public void closeBroser() {
		driverObj.quit();
	}
	
	@After(order = 1)
	public void takeSSForFailedScenario(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driverObj).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenShotName);
		}
	}

}
