package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {

    private WebDriver driver;
    public AnyPage anyPage;
    public CartPage cartPage;
    public HomePage homePage;
    public InlinePopupPage inlinePopupPage;
    public ItemPage itemPage;
    public MainPageLoggedOut mainPageLoggedOut;
    public SearchPage searchPage;
    public StaticLoginPage staticLoginPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;

        anyPage = PageFactory.initElements(driver, AnyPage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        inlinePopupPage = PageFactory.initElements(driver, InlinePopupPage.class);
        itemPage = PageFactory.initElements(driver, ItemPage.class);
        mainPageLoggedOut = PageFactory.initElements(driver, MainPageLoggedOut.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        staticLoginPage = PageFactory.initElements(driver, StaticLoginPage.class);
    }
}
