package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SessionHelper {
  private WebDriver driver;

  public SessionHelper(WebDriver driver) {
    this.driver = driver;
  }

  public void authorize(String userName, String userPass) {
    WebElement login = driver.findElement(By.id("login"));
    login.sendKeys(userName);
    WebElement pass = driver.findElement(By.cssSelector("#password"));
    pass.sendKeys(userPass);
    driver.findElement(By.name("button")).click();
  }
}
