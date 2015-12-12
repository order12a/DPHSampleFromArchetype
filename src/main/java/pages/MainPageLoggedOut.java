package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.elements.PasswordRecoverPopup;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.pagefactory.CustomElementLocatorFactory;


public class MainPageLoggedOut extends AnyPage{
    private PasswordRecoverPopup passwordRecoverPopup;

    @FindBy(xpath = "//a[contains(@class, 'd_html_tips')]")
    protected WebElement loginButton;

    @FindBy(xpath = "//a[@data-action='password-recovery']")
    protected WebElement recoverPasswordLink;

    public MainPageLoggedOut(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator((CustomElementLocatorFactory) driver), this);
    }

    public void clickLoginButton(){
        clickElement(loginButton);
    }

    public void clickPasswordRecoveryLink(){
        clickElement(recoverPasswordLink);
    }

    public void sendResetPassordLink(String loginOrEmail){
        passwordRecoverPopup.resetPassword(loginOrEmail);
    }
}
