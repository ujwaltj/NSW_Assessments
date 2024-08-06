package com.nsw.gov.testclasses;


import java.lang.invoke.MethodHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.nsw.gov.framework.BaseClass;
import com.nsw.gov.framework.ConfigData;
import com.nsw.gov.framework.PropertiesReader;
import com.nsw.gov.pages.MediaRelease;
import com.nsw.gov.pages.NewPage;



public class TC001_VerifyMediaReleasePage extends BaseClass
{

	public PropertiesReader propObject; 
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
			commonMethods.launchSFApplication();
		}
		catch(Throwable e)
		{
			System.out.println(e.getCause());
		}
	}
	
	@Test(priority = 1)
	public void TS001_Task1() throws Throwable
	{
		System.out.println("TC TEST");
		
		mediaRelease.clickOnMinistersAccordian();
		mediaRelease.clickOnMinisterCheckboxes("Treasury");
		mediaRelease.clickOnApplyFilter();
		newPage = mediaRelease.openTheArticleForCorrespondingMinister();
		String ActualMinisterName = newPage.validateTheMinisterNameOnArticleMatchesWithFilterApplied("Treasury");	
		Assert.assertEquals(ActualMinisterName, "Treasury", "The Minster Name Does Not Match");

		String currentUrl = driver.getCurrentUrl();
		String decodedUrl = URLDecoder.decode(currentUrl, StandardCharsets.UTF_8.name());
		String ministerName = decodedUrl.substring(decodedUrl.indexOf("ministers=") + 10).replace("%20", " ").trim();
		Assert.assertEquals(ministerName, "Treasury", "The extracted minister's name does not match the expected name.");
	}	
	@Test(priority = 2)
	public void TS002_Task2() throws Throwable
	{
		System.out.println("TC TEST");
		
		mediaRelease.clickOnMinistersAccordian();
		mediaRelease.clickOnMinisterCheckboxes("Treasury");
		mediaRelease.clickOnApplyFilter();
		String totalPagesOnMediaReleasePageAfterApplyingFilter = mediaRelease.totalPagesOnMediaRelease();
		int aggregatePagesOnMediaReleasePageAfterApplyingFilter= Integer.parseInt(totalPagesOnMediaReleasePageAfterApplyingFilter);
		mediaRelease.clickOnClearAllFilterButton();
		String totalPagesOnMediaReleasePage = mediaRelease.totalPagesOnMediaRelease();
		int aggregatePagesOnMediaRelease = Integer.parseInt(totalPagesOnMediaReleasePage);
		Assert.assertTrue((aggregatePagesOnMediaReleasePageAfterApplyingFilter < aggregatePagesOnMediaRelease), "The Filter applied has more pages");	
		
		String currentUrl = driver.getCurrentUrl();
		String updatedCurrentUrl = currentUrl.replaceAll("[?,]", "");
		Assert.assertEquals(updatedCurrentUrl, "https://www.nsw.gov.au/media-releases");
		 
	}	
	@AfterClass
	public void tearDown()
	{
		
			System.out.println("TC AFTER_CLASS");						
			driver.close();
			driver.quit();
		
	}
}

	
