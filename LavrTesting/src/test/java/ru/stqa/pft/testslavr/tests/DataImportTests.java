package ru.stqa.pft.testslavr.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.testslavr.model.ProjectData;


public class DataImportTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getProjectHelper().openProject();
    app.getImportHelper().openTabImport();
    app.getImportHelper().importFile();
    app.getImportHelper().getImportStatus();
  }

}
