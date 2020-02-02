package mercadolibre.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.mercadolibre.com.ar/")
public class MercadoLibreHomePage extends PageObject {

    public static By SEARCH_FIELD = By.cssSelector("body > header > div > form > input");
    public static By SEARCH_BUTTON = By.cssSelector("body > header > div > form > button");
}
