package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;
  protected WebDriverWait wait;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public String getCurrentUrl(){
    return driver.getCurrentUrl();
  }

  /**
  * Wait for Ajax another implementation
  */
  public static void waitForAjax(WebDriver driver) {
    new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript("return jQuery.active == 0");
      }
    });
  }

  /**
  * wait for Ajax using JS finished
  */
  public void waitForJavaScriptResponse(int timeoutSeconds){
    if(driver instanceof JavascriptExecutor && timeoutSeconds > 0){
      JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
      for (int i = 0; i < timeoutSeconds; i++){
        Long jsConnections = (Long) jsDriver.executeScript("return (xmlhttp.readyState >= 2 && xmlhttp.status == 200)");
        if(jsConnections instanceof Long){
          System.out.println("Number of active jQuery Ajax calls is <" + jsConnections + ">");//TODO replace with LOG
          if (jsConnections == 0)
            break;
        }
      }
    }else{
      System.out.println("Web Driver: <" + driver + "> can't execute JavaScript");//TODO replace with LOG
    }
  }

  //wait wrapper to wait elements generating by js framework e.g. Backbone (pure webdriver implementation)
  public void waitElementLoadedAndVisible(WebElement element){
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
  }

  //wait wrapper to wait elements generating by js framework e.g. Backbone (pure webdriver implementation)
  public void waitElementLoadedAndClickable(WebElement element){
    wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
  }

  //Try to avoid using it! as it will slow down tests and is Thread-unsafe if will run tests in parallel! Use implicit waits instead (e.g. waitForElementPresent etc...)!
  public void waitSeconds(int seconds){
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   *Standard method with waits to fill input field
   */
  public void enterText(WebElement input, String text){
    waitForAjax(driver);
    waitElementLoadedAndVisible(input);
    input.clear();
    input.sendKeys(text);
    waitForAjax(driver);
    waitForJavaScriptResponse(5);
  }

  /**
  *Standard method with waits to click at the target element
  */
  public void clickElement(WebElement element){
    waitForAjax(driver);
    waitElementLoadedAndClickable(element);
    element.click();
    waitForJavaScriptResponse(5);
    waitForAjax(driver);
  }

  public String getAttributeData(By by, String attribute){
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    return driver.findElement(by).getAttribute(attribute);
  }

  public String getAttributeData(WebElement element, String attribute){
    waitElementLoadedAndVisible(element);
    return element.getAttribute(attribute);
  }

  public String getText(WebElement element){
    waitElementLoadedAndVisible(element);
    return element.getText();
  }

  public boolean isDisplayed(WebElement element){
    waitForAjax(driver);
    waitForJavaScriptResponse(5);
    waitElementLoadedAndVisible(element);
    return element.isDisplayed();
  }
}
