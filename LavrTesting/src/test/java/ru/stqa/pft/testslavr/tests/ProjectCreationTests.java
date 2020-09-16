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
    app.getProjectHelper().openTabAnalysis();
    app.getImportHelper().openTabImport();
    app.getProjectHelper().openTabGraph();
  }

}