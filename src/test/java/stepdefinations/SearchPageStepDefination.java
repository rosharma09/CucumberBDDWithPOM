package stepdefinations;

import org.junit.Assert;

import com.qa.driverfactory.DriverFactory;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.SearchPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageStepDefination {

	private SearchPage searchPageObj;
	private HomePage homePageObj = new HomePage(DriverFactory.getDriver());

	@When("User search for the following {string}")
	public void user_search_for_the_following(String itemToBeSearched) {
		searchPageObj = homePageObj.searchItem(itemToBeSearched);
	}

	@Then("User is displayed items as per the {string}")
	public void user_is_displayed_items_as_per_the(String itemDisplayedCount) {
		Assert.assertTrue(Integer.parseInt(itemDisplayedCount) == searchPageObj.itemDisplayedCount());
	}

	@Then("User is displayed {string} on the UI")
	public void user_is_displayed_on_the_ui(String expectedMessage) {
		String actualMessage = searchPageObj.warningMessageDisplayedText();
		Assert.assertTrue(actualMessage.equals(expectedMessage));
	}
}
