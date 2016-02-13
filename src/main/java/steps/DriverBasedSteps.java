package steps;

import org.openqa.selenium.WebDriver;
import pages.PageManager;

public class DriverBasedSteps {

    protected PageManager pages;

    public DriverBasedSteps(WebDriver driver){
        pages = new PageManager(driver);
    }
}
