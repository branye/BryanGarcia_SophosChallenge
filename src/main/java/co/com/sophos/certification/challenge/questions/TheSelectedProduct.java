package co.com.sophos.certification.challenge.questions;


import static co.com.sophos.certification.challenge.userinterfaces.PlazaveaShoppingPage.CART_LOADED_TEMPLATE;
import static co.com.sophos.certification.challenge.userinterfaces.PlazaveaShoppingPage.CONTINUE_BUTTON;
import static co.com.sophos.certification.challenge.userinterfaces.PlazaveaShoppingPage.GO_CHECK_CART_ITEMS;
import static co.com.sophos.certification.challenge.userinterfaces.PlazaveaShoppingPage.PRODUCT_NAME_LABEL;
import static co.com.sophos.certification.challenge.userinterfaces.PlazaveaShoppingPage.PRODUCT_PRICE_LABEL;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import co.com.sophos.certification.challenge.models.CurrentProduct;
import co.com.sophos.certification.challenge.util.datamanagement.DataManagement;
import co.com.sophos.certification.challenge.util.formater.ConvertMoney;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

public class TheSelectedProduct implements Question<Boolean>{

	@Override
	public Boolean answeredBy(Actor actor) {
		CurrentProduct productDetails = DataManagement.getProductData();
		boolean response = false;
		actor.attemptsTo(
				Click.on(GO_CHECK_CART_ITEMS),
				Click.on(CONTINUE_BUTTON));
		if(CART_LOADED_TEMPLATE.resolveFor(actor).isVisible()) {
			assertThat(productDetails.getProductName(), equalTo(Text.of(PRODUCT_NAME_LABEL).viewedBy(actor).asString()));
			assertThat(productDetails.getPrice(), equalTo(ConvertMoney.toStringer(Text.of(PRODUCT_PRICE_LABEL).viewedBy(actor).asString())));
			response = true;
		}
		return response;
	}
	
	public static TheSelectedProduct wasAddedToCartSuccessful() {
		return new TheSelectedProduct();
	}

}
