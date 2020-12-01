package ru.stqa.pft.testslavr.appmanager;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.pft.testslavr.model.DataTypeNodeName;
import ru.stqa.pft.testslavr.model.ProjectData;

import java.sql.SQLOutput;
import java.time.Duration;

import static jdk.nashorn.internal.objects.ArrayBufferView.length;

public class ProjectHelper extends HelperBase {
//  private String nameProject;

  public ProjectHelper(WebDriver driver) {
    super(driver);
  }

  public void addUserProject() {
    String addUser = "//*[@data-test-id='add-user-project']";
    String checkboxUser = "//div[@data-test-id='checkbox-user-project']";
    String buttonAdd = "//*[@data-test-id='checkbox-add-data-button']";

    wait(By.xpath(addUser));
    click(By.xpath(addUser));

    wait(By.xpath(checkboxUser + "//input"));
    //click((driver) -> driver.findElement(By.xpath(checkboxUser)).findElement(By.tagName("label")));
    driver.findElement(By.xpath(checkboxUser)).findElement(By.tagName("label")).click();

//    getElementByAndClick(ByOption.XPATH, "checkbox-add-data-button");

    wait(ExpectedConditions.elementToBeClickable(By.xpath(buttonAdd)));
    click(By.xpath(buttonAdd));
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

  public void createProjectNewNode(DataTypeNodeName nameType) throws InterruptedException {
    click(By.xpath("//*[@data-test-id='new-node']"));
//    wait(By.xpath("//*[@data-test-id='cancel-button']"));
    addFieldValue(By.xpath("//*[@class='modal-dialog modal-fit-height']//input"), nameType.getDataTypeNodeName());
//    System.out.println(driver.findElement(By.xpath("//div[@class='grid-item-title' and text()='Персона']")).getText());
//    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated());
//    WebElement dynamicElement = (new WebDriverWait(driver,  Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='grid-item-title' and text()= "+ datatype +"]"))));
//    wait(By.xpath("//*div[@class='grid-item-title' and text()="+datatype+"]"));
    Thread.sleep(2000);
    click(By.xpath("//div[@class='grid-item-title']"));
  }

}
