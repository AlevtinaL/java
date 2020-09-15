package ru.stqa.pft.testslavr.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.testslavr.model.ProjectData;

import java.util.UUID;

public class ProjectCreationTests extends TestBase {

  @Test
  public void testProjectCreation() {
    app.getProjectHelper().gotoCreateProject();
    app.getProjectHelper().addUserProject();
    app.getProjectHelper().fillProjectForm(new ProjectData(UUID.randomUUID().toString(), "TestDescription"));
    app.getProjectHelper().openCreatedProject();
  }

//  private void cancelCreateProject() {
//    addUserProject();
//    driver.findElement(By.xpath("//*[@data-test-id='checkbox-cancel-data-button']")).click();
//    String cancelButton = "//*[@data-test-id='cancel-data-button']";
//    driver.findElement(By.xpath(cancelButton)).click();
//  }
}