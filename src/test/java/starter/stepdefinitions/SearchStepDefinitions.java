package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static starter.stepdefinitions.Constants.*;

public class SearchStepDefinitions {

    @Given("call endpoint for {string}")
    public void callEndpoint(String product) {
        SerenityRest.given().get(REQUEST_URL + product);
    }

    @When("the response code is {int}")
    public void verifyResponseCode(int code) {
        restAssuredThat(response -> response.statusCode(code));
    }

    @Then("verify the results displayed for {string}")
    public void verifyRequestResultForAvailableProduct(String product) {
        restAssuredThat(response -> response.body("title", everyItem(containsStringIgnoringCase(product))));
    }

    @Then("verify the results does not displayed for unavailable product")
    public void verifyRequestResultForUnavailableProduct() {
        restAssuredThat(response -> response.body("detail.error", is(true)));
    }
}
