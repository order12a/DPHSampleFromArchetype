package pages;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Home page, available when user is logged in
 */
public class HomePage extends Page {

//  @FindBy(how = How.TAG_NAME, using = "h1")
//  @CacheLookup
//  private WebElement header;

  @FindBy(xpath = "//a[@class='top-logo']/img")
  @CacheLookup
  private WebElement logo;

  @FindBy(xpath = "//span[contains(@class,'avatar-holder')]/img")
  @CacheLookup
  private WebElement avatarHolder;

  @FindBy(css = ".username")
  private WebElement usernameIndicator;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  public boolean ensurePageLoaded(){
    waitElementLoadedAndVisible(logo);
    waitElementLoadedAndVisible(avatarHolder);
    return  logo.isDisplayed() & avatarHolder.isDisplayed();
  }

  public boolean isLoggedIn(User user){
    waitElementLoadedAndVisible(usernameIndicator);
    return getText(usernameIndicator).equals(user.getUsername());
  }

}
