package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnyPage extends Page{
    public AnyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".livechat-link")
    protected WebElement livechatLink;

    @FindBy(tagName = "body")
    private WebElement body;

    public boolean ensurePageLoaded(){
        return isDisplayed(livechatLink);
    }

    public void closePopup(){
        waitForAjax(driver);
        body.sendKeys(Keys.ESCAPE);
        waitElementLoadedAndVisible(body);
    }
}
