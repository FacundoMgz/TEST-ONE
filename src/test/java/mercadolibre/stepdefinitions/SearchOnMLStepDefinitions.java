package mercadolibre.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mercadolibre.utils.NavigateTo;
import mercadolibre.steps.MercadoLibreHomeSteps;
import mercadolibre.steps.SearchResultSteps;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class SearchOnMLStepDefinitions {

    @Steps
    NavigateTo navigateTo;

    @Steps
    MercadoLibreHomeSteps mercadoLibreHomeSteps;

    @Steps
    SearchResultSteps searchResultSteps;

    @Given("I am on MercadoLibre homepage")
    public void navigateToMercadoLibreHomepage() {
        navigateTo.ebayHomepage();
    }

    @When("I search for (.*)")
    public void searchFor(String term) {
        mercadoLibreHomeSteps.term(term);
    }

    @When("I filter (.*) on brands")
    public void filterBrands(String brand) throws InterruptedException {
        searchResultSteps.brand(brand);
    }

    @When("I filter size 10")
    public void filterSizeTen() throws InterruptedException {
        searchResultSteps.sizeTen();
    }

    @When("I order the results placing (.*) prices first")
    public void orderResultsByPrice(String priority) {
        searchResultSteps.orderByPrice(priority);
    }

    @When("I display the name and prices of the first (.*) results")
    public void displayResultsNamesAndPrices(int count) {
        System.out.println("The following are the first " + count + " results: ");
        for (int i = 1; i <= count; i++) {
            searchResultSteps.printResultData(i);
        }
    }

    @When("I order the results by distance and filter by condition (.*)")
    public void orderByDistanceAndFilterByCondition(String condition) {
        searchResultSteps.orderByDistance();
        searchResultSteps.addCondition(condition);
    }

    @Then("I display the number of results")
    public void printResultNumber() {
        searchResultSteps.printResultCount();
    }

    @Then("I select the first (.*) results")
    public void captureFirstResults(int count) throws IOException {
        for (int i = 1; i <= count; i++) {
            searchResultSteps.captureElementScreenshot(i);
        }
    }
}
