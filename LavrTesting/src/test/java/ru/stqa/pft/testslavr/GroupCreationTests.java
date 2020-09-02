package ru.stqa.pft.testslavr;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {
  WebDriver driver;

  @BeforeMethod
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Develop\\Webdrivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/home");

    WebElement login = driver.findElement(By.id("login"));
    login.sendKeys("admin");
    WebElement pass = driver.findElement(By.id("password"));
    pass.sendKeys("admin");
    driver.findElement(By.name("button")).click();
  }

  @Test
  public void testGroupCreationTests() {
  }

  @AfterMethod
  public void tearDown() {
//   driver.quit();
  }
}
