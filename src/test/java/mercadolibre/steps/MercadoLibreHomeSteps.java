package mercadolibre.steps;

import mercadolibre.pageobjects.MercadoLibreHomePage;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

public class MercadoLibreHomeSteps extends UIInteractionSteps {

    @Step("Search for product {0}")
    public void term(String product) {
        WebElement searchField = find(MercadoLibreHomePage.SEARCH_FIELD);
        WebElement searchButton = find(MercadoLibreHomePage.SEARCH_BUTTON);

        searchField.clear();
        searchField.sendKeys(product);
        searchButton.click();
    }
}
