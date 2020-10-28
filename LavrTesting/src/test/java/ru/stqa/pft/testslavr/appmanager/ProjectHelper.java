package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.testslavr.model.ProjectData;

import java.sql.SQLOutput;

import static jdk.nashorn.internal.objects.ArrayBufferView.length;

public class ProjectHelper extends HelperBase {
//  private String nameProject;

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
//    nameProject = (String) projectData.getNameProject();
    System.out.println(projectData.getNameProject());
    click(By.xpath(saveButton));
  }

  public void openModalWindowCreatedProject() {
    String openLinkProject = "//*[@data-test-id='open-new-project']/a";
    String x = driver.findElement(By.xpath(openLinkProject)).getAttribute("href");
    System.out.println("href на проект: " + x);
    click(By.xpath(openLinkProject));
    wait(By.xpath("//*[@data-test-id='name-project']"));
    System.out.println(getProjectIdByUrl());
  }

  public void openProject() {
    wait(By.xpath("//div[@class='project-tile']"));
    System.out.println(driver.findElement(By.xpath("//*[@data-test-id='table-name-project']/div[4]/div[2]/div[1]/a")).getText());
    click(By.xpath("//*[@data-test-id='table-name-project']/div[4]/div[2]/div[1]/a"));
//    click(By.xpath("//*[@data-test-id='table-name-project']/div[last()]/div[2]/div[1]/a]"));
    wait(By.xpath("//*[@data-test-id='button-createSearch']"));
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

  public void createProjectNewNode() {
    click(By.xpath("//*[@data-test-id='new-node']"));
    wait(By.xpath("//*[@data-test-id='data-type-input']"));
    addFieldValue(By.xpath("//*[@data-test-id='data-type-input']"), "Персона");
//    driver.findElement(By.xpath("//*[@data-test-id='data-type-input']")).sendKeys("Персона");
//    driver.findElement(By.xpath("//body/div[2]/div[1]/div/div/div/div/div[1]/div/aside/div[1]/div[1]/input")).sendKeys("Персона");
  }
}
