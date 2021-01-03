package com.qa.driverfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driverObj;
	public static ThreadLocal<WebDriver> tlDriverObj = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to intialize the threadLocal driver based on the browser
	 * passed as the argument
	 * 
	 * @param browserName
	 * @return thread local driver instance
	 */
	public WebDriver init_driver(String browserName) {

		System.out.println("Browser Value : " + browserName);

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriverObj.set(new ChromeDriver());
		}

		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriverObj.set(new FirefoxDriver());
		}

		else if (browserName.equals("safari")) {
			tlDriverObj.set(new SafariDriver());
		}

		else if (browserName.equals("Internet Explorer")) {
			tlDriverObj.set(new InternetExplorerDriver());
		}

		else {
			System.out.println("Selected browser : {" + browserName + "} not supported");
		}

		setupBrowerWindow(getDriver());

		return getDriver();

	}

	/**
	 * This method is used to get the thread local driver in a synchronoised manner,
	 * in case of parallel execution
	 * 
	 * @return ThreadLocal driver instance
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriverObj.get();
	}

	/**
	 * This method is used to set the general properties of the browser used for
	 * automation
	 * 
	 * @param wbInstance
	 */
	public static void setupBrowerWindow(WebDriver wbInstance) {

		wbInstance.manage().deleteAllCookies();
		wbInstance.manage().window().maximize();

		wbInstance.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		wbInstance.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
