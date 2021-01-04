package com.qa.ecommerce.pages;

import java.util.ArrayList;
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
	private By searchInput = By.xpath("//input[@id = \"search_query_top\"]");
	private By searchButton = By.cssSelector("button[name = \"submit_search\"]");

	public HomePage(WebDriver driverObj) {
		this.driverObj = driverObj;
	}

	/**
	 * This method is used to search for a particular item on the home page
	 * 
	 * @param itemToBeSearched
	 * @return SearchPage -- return the search page object
	 */
	public SearchPage searchItem(String itemToBeSearched) {
		driverObj.findElement(searchInput).sendKeys(itemToBeSearched);
		driverObj.findElement(searchButton).click();
		return new SearchPage(driverObj);
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
		for (WebElement e : elementsToClick) {
			if (e.getText() == actOptionLink) {
				e.click();
			}
		}
	}

	public boolean isUserInfoHeaderDisplayed() {
		boolean isUserInfoHeaderDIsplayed = false;
		List<WebElement> userHeaderList = driverObj.findElements(userHeaderInfo);
		for (WebElement e : userHeaderList) {
			isUserInfoHeaderDIsplayed = e.isDisplayed();
		}

		return isUserInfoHeaderDIsplayed;
	}

}
