package ebay.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.ebay.com/")
public class EbayHomePage extends PageObject {

    public static By SEARCH_FIELD = By.id("gh-ac");
    public static By SEARCH_BUTTON = By.id("gh-btn");
}
