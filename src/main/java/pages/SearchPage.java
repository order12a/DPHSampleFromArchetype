package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AnyPage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#d_search4")
    private WebElement searchField;

    @FindBy(className = ".search-button")
    private WebElement searchButton;

    @FindBy(css = ".item-image>img")
    private List<WebElement> searchResults;

    @FindBy(css = ".filter-item.contributor.active>span")
    private WebElement clearSearchResultsLink;

    public boolean ensurePageLoaded(){
        super.ensurePageLoaded();
        return isDisplayed(searchButton) && isDisplayed(searchField);
    }

    public boolean isSearchresultDisplayed(){
        waitForAjax(driver);
        waitElementLoadedAndVisible(searchResults.get(0));
        return searchResults.size() > 0;
    }

    public void clearSearchFilters(){
        clickElement(clearSearchResultsLink);
    }
}
