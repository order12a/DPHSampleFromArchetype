package pages.elements;

import model.User;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;
import static ru.yandex.qatools.matchers.webdriver.EnabledMatcher.enabled;

@Name("Login Tip")
@FindBy(css = ".login-form-tips")
public class LoginTip extends HtmlElement {

    @Name("User login input(username or email)")
    @FindBy(name = "username")
    private TextInput userLoginInput;

    @Name("User password input")
    @FindBy(name = "password")
    private TextInput userPasswordInput;

    @Name("Login button")
    @FindBy(css = ".button.l.green[type=submit]")
    private Button loginButton;

    @Name("Reset OK button")
    @FindBy(css = ".password-reset[data-action=password-recovery]")
    private Button resetPasswordLink;

    public void loginAsUser(User user){
        if (user == null){
            throw new IllegalArgumentException("User could not be null.");
        }
        assertThat(loginButton.getWrappedElement(), displayed());
        userLoginInput.clear();
        userLoginInput.sendKeys(user.getUsername());
        userPasswordInput.clear();
        userPasswordInput.sendKeys(user.getPassword());

        assertThat(loginButton.getWrappedElement(), enabled());
        loginButton.click();
    }

    public void clickResetPassword(){
        assertThat(resetPasswordLink.getWrappedElement(), displayed());
        resetPasswordLink.click();
    }
}
