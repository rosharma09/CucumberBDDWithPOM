package stepdefinations;

import org.junit.Assert;

import com.qa.driverfactory.DriverFactory;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageStepDefinations {

	private LoginPage loginPageObj = new LoginPage(DriverFactory.getDriver());
	private HomePage homePageObj;

	@Given("User has already logged into the application")
	public void user_has_already_logged_into_the_application(DataTable credentialsTable) {

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		System.out.println("Logging into Application");

		System.out.println("Username : {" + credentialsTable.asMaps().get(0).get("Username") + "}");
		System.out.println("Password : {" + credentialsTable.asMaps().get(0).get("Password") + "}");

		homePageObj = loginPageObj.doLogin(credentialsTable.asMaps().get(0).get("Username"),
				credentialsTable.asMaps().get(0).get("Password"));

	}

	@Given("User is on Home page")
	public void user_is_on_home_page() {
		System.out.println("Home Page Title : {" + homePageObj.getHomePageTitle() + "}");
	}

	@Then("the following options are displayed to the user")
	public void the_following_options_are_displayed_to_the_user(DataTable optionTable) {

		System.out.println("Expected List of options: " + optionTable.asList());
		System.out.println("Actual List of options: " + homePageObj.getOptionList());

		Assert.assertTrue(optionTable.asList().equals(homePageObj.getOptionList()));

	}
	
	@Then("User info header is displayed")
	public void User_info_header_is_displayed() {
		Assert.assertTrue(homePageObj.isUserInfoHeaderDisplayed());
	}

}
