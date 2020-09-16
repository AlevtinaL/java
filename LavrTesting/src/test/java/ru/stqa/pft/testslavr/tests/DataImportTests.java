package ru.stqa.pft.testslavr.tests;

import org.testng.annotations.Test;

public class DataImportTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getImportHelper().openProject();
    app.getImportHelper().openTabImport();
    app.getImportHelper().importFile();
    app.getImportHelper().getImportStatus();
  }

}
