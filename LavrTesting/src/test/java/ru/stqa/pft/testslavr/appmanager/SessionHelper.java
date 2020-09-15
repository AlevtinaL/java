package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver driver) {
    super(driver);
  }

  public void authorize(String userName, String userPass) {
    WebElement login = driver.findElement(By.id("login"));
    login.sendKeys(userName);
    WebElement pass = driver.findElement(By.cssSelector("#password"));
    pass.sendKeys(userPass);
    click(By.name("button"));
  }
}
