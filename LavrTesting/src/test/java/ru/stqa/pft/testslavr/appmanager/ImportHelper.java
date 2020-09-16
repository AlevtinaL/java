package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.JsonToWebElementConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ImportHelper extends HelperBase {

  public ImportHelper(WebDriver driver) {
    super(driver);
  }

  public void openProject() {
    wait(By.xpath("//li[@class='name']"));
    click(By.linkText("Test25"));
    wait(By.xpath("//*[@data-test-id='button-createSearch']"));
  }

  public void importFile() {
    String nameFile = "thread.rar";
    click(By.cssSelector(".vue-svg.default-create-icon.create.fill-"));
    By fileInput = By.cssSelector("input[type=file]");
    String filePath = "C:\\Develop\\files\\" + nameFile;
    driver.findElement(fileInput).sendKeys(filePath);
    click(By.xpath("//*[@data-test-id='save-import-project']"));
  }

  public void openTabImport() {
    click(By.xpath("//a[@href='/project/" + getProjectIdByUrl() + "/import']"));
    wait(By.cssSelector(".vue-svg.default-create-icon.create.fill-"));
    System.out.println("page import");
  }

  public void getImportStatus() {
////   все значения таблицы
//    List<WebElement> elements = driver.findElements(By.xpath("//*[@data-test-id='import-table']"));
//    for(WebElement element: elements)
//    {
//      System.out.println(element.getText());
//    }
    WebElement valueIneed = driver.findElement(By.xpath("//*[@data-test-id='import-table']//tr[1]/td[4]"));
    System.out.println(valueIneed.getText());
    boolean x = valueIneed.equals("Загружено");
    System.out.println(x);
    new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.textToBePresentInElement(valueIneed,"Загружено"));
//    System.out.println(valueIneed.equals("Загружено"));
  }

}
