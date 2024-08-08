package com.nsw.gov.testclasses;


import java.lang.invoke.MethodHandles;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.nsw.gov.framework.BaseClass;
import com.nsw.gov.framework.ConfigData;
import com.nsw.gov.framework.PropertiesReader;
import com.nsw.gov.pages.MediaRelease;
import com.nsw.gov.pages.NewPage;



public class TC001_VerifyMediaReleasePage extends BaseClass
{

//	public PropertiesReader propObject; 
	public MediaRelease mediaRelease;
	public NewPage newPage;
	
	
	@Override
	@BeforeClass
	public void setup() throws Exception
	{
		try
		{
			System.out.println("TC BEFORE_CLASS");

			super.setup(); 
			System.out.println("Setup Done");
			

			//Launch the application
			mediaRelease =  commonMethods.launchSFApplication();
			Thread.sleep(5000);
		}
		catch(Throwable e)
		{
			System.out.println(e.getCause());
		}
	}
	
	@Test
	public void TS001_Task1() throws Throwable
	{
		System.out.println("TC TEST");
		//mediaRelease = new MediaRelease(driver, locatorpropReaderObj);
//		mediaRelease.clickOnMinistersAccordian();
		mediaRelease.clickOnMinisterCheckboxes("Treasurer");
		mediaRelease.clickOnApplyFilter();
		newPage = mediaRelease.openTheArticleForCorrespondingMinister();

		boolean ActualMinisterName = newPage.validateTheMinisterNameOnArticleMatchesWithFilterApplied("Treasurer");	
		Assert.assertTrue(ActualMinisterName, "The Minster Name Does Not Match"); 
	}	

	@AfterClass
	public void tearDown()
	{
		
			System.out.println("TC AFTER_CLASS");						
//			driver.close();
			if(driver!=null) {
			driver.quit();
			}
		
	}
}

	
