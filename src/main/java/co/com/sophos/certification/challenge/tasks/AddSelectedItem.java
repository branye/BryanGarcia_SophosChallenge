package co.com.sophos.certification.challenge.tasks;

import static co.com.sophos.certification.challenge.userinterfaces.PlazaveaShoppingPage.ADD_PRODUCT_TO_CART_BUTTON;
import static co.com.sophos.certification.challenge.userinterfaces.PlazaveaShoppingPage.LOOK_FOR_PRODUCT_DETAILS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.concurrent.TimeUnit;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AddSelectedItem implements Task{

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(LOOK_FOR_PRODUCT_DETAILS));
		ADD_PRODUCT_TO_CART_BUTTON.resolveFor(actor).waitUntilClickable().withTimeoutOf(10, TimeUnit.SECONDS);
		actor.attemptsTo(Click.on(ADD_PRODUCT_TO_CART_BUTTON));
	}
	
	public static AddSelectedItem toShoppingCart() {
		return instrumented(AddSelectedItem.class);
	}

}
