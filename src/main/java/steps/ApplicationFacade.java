package steps;

import org.openqa.selenium.WebDriver;

public class ApplicationFacade extends DriverBasedSteps{
    String baseUrl;
    private UserSteps userSteps;
    private CartSteps cartSteps;
    private NavigationSteps navigationSteps;
    private SearchSteps searchSteps;
    private WebDriver driver;

    public ApplicationFacade(WebDriver driver, String baseUrl) {
        super(driver);
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public WebDriver getWebdriver() {
        return driver;
    }

    public void directLogout(String baseURL) {
        getWebdriver().get(baseURL + "/login/logout.html?backURL=login.html");
    }

    public String getCurrentUrl() {
        return  getWebdriver().getCurrentUrl();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void iniriateAllSteps(){
        userSteps = new UserSteps(this);
        cartSteps = new CartSteps(this);
        searchSteps = new SearchSteps(this);
        navigationSteps = new NavigationSteps(this);
    }
}

