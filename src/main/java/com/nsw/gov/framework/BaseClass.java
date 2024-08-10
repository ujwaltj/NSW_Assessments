package com.nsw.gov.framework;
import java.io.File;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;



public class BaseClass 
{
	public static WebDriver driver;
	public CommonFunctions commonMethods;
	public static PropertiesReader configpropReaderObj;
	public static PropertiesReader locatorpropReaderObj;

	
	static 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}
	
	
	@BeforeClass
	public void setup() throws Exception
	{

		try 
		{
			WebdriverInitializer webinit = new WebdriverInitializer(configpropReaderObj.getData("chromeBrowser"));
			driver = webinit.getWebDriver();
			commonMethods = new CommonFunctions(driver, locatorpropReaderObj);
		} 
		catch (Throwable e) 
		{
			
			e.printStackTrace();
		}
		String className = this.getClass().getSimpleName();
		String browser = configpropReaderObj.getData("chromeBrowser");

	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("BASE CLASS BEFORE_TEST");
		configpropReaderObj = new PropertiesReader(new File("./src/main/resources/config.properties"));
		locatorpropReaderObj = new PropertiesReader(new File("./src/main/resources/objects.properties"));
	}
	
	
	
	

    
}
