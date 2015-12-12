package pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;


@Name("Popup where user can recover his password")
@FindBy(xpath = "//div[@data-name='password-recovery' and @class='for-popup']")
public class PasswordRecoverPopup extends HtmlElement{

    @Name("User login input")
    @FindBy(name = "username")
    private TextInput userLoginInput;

    @Name("User email input")
    @FindBy(name = "email")
    private TextInput userEmailInput;

    @Name("Reset password button button")
    @FindBy(xpath = "//button[contains(@class,'d-sendLink')]")
    private Button sendRestLinkButton;

    @Name("Reset OK button")
    @FindBy(xpath = "//button[@data-step='2']")
    private Button resetPromptButton;

    public void resetPassword(String loginOrEmail){
        if (loginOrEmail != null && !loginOrEmail.isEmpty()){
            if (loginOrEmail.contains("@")){
                assertThat(userEmailInput.getWrappedElement(), displayed());
                userEmailInput.clear();
                userEmailInput.sendKeys(loginOrEmail);
                clickSendResetLinkButton();
            }else {
                assertThat(userLoginInput.getWrappedElement(), displayed());
                userLoginInput.clear();
                userLoginInput.sendKeys(loginOrEmail);
                clickSendResetLinkButton();
            }
            clickResetPromptButton();
        }else {
            throw new IllegalArgumentException("Input value could not be null or empty.");
        }
    }

    public void clickSendResetLinkButton(){
        assertThat(sendRestLinkButton.getWrappedElement(), displayed());
        sendRestLinkButton.click();
    }

    public void clickResetPromptButton(){
        assertThat(resetPromptButton.getWrappedElement(), displayed());
        resetPromptButton.click();
    }

    public WebElement getUserLoginInput() {
        return userLoginInput.getWrappedElement();
    }

    public WebElement getUserEmailInput() {
        return userEmailInput.getWrappedElement();
    }

    public WebElement getSendRestLinkButton() {
        return sendRestLinkButton.getWrappedElement();
    }

    public WebElement getResetPromptButton() {
        return resetPromptButton.getWrappedElement();
    }
}
