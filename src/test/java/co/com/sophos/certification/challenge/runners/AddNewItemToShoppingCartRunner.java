package co.com.sophos.certification.challenge.runners;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import co.com.sophos.certification.challenge.util.datamanagement.BeforeSuite;
import co.com.sophos.certification.challenge.util.datamanagement.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(CustomRunner.class)
@CucumberOptions(
		features = "src/test/resources/co/com/sophos/certification/challenge/features/AddNewItemToShoppingCart.feature",
		glue = "co.com.sophos.certification.challenge.stepdefinitions",
		snippets = SnippetType.CAMELCASE)
public class AddNewItemToShoppingCartRunner {
	
	private AddNewItemToShoppingCartRunner() {
		
	}

	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
	    DataToFeature.overrideFeatureFiles("./src/test/resources/co/com/sophos/certification/challenge/features/AddNewItemToShoppingCart.feature");
	}
}
