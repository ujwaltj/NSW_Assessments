package com.nsw.gov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nsw.gov.framework.PropertiesReader;

public class NewPage {
	WebDriver driver;
	PropertiesReader propObject;


	public NewPage(WebDriver driver, PropertiesReader propObject) 
	{
		this.driver = driver;
		this.propObject = propObject;
	}
	
	////p[contains(@class, 'node-content__element node-content__element--meta') and contains(text(), 'Deputy Premier')]
	public String validateTheMinisterNameOnArticleMatchesWithFilterApplied(String ministerName) {
		// Select the checkbox for the specified minister
        WebElement ministerNameInArticle = driver.findElement(By.xpath("//p[contains(@class, 'node-content__element node-content__element--meta') and contains(text(), '" + ministerName + "')]"));
        String ministerNameOnTheArticle=ministerNameInArticle.getText();
        return ministerNameOnTheArticle;
	}
}
