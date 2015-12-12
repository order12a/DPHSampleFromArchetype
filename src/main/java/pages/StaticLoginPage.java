package pages;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Static login page that allow users login
 * in case of problem with JS provided login tip
 */
public class StaticLoginPage extends AnyPage{
    public StaticLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".d-login-holder>h1")
    private WebElement formHeader;

    @FindBy(css = ".d_placeholder[name=username]:first-child")
    @CacheLookup
    private WebElement loginFiled;

    @FindBy(css = ".d_placeholder[name=password]:first-child")
    @CacheLookup
    private WebElement passwordFiled;

    @FindBy(css = ".d-button-simple[type=submit]")
    @CacheLookup
    private WebElement loginButton;

    public boolean ensurePageLoaded(){
        return isDisplayed(formHeader);
    }

    public void loginStatic(User user){
        enterText(loginFiled, user.getUsername());
        enterText(passwordFiled, user.getPassword());
        clickElement(loginButton);
    }
}
