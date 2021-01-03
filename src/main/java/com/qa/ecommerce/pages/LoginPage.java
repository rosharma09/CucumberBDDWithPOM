package com.qa.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driverObj;
	
	/**
	 * Below are the By locatore defined for the login page
	 * 
	 * These are private in nature and cannot be used elsewhere, or directly 
	 */
	
	private By forgotPwdLink = By.xpath("//a[text() = \"Forgot your password?\"]");
	private By emailField = By.xpath("//input[@id = \"email\"]");
	private By pwdField = By.xpath("//input[@id = \"passwd\"]");
	private By signInBtn = By.xpath("//button[@id = \"SubmitLogin\"]");
	private By searchBar = By.xpath("//input[@id = \"search_query_top\"]");
	
	/**
	 * Below is the parameterized constructor of the login page class
	 */
	
	public LoginPage(WebDriver driverObj) {
		this.driverObj = driverObj;
	}
	
	/**
	 * Below are the user performables/Actions/Behaviours
	 */
	
	public boolean isForgotPwdLinkVisible() {
		return driverObj.findElement(forgotPwdLink).isDisplayed();
	}
	
	public boolean isUnameFieldVisible() {
		return driverObj.findElement(emailField).isDisplayed();
	}
	
	public boolean isPwdFieldVisible() {
		return driverObj.findElement(pwdField).isDisplayed();
	}
	
	public String getPageTitle() {
		return driverObj.getTitle();
	}
	
	
	public void enterLoginDetails(String uname , String pwd) {
		driverObj.findElement(emailField).sendKeys(uname);
		driverObj.findElement(pwdField).sendKeys(pwd);
	}
	
	public void loginBtnClick() {
		driverObj.findElement(signInBtn).click();
	}
	
	
	/**
	 * This is a generic method which can be used to login into the application
	 * @param uname -- username provied
	 * @param pwd -- password provided
	 * @return HomePage -- return the home page object
	 */
	public HomePage doLogin(String uname , String pwd) {
		this.enterLoginDetails(uname , pwd);
		this.loginBtnClick();
		return new HomePage(driverObj);
	}
	
	public void forgotPwdLinkClick() {
		driverObj.findElement(forgotPwdLink).click();
	}
	
	public boolean isSearchBarDisplayed() {
		return driverObj.findElement(searchBar).isDisplayed();
	}
	
	public boolean isLinkDisplayed(String linkName) {
		return driverObj.findElement(By.xpath("//ul[@class = \"bullet\"]//li//a[text() = "
				+ "\""+linkName+"\"]")).isDisplayed();
	}
	

}
