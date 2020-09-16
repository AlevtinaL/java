package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {
  protected WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  protected void click(By locator) {
    driver.findElement(locator).click();
  }

  protected void wait(By locator) {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  protected void addFieldValue(By locator, String text) {
    WebElement login = driver.findElement(locator);
    login.sendKeys(text);
  }

//  protected void getElementByAndClick(ByOption by, String query) {
//    getElementBy(by, query).click();
//  }
//
//  protected WebElement getElementBy(ByOption by, String query) {
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
//        item = By.linkText(query);
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

  public boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected String getProjectIdByUrl(){
    String projectId = null;
    String c = driver.getCurrentUrl();
    String[] parts = c.split("/");
    projectId = parts[parts.length - 2];
    return projectId;
  }
}
