package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {
	WebDriver driver;
	AnyPage anyPage;
	StaticLoginPage staticLoginPage;
	SearchPage searchPage;
	MainPageLoggedOut mainPageLoggedOut;
	ItemPage itemPage;
	HomePage homePage;
	CartPage cartPage;
		
	public PageManager(WebDriver driver) {
		super();
		this.driver = driver;
	}



	public <T extends Page> void initPage(T page){
		PageFactory.initElements(driver, page);
	}
	
	public WebDriver getWebdriver() {
		return driver;
	}
}
