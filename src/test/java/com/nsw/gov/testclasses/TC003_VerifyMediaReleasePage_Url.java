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



public class TC003_VerifyMediaReleasePage_Url extends BaseClass
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
	public void TS002_Task2() throws Throwable
	{
		System.out.println("TC TEST");
		
//		mediaRelease.clickOnMinistersAccordian();
		mediaRelease.clickOnMinisterCheckboxes("Minister for Aboriginal Affairs and Treaty");
		mediaRelease.clickOnApplyFilter();
		String totalPagesOnMediaReleasePageAfterApplyingFilter = mediaRelease.totalPagesOnMediaRelease();
		int aggregatePagesOnMediaReleasePageAfterApplyingFilter= Integer.parseInt(totalPagesOnMediaReleasePageAfterApplyingFilter);
		System.out.println("The total page when fitler is applied: "+aggregatePagesOnMediaReleasePageAfterApplyingFilter);
		mediaRelease.clickOnClearAllFilterButton();
		mediaRelease.scrollToTotalPagesOnMediaRelease(); //
		String totalPagesOnMediaReleasePage=mediaRelease.totalPagesOnMediaRelease();
		int aggregatePagesOnMediaRelease = Integer.parseInt(totalPagesOnMediaReleasePage);
		System.out.println("The total count of the pages when fitler is cleared: "+aggregatePagesOnMediaReleasePageAfterApplyingFilter);
		//On the media release page the No.of Pages is 1990 after applying the Treasury filter I get 88
		//So I am  comparing these values to check if the filter was indeed applied than its total pages count
		//is less than the media-release page count
//		Assert.assertTrue((aggregatePagesOnMediaReleasePageAfterApplyingFilter < aggregatePagesOnMediaRelease), "The Filter applied has more pages");	
		
		String currentUrl = driver.getCurrentUrl();
		String updatedCurrentUrl = currentUrl.replaceAll("[?,]", "");
		System.out.println("The updated Url after removing ?: "+updatedCurrentUrl);
		//If the Filter is actually removed then I am verifying this by fetching 
		//the Url are removing the "?" at the end of the Url and comparing it with the media-release url
		Assert.assertEquals(updatedCurrentUrl, "https://www.nsw.gov.au/media-releases"); 

		 
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

	