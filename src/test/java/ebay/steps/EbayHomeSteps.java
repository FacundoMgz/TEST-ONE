package ebay.steps;

import ebay.pageobjects.EbayHomePage;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

public class EbayHomeSteps extends UIInteractionSteps {

    @Step("Search for product {0}")
    public void term(String product) {
        WebElement searchField = find(EbayHomePage.SEARCH_FIELD);
        WebElement searchButton = find(EbayHomePage.SEARCH_BUTTON);

        searchField.clear();
        searchField.sendKeys(product);
        searchButton.click();
    }
}
