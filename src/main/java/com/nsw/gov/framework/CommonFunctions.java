package com.nsw.gov.framework;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;

import com.nsw.gov.pages.MediaRelease;


public class CommonFunctions 
{
	private WebDriver driver;
	private PropertiesReader locatorPropReaderObj;


	public CommonFunctions(WebDriver driver, PropertiesReader proObject) 
	{	
		this.driver = driver;
		this.locatorPropReaderObj = proObject;
	}
	
	public MediaRelease launchSFApplication()
	{
		driver.get(ConfigData.sfURL);
		System.out.println("Launched Application");
		return new MediaRelease(driver, locatorPropReaderObj);
	}
}
