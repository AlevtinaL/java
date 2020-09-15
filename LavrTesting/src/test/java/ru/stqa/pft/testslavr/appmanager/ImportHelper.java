package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImportHelper {
  WebDriver driver;

  public ImportHelper(WebDriver driver) {
    this.driver = driver;
  }

  public void openProject() {
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='name']")));
    driver.findElement(By.linkText("Test25")).click();

//    Работа с таблицами
//    List col = driver.findElements(By.xpath("//table[@id='id']/thead/tr/th[1]"));
//    System.out.println("No of cols are : " + col.size());
//    //No.of rows
//    List  rows = driver.findElements(By.xpath("//table[@data-test-id='table-entry']/tbody/tr/td[1]"));
//    System.out.println("No of rows are : " + rows.size());
  }

  public void importFile() {
    String nameFile = "thread.rar";
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test-id='button-createSearch']")));
    String x = driver.getCurrentUrl();
    String[] parts = x.split("/");
    String projectId = parts[parts.length - 2];
    System.out.println(projectId);
    driver.findElement(By.xpath("//a[@href='/project/" + projectId + "/import']")).click();
    driver.findElement(By.cssSelector(".vue-svg.default-create-icon.create.fill-")).click();
//    driver.findElement(By.xpath("//*[@class='upload-trap drop']")).click();
    By fileInput = By.cssSelector("input[type=file]");
    String filePath = "C:\\Develop\\files\\" + nameFile;
    driver.findElement(fileInput).sendKeys(filePath);
    driver.findElement(By.xpath("//*[@data-test-id='save-import-project']")).click();
  }
}
