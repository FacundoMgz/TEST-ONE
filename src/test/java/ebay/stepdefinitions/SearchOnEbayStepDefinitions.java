package ebay.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ebay.utils.NavigateTo;
import ebay.steps.EbayHomeSteps;
import ebay.steps.SearchResultSteps;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class SearchOnEbayStepDefinitions {

    @Steps
    NavigateTo navigateTo;

    @Steps
    EbayHomeSteps ebayHomeSteps;

    @Steps
    SearchResultSteps searchResultSteps;

    @Given("I am on Ebay homepage")
    public void navigateToEbayHomepage() {
        navigateTo.ebayHomepage();
    }

    @When("I search for (.*)")
    public void searchFor(String term) {
        ebayHomeSteps.term(term);
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
