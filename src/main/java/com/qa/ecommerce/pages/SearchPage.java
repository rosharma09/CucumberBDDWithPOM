package com.qa.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	private By productNameDisplayed = By.xpath(
			"//ul[@class = \"product_list grid row\"]//div[@class = \"right-block\"]//a[@class = \"product-name\"]");

	WebDriver driverObj;

	/**
	 * Below are the By locators for the searchPage
	 */

	public SearchPage(WebDriver driverObj) {
		this.driverObj = driverObj;
	}

//	private By searchResultPrices = By
//			.xpath("//ul[@class = \"product_list grid row\"]//li//div[@class = \"left-block\"]"
//					+ "//div[@class = \"content_price\"]//span[@itemprop= \"price\" "
//					+ "and @class = \"price product-price\"]");
	
	private By searchInput = By.xpath("//input[@id = \"search_query_top\"]");
	private By warningMessage = By.xpath("//p[@class = \"alert alert-warning\"]");

	public int itemDisplayedCount() {
		return driverObj.findElements(productNameDisplayed).size();
	}
	
	public String warningMessageDisplayedText() {
		return driverObj.findElement(warningMessage).getText();
	}

}
