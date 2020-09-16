package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver driver) {
    super(driver);
  }

  public void authorize(String userName, String userPass) {
    addFieldValue(By.id("login"), userName);
    addFieldValue(By.cssSelector("#password"), userPass);
    click(By.name("button"));
  }

}
