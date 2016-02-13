package steps;

import org.openqa.selenium.WebDriver;

public class NavigationSteps extends DriverBasedSteps{

    public NavigationSteps(ApplicationFacade facade) {
        super(facade.getWebdriver());
    }
}
