package mercadolibre.utils;

import mercadolibre.pageobjects.MercadoLibreHomePage;
import net.thucydides.core.annotations.Step;

public class NavigateTo {

    MercadoLibreHomePage mercadoLibreHomePage;

    @Step("Open Ebay Homepage")
    public void ebayHomepage() {
        mercadoLibreHomePage.open();
    }
}
