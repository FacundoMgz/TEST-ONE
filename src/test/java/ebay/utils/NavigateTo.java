package ebay.utils;

import ebay.pageobjects.EbayHomePage;
import net.thucydides.core.annotations.Step;

public class NavigateTo {

    EbayHomePage ebayHomePage;

    @Step("Open Ebay Homepage")
    public void ebayHomepage() {
        ebayHomePage.open();
    }
}
