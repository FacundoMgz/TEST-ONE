package ebay.pageobjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class SearchResultPage extends PageObject {
    //  region results header
    public static By RESULTS_COUNTER = By.cssSelector("#mainContent > div.s-answer-region.s-answer-region-center-top > div > div:nth-child(2) > div > div.srp-controls__control.srp-controls__count > h1 > span:nth-child(1)");

    public static By ORDER_BY_DROPDOWN = By.cssSelector("#w9 > button");
    public static By LOWER_PRICE_FIRST = By.cssSelector("#w9 > div > div > ul > li:nth-child(4)");
    public static By HIGHER_PRICE_FIRST = By.cssSelector("#w9 > div > div > ul > li:nth-child(5)");
    public static By NEAREST_DISTANCE_FIRST = By.cssSelector("#w9 > div > div > ul > li:nth-child(6)");
    //  endregion results header

    //  region filters
    public static By BRAND_SEARCH_FIELD = By.cssSelector("#w4-w2-0\\[0\\]");
    public static By SEARCHED_BRAND_CHECKBOX = By.cssSelector("#w4-w2 > ul > li:nth-child(6) > div > a > div > input");

    public static By SIZE_10_CHECKBOX = By.cssSelector("#x-refine__group_1__3 > ul > li:nth-child(5) > div > a > div > input");

    public static By FILTER_BY_STATUS = By.cssSelector("#w7 > button");
    public static By NEW_WITH_DEFECTS = By.cssSelector("#w7 > div > ul > li:nth-child(4)");
    //  endregion filters

    // region selector builders
    public static String displayedResultSelectorBuilder(int number) {
        String selector;
        return selector = "srp-river-results-listing" + number;
    }

    public static String resultTitleSelectorBuilder(int number) {
        String selector;
        String selectorId = "#srp-river-results-listing";
        String selectorPath = " > div > div.s-item__info.clearfix > a > h3";
        return selector = selectorId + number + selectorPath;
    }

    public static String resultPriceSelectorBuilder(int number) {
        String selector;
        String selectorId = "#srp-river-results-listing";
        String selectorPath = " > div > div.s-item__info.clearfix > div.s-item__details.clearfix > div:nth-child(1) > span.s-item__price";
        return selector = selectorId + number + selectorPath;
    }

    // endregion selector builders
}
