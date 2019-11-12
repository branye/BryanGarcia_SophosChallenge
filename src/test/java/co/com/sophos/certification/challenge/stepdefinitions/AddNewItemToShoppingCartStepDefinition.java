package co.com.sophos.certification.challenge.stepdefinitions;

import static co.com.sophos.certification.challenge.exceptions.AssertionPlazavea.SUCCESS_DIALOG_GET_MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import java.util.List;

import co.com.sophos.certification.challenge.exceptions.AssertionPlazavea;
import co.com.sophos.certification.challenge.questions.TheSelectedProduct;
import co.com.sophos.certification.challenge.tasks.AddSelectedItem;
import co.com.sophos.certification.challenge.tasks.FindAProduct;
import co.com.sophos.certification.challenge.util.datamanagement.DataManagement;
import co.com.sophos.certification.challenge.util.driver.CustomDriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class AddNewItemToShoppingCartStepDefinition {
	
	Actor user = Actor.named("Sophos solution");
	
	@Before
	public void setUpStage() {
		user.can(BrowseTheWeb.with(CustomDriver.chromeDriver().onPageURL("https://www.plazavea.com.pe/")));
	}
	
	@Given("^User searchs the product he wants to buy on plazavea web page$")
	public void userSearchsTheProductHeWantsToBuyOnPlazaveaWebPage(List<String> data) {
		DataManagement.setProductData(data);
		user.attemptsTo(FindAProduct.onSearchBar());
	}

	@When("^he selects an item to add in the shopping cart$")
	public void heSelectsAnItemToAddInTheShoppingCart() {
	    user.attemptsTo(AddSelectedItem.toShoppingCart());
	}

	@Then("^he verifies that the item selected was added to the shopping cart successful$")
	public void heVerifiesThatTheItemSelectedWasAddedToTheShoppingCartSuccessful() {
	    user.should(seeThat(TheSelectedProduct.wasAddedToCartSuccessful())
	    		.orComplainWith(AssertionPlazavea.class, SUCCESS_DIALOG_GET_MESSAGE));
	}
	


}
