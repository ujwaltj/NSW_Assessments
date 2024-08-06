package com.nsw.gov.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nsw.gov.framework.PropertiesReader;

public class MediaRelease {
	WebDriver driver;
	PropertiesReader propObject;
	PropertiesReader locatorPropReaderObj;

	public MediaRelease(WebDriver driver, PropertiesReader propObject) 
	{
		this.driver = driver;
		this.propObject = propObject;
	}

	public void clickOnMinistersAccordian() {
		// Expand the "Ministers" accordion
		WebElement ministersAccordion = driver.findElement(By.xpath(propObject.getData("nswMinisters")));
		if (!ministersAccordion.getAttribute("aria-expanded").equals("true")) {
			ministersAccordion.click();
		}
	}
	
	public void clickOnMinisterCheckboxes(String ministerName) {
		// Select the checkbox for the specified minister
        WebElement ministerCheckbox = driver.findElement(By.xpath("//label[contains(text(), '" + ministerName + "')]/preceding-sibling::input[@type='checkbox']"));
        if (!ministerCheckbox.isSelected()) {
            ministerCheckbox.click();
        }
	}
	
	public void clickOnApplyFilter() {
		 // Click the "Apply filters" button
        WebElement applyFiltersButton = driver.findElement(By.xpath(propObject.getData("nswApplyFilter")));
        applyFiltersButton.click();
        //wait for the page to load
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	public void clickOnClearAllFilterButton() {
		 // Click the "Clear all filters" button
       WebElement clearALLFiltersButton = driver.findElement(By.xpath(propObject.getData("nswClearAllFiltersButton")));
       clearALLFiltersButton.click();
       //wait for the page to load
       try {
           Thread.sleep(3000); 
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
	}
	
	public NewPage openTheArticleForCorrespondingMinister() {
		List<WebElement> clickOntheFirstArticle = driver.findElements(By.xpath(propObject.getData("nswFirstLinkMediaReleaseItemCards")));
		clickOntheFirstArticle.get(0).click();
		return new NewPage(driver, locatorPropReaderObj);
	}
	
	public String totalPagesOnMediaRelease() {
		WebElement totalPages = driver.findElement(By.xpath(propObject.getData("nswTotalPages")));
		String pages = totalPages.getText();
		String[] totalNumberOfPagesByDefault= pages.split(" "); //Showing 1 - 10 of 1999 results
		return totalNumberOfPagesByDefault[4];
	}
}
