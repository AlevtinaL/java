package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.testslavr.model.ProjectData;

public class ProjectHelper extends HelperBase {

  public ProjectHelper(WebDriver driver) {
    super(driver);
  }

  public void addUserProject() {
    String addUser = "//*[@data-test-id='add-user-project']";
    String checkboxUser = "//div[@data-test-id='checkbox-user-project']";
    wait(By.xpath(addUser));
    click(By.xpath(addUser));
    wait(By.xpath("//div[@data-test-id='checkbox-user-project']//input"));
    driver.findElement(By.xpath(checkboxUser)).findElement(By.tagName("label")).click();
    click(By.xpath("//*[@data-test-id='checkbox-add-data-button']"));
  }

  public void gotoCreateProject() {
//    getElementByAndClick(ByOption.XPATH,"toolbar-create-project-button");
    click(By.xpath("//*[@data-test-id='toolbar-create-project-button']"));
  }

  public void fillProjectForm(ProjectData projectData) {
    WebElement name = driver.findElement(By.xpath("//*[@data-test-id='name-create-project']"));
    name.sendKeys(projectData.getNameProject());
    WebElement discrip = driver.findElement(By.xpath("//*[@data-test-id='description-create-project']"));
//    Еще рабочие варианты
//    WebElement discrip = driver.findElement(By.cssSelector("textarea[id^='__BVID__'][class='form-control']"));
//    WebElement discrip = driver.findElement(By.cssSelector("textarea[id*='__BVID__']"));
//    WebElement discrip = driver.findElement(By.xpath("//textarea[contains(@id,'__BVID__')]"));
//    WebElement discrip = driver.findElement(By.xpath("//textarea[starts-with(@id,'__BVID__')]"));
    discrip.sendKeys(projectData.getDescription());
    String saveButton = "//*[@data-test-id='save-data-button']";
    click(By.xpath(saveButton));
  }

  public void openCreatedProject() {
//    driver.findElement(By.xpath("//*[@data-test-id='open-new-project']")).findElement(By.tagName("a")).click();
    String openLinkProject = "//*[@data-test-id='open-new-project']/a";
    String x = driver.findElement(By.xpath(openLinkProject)).getAttribute("href");
    System.out.println("Ссылка после открытия нового проекта: " + x);
    click(By.xpath(openLinkProject));
    String d = driver.findElement(By.className("project")).findElement(By.className("name")).getText();
    System.out.println(d);
    String c = driver.getCurrentUrl();
    System.out.println("Текущий url: " + c);
    System.out.println(driver.findElement(By.xpath("//*[@data-test-id='name-project']")).getText());
    System.out.println(x.equals(c));
    String[] parts = x.split("/");
    String projectId = parts[parts.length - 2];
    System.out.println("Id проекта: " + projectId);
  }
}
