package steps;

import org.openqa.selenium.WebDriver;

public class SearchSteps extends DriverBasedSteps {
    public SearchSteps(ApplicationFacade facade) {
        super(facade.getWebdriver());
    }
}
