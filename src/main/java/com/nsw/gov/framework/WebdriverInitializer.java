package com.nsw.gov.framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class WebdriverInitializer 
{
	private String browser;

	public WebdriverInitializer(String browser) 
	{
		this.browser = browser;
	}

	protected WebDriver getWebDriver() throws MalformedURLException
	{
		return webdriverInitializer(this.browser);
	}

	protected static WebDriver webDriver = null;

	private WebDriver webdriverInitializer(String type) throws MalformedURLException 
	{
		switch(type) 
		{
		case "Chrome":
 	    	File chromeFile = new File("./src/main/resources/drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromeFile.getAbsolutePath());
			ChromeOptions options = new ChromeOptions();                                
			options.setAcceptInsecureCerts(true);
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");     
			// auth token required to access SeleniumBox
	/*		DesiredCapabilities capability = new DesiredCapabilities();
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setCapability("e34:token","79fed42b-8f73-43"); // auth token required to access SeleniumBox
			capability.setCapability("e34:video", true);
		//	capability.setVersion("75");
		//	capability.setCapability(CapabilityType.LOGGING_PREFS, logs);
		//	capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			// Initialize driver to use Selenium Box URL
			webDriver = new RemoteWebDriver(new URL(nodeUrl), capability);    */
	    	 webDriver = new ChromeDriver(options);
    		System.out.println(webDriver);
			break;

		case "Firefox":
			File FireFoxFile = new File("./src/main/resources/driver/geckodriver_64.exe");
			System.setProperty("webdriver.gecko.driver", FireFoxFile.getAbsolutePath());
			webDriver = new FirefoxDriver();
			System.out.println(webDriver);
			break;

		default:
			break;
		}
		return webDriver;
	}

}
