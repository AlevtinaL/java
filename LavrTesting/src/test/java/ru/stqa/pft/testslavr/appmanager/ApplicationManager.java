package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver driver;

  private SessionHelper sessionHelper;
  private ProjectHelper projectHelper;
  private ImportHelper importHelper;
  private DataTypeHelper dataTypeHelper;

  public void init() {
    System.setProperty("webdriver.chrome.driver", "C:\\Develop\\Webdrivers\\chromedriver.exe");

//    Запуск тестов в headless-режиме
//    ChromeOptions options = new ChromeOptions();
//    options.setHeadless(true);
//    options.addArguments("--headless");
//    options.addArguments("--disable-gpu");
//    options.addArguments("--window-size=1920x1080");
//    driver = new ChromeDriver(options);

//    Запуск тестов в браузере Chrome
    driver = new ChromeDriver();
    driver.manage().window().maximize();

//    Общие настройки
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/home");
    importHelper = new ImportHelper(driver);
    projectHelper = new ProjectHelper(driver);
    sessionHelper = new SessionHelper(driver);
    dataTypeHelper = new DataTypeHelper(driver);
    System.out.println(driver.getTitle());

    sessionHelper.authorize("admin", "admin");
  }

  public void stop() {
    driver.quit();
  }

  public ImportHelper getImportHelper() {
    return importHelper;
  }

  public ProjectHelper getProjectHelper() {
    return projectHelper;
  }

  public DataTypeHelper getDataTypeHelper() {
    return dataTypeHelper; }
}
