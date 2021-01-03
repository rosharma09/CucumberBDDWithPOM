package com.qa.ecommerce.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driverObj;

	/**
	 * Below are the private By locators for the Home page
	 */

	private By myActLinkList = By.xpath("//div[@class = " + "\"row addresses-lists\"]//li//span");
	private By userHeaderInfo = By.cssSelector("div .row div.header_user_info a");

	public HomePage(WebDriver driverObj) {
		this.driverObj = driverObj;
	}

	public String getHomePageTitle() {
		return driverObj.getTitle();
	}

	/**
	 * This method is used to return the various options that are displayed in the
	 * account section of the Home page
	 * 
	 * @return List<String> -- return the list of String, containing the text of the
	 *         various accounts options displayed
	 */
	public List<String> getOptionList() {
		List<String> linkList = new ArrayList<String>();
		List<WebElement> myActLinkOptionList = driverObj.findElements(myActLinkList);

		for (WebElement e : myActLinkOptionList) {
			System.out.println("Element Text:" + e.getText());
			linkList.add(e.getText());
		}

		return linkList;
	}
	
	public void clickOnLink(String actOptionLink) {
		List<WebElement> elementsToClick = driverObj.findElements(myActLinkList);
		for(WebElement e : elementsToClick) {
			if(e.getText() == actOptionLink) {
				e.click();
			}
		}
	}
	
	public boolean isUserInfoHeaderDisplayed() {
		boolean isUserInfoHeaderDIsplayed = false;
		List<WebElement> userHeaderList = driverObj.findElements(userHeaderInfo);
		for(WebElement e: userHeaderList) {
			isUserInfoHeaderDIsplayed = e.isDisplayed();
		}
		
		return isUserInfoHeaderDIsplayed;
	}

}
