package steps;

import org.openqa.selenium.WebDriver;

public class UserSteps extends DriverBasedSteps{
    public UserSteps(ApplicationFacade facade) {
        super(facade.getWebdriver());
    }
}
