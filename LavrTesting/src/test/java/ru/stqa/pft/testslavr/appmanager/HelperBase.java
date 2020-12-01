package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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

  protected void waitAndClick(By locator) {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
    click(locator);
  }

  protected void wait(Function<WebDriver, WebElement> function) {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(function);
  }

  protected void addFieldValue(By locator, String text) {
    WebElement login = driver.findElement(locator);
    login.click();
    login.clear();
    login.sendKeys(text);
  }

  protected void addFieldValueAndEnter(By locator, String text) {
    WebElement login = driver.findElement(locator);
    login.click();
    login.clear();
    login.sendKeys(text);
    login.sendKeys(Keys.ENTER);
  }

  protected int countElements(By locator) {
    List<WebElement> count = driver.findElements(locator);
    return count.size();
  }

  protected boolean isElementPresent(By selector) {
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//    logger.debug("Is element present"+selector);
    boolean returnVal = true;
    try {
      driver.findElement(selector);
    } catch (NoSuchElementException e) {
      returnVal = false;
    } finally {
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    return returnVal;
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

  protected String getProjectIdByUrl() {
    String projectId = null;
    String c = driver.getCurrentUrl();
    String[] parts = c.split("/");
    projectId = parts[parts.length - 2];
    return projectId;
  }

}
