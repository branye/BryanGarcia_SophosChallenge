package co.com.sophos.certification.challenge.tasks;

import static co.com.sophos.certification.challenge.userinterfaces.PlazaveaShoppingPage.SEARCH_BAR_ON_TOP;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.concurrent.TimeUnit;

import co.com.sophos.certification.challenge.models.CurrentProduct;
import co.com.sophos.certification.challenge.util.datamanagement.DataManagement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class FindAProduct implements Task{

	@Override
	public <T extends Actor> void performAs(T actor) {
		CurrentProduct product = DataManagement.getProductData();
		SEARCH_BAR_ON_TOP.resolveFor(actor).waitUntilPresent().withTimeoutOf(15, TimeUnit.SECONDS);
		actor.attemptsTo(
				Click.on(SEARCH_BAR_ON_TOP),
				Enter.theValue(product.getProductName()).into(SEARCH_BAR_ON_TOP));
		
	}
	
	public static FindAProduct onSearchBar() {
		return instrumented(FindAProduct.class);
	}

}
