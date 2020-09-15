package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImportHelper extends HelperBase {

  public ImportHelper(WebDriver driver) {
    super(driver);
  }

  public void openProject() {
    wait(By.xpath("//li[@class='name']"));
    click(By.linkText("Test25"));

//    Работа с таблицами
  }

  public void importFile() {
    String nameFile = "thread.rar";
    wait(By.xpath("//*[@data-test-id='button-createSearch']"));
    String x = driver.getCurrentUrl();
    String[] parts = x.split("/");
    String projectId = parts[parts.length - 2];
    System.out.println(projectId);
    click(By.xpath("//a[@href='/project/" + projectId + "/import']"));
    click(By.cssSelector(".vue-svg.default-create-icon.create.fill-"));
//    driver.findElement(By.xpath("//*[@class='upload-trap drop']")).click();
    By fileInput = By.cssSelector("input[type=file]");
    String filePath = "C:\\Develop\\files\\" + nameFile;
    driver.findElement(fileInput).sendKeys(filePath);
    click(By.xpath("//*[@data-test-id='save-import-project']"));
  }
}
