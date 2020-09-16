package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    wait(By.xpath(checkboxUser + "//input"));
    driver.findElement(By.xpath(checkboxUser)).findElement(By.tagName("label")).click();
//    getElementByAndClick(ByOption.XPATH, "checkbox-add-data-button");
    click(By.xpath("//*[@data-test-id='checkbox-add-data-button']"));
  }

  public void gotoCreateProject() {
//    getElementByAndClick(ByOption.XPATH, "toolbar-create-project-button");
    click(By.xpath("//*[@data-test-id='toolbar-create-project-button']"));
  }

  public void fillProjectForm(ProjectData projectData) {
    addFieldValue(By.xpath("//*[@data-test-id='name-create-project']"), projectData.getNameProject());
    addFieldValue(By.xpath("//*[@data-test-id='description-create-project']"), projectData.getDescription());
    String saveButton = "//*[@data-test-id='save-data-button']";
    click(By.xpath(saveButton));
  }

  public void openCreatedProject() {
    String openLinkProject = "//*[@data-test-id='open-new-project']/a";
    String x = driver.findElement(By.xpath(openLinkProject)).getAttribute("href");
    System.out.println("href на проект: " + x);
    click(By.xpath(openLinkProject));
    wait(By.xpath("//*[@data-test-id='name-project']"));
    System.out.println(getProjectIdByUrl());
  }

  public void openTabAnalysis() {
    click(By.xpath("//a[@href='/project/" + getProjectIdByUrl() + "/analysis']"));
    wait(By.xpath("//*[@data-test-id='button-createSearch']"));
    System.out.println("page analysis");
  }

  public void openTabGraph() {
    click(By.xpath("//a[@href='/project/" + getProjectIdByUrl() + "/graph']"));
    wait(By.cssSelector(".vue-svg.default-create-icon.create.fill-"));
    System.out.println("page graph");
  }
}
