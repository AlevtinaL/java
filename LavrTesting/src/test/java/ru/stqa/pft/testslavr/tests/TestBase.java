package ru.stqa.pft.testslavr.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.testslavr.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() throws InterruptedException {
    app.stop();
  }


//  private void getElementByAndClick(ByOption by, String query) {
//    getElementBy(by, query).click();
//  }
//
//  private WebElement getElementBy(ByOption by, String query) {
//    By item = null;
//
//    switch (by) {
//      case XPATH:
//        item = By.xpath(String.format("//*[@data-test-id='%s']", query));
//        break;
//      case ID:
//        item = By.id(query);
//        break;
//      case NAME:
//        item = By.name(query);
//        break;
//      case CSS:
//        item = By.cssSelector(query);
//        break;
//      case LINK:
//        item =  By.linkText(query);
//        break;
//      case XPATH_CUSTOM:
//        item = By.xpath(query);
//    }
//
//    return driver.findElement(item);
//  }
//
//  enum ByOption {
//    XPATH_CUSTOM,
//    XPATH,
//    CSS,
//    LINK,
//    NAME,
//    ID
//  }
}
