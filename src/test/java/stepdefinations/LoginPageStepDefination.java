package stepdefinations;

import java.util.List;

import org.junit.Assert;

import com.qa.driverfactory.DriverFactory;
import com.qa.ecommerce.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefination {

	private LoginPage loginPageObj = new LoginPage(DriverFactory.getDriver());

	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@Then("Title of the page is displayed as {string}")
	public void title_of_the_login_page_is_displayed_as(String pageTitle) {
		Assert.assertTrue(pageTitle.equals(loginPageObj.getPageTitle()));
	}

	@Then("Forgot password link is displayed")
	public void forgot_password_link_is_displayed() {
		Assert.assertTrue(loginPageObj.isForgotPwdLinkVisible());
	}

	@When("User clicks on forgot password link")
	public void user_clicks_on_forgot_password_link() {
		loginPageObj.forgotPwdLinkClick();
	}

	@Then("Username and password fields are displayed")
	public void username_and_password_fields_are_displayed() {
		Assert.assertTrue(loginPageObj.isUnameFieldVisible());
		Assert.assertTrue(loginPageObj.isPwdFieldVisible());
	}

	@When("User enter the {string} and {string}")
	public void user_enter_the_and(String username, String password) {
		loginPageObj.enterLoginDetails(username, password);
	}

	@When("Click on the login button")
	public void click_on_the_login_button() {

		loginPageObj.loginBtnClick();
	}

	@Then("search bar is displayed")
	public void search_bar_is_displayed() {
		Assert.assertTrue(loginPageObj.isSearchBarDisplayed());
	}
	
	@Then("The below metioned hyperlinks are avaiable")
	public void the_below_metioned_hyperlinks_are_avaiable(DataTable dataTable) {
	   List<List<String>> myAccLinks = dataTable.asLists();
	   for(int i = 0 ; i < myAccLinks.size() ; i++) {
		   for(int j = 0 ; j < myAccLinks.get(i).size() ; j++) {
			   Assert.assertTrue(loginPageObj.isLinkDisplayed(myAccLinks.get(i).get(j)));
		   }
	   }
	}
	
	@When("User clicks on the {string} link")
	public void user_clicks_on_the_link(String string) {
	   
	}

}
