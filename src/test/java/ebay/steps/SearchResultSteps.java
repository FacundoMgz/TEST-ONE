package ebay.steps;

import ebay.pageobjects.SearchResultPage;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchResultSteps extends UIInteractionSteps {

    @Step("I Order the results placing lower place first")
    public void orderByPrice(String priority) {

        WebElement orderSelector = find(SearchResultPage.ORDER_BY_DROPDOWN);
        WebElement orderPriority = null;
        if (priority.equals("lower")) {
            orderPriority = find(SearchResultPage.LOWER_PRICE_FIRST);
        } else if (priority.equals("higher")) {
            orderPriority = find(SearchResultPage.HIGHER_PRICE_FIRST);
        }
        orderSelector.sendKeys(Keys.ENTER);
        orderPriority.click();
    }

    public static String ordinal(int i) {
        String[] sufixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + sufixes[i % 10];

        }
    }

    @Step("Filter for brand {0}")
    public void brand(String brand) throws InterruptedException {
        Thread.sleep(1000);
        WebElement brandSearchField = find(SearchResultPage.BRAND_SEARCH_FIELD);
        WebElement searchedBrandCheckbox = find(SearchResultPage.SEARCHED_BRAND_CHECKBOX);

        brandSearchField.clear();
        brandSearchField.sendKeys(brand);
        searchedBrandCheckbox.click();
    }

    @Step("Filter for size 10")
    public void sizeTen() throws InterruptedException {
        Thread.sleep(1000);
        WebElement size10 = find(SearchResultPage.SIZE_10_CHECKBOX);
        size10.click();
    }

    @Step("I capture a screenshot of the element {0}")
    public void captureElementScreenshot(int resultNumber) throws IOException {
        WebElement element = find(By.id(SearchResultPage.displayedResultSelectorBuilder(resultNumber)));
        String resultText = ordinal(resultNumber);

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(getDriver(), element);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd - HH.mm");
        String executionTime = format.format(date);

        String screenshotFolderPath = "target\\site\\serenity\\screenshots\\";
        String resultFolderPath = "target\\site\\serenity\\screenshots\\results - " + executionTime + "hs\\";

        File screenshotFolder = new File(screenshotFolderPath);
        boolean createScreenshotFolder = screenshotFolder.mkdir();

        File resultFolder = new File(resultFolderPath);
        boolean createResultFolder = resultFolder.mkdir();

        ImageIO.write(screenshot.
                getImage(), "png", new File(resultFolderPath + resultText + " Result.png"));
    }

    @Step("I display the numbers of results on the console")
    public void printResultCount() {
        String results = find(SearchResultPage.RESULTS_COUNTER).getText();
        System.out.println("The number of results is: " + results);
    }

    @Step("I display the information of every result on the console")
    public void printResultData(int resultNumber) {
        System.out.println("Result N° " + resultNumber + ": ");
        String resultTitle = find(By.cssSelector(SearchResultPage.resultTitleSelectorBuilder(resultNumber)))
                .getText();
        System.out.println("Result title: " + resultTitle);

        String resultPrice = find(By.cssSelector(SearchResultPage.resultPriceSelectorBuilder(resultNumber)))
                .getText();
        System.out.println("Result price: " + resultPrice);
    }

    @Step("I order results by distance")
    public void orderByDistance() {
        WebElement orderSelector = find(SearchResultPage.ORDER_BY_DROPDOWN);
        WebElement orderPriority = find(SearchResultPage.NEAREST_DISTANCE_FIRST);
        orderSelector.sendKeys(Keys.ENTER);
        orderPriority.click();
    }

    @Step("I filter by condition {0}")
    public void addCondition(String condition) {
        WebElement conditionSelector = find(SearchResultPage.FILTER_BY_STATUS);
        WebElement conditionFilter = find(SearchResultPage.NEW_WITH_DEFECTS);
        conditionSelector.sendKeys(Keys.ENTER);
        conditionFilter.click();
    }
}
