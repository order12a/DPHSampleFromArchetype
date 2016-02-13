package com.dph.test;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;
import steps.ApplicationFacade;
import util.PropertyLoader;
import util.config.EnvironmentConfig;

import java.io.IOException;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;
  protected ApplicationFacade app;
  protected static String browser;

  protected WebDriver driver;

  @BeforeSuite
  public void initTestSuite() throws IOException {
//    baseUrl = PropertyLoader.loadProperty("site.url");
    EnvironmentConfig config = ru.qatools.properties.PropertyLoader.newInstance().populate(EnvironmentConfig.class);
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    baseUrl = config.getBaseUrl();
    browser = config.getBrowser();
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
  }

  @BeforeMethod
  public void initWebDriver() {
    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
    app = new ApplicationFacade(driver, baseUrl);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverFactory.dismissAll();
  }

}
