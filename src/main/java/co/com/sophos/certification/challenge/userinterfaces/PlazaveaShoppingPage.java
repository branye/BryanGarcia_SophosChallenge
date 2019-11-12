package co.com.sophos.certification.challenge.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PlazaveaShoppingPage extends PageObject{
	
	public static final Target SEARCH_BAR_ON_TOP = Target.the("The search bar at tyhe top of the page")
			.located(By.id("search_box"));
	public static final Target LOOK_FOR_PRODUCT_DETAILS = Target.the("label that redirects to product details")
			.located(By.xpath("(//a[@class='SuggestionItem__productLink'])[1]"));
	public static final Target ADD_PRODUCT_TO_CART_BUTTON = Target.the("button that add the product to shopping cart")
			.located(By.id("ProductCard__add-to-cart"));
	public static final Target CONTINUE_BUTTON = Target.the("Continue to view the product details")
			.located(By.xpath("//*[@class='button istertiary']"));
	public static final Target GO_CHECK_CART_ITEMS = Target.the("alert that appears when the product is added to shopping cart")
			.located(By.xpath("//section[@class='Header__top__cart']"));
	public static final Target CART_LOADED_TEMPLATE = Target.the("Label that contains the product name")
			.located(By.id("cartLoadedDiv"));
	public static final Target PRODUCT_NAME_LABEL = Target.the("Label that contains the product name")
			.located(By.id("product-name51506"));
	public static final Target PRODUCT_PRICE_LABEL = Target.the("Label that contains the product price")
			.located(By.xpath("//del[@class='old-product-price muted']"));
	

}
