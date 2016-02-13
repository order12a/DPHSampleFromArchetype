package steps;


import org.openqa.selenium.WebDriver;

public class CartSteps extends DriverBasedSteps{
    public CartSteps(ApplicationFacade facade) {
        super(facade.getWebdriver());
    }
}
