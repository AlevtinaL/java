package ru.stqa.pft.testslavr.tests;

import org.testng.annotations.Test;

public class PersonCreationTests extends TestBase {

  @Test
  public void testPersonCreation() {
    app.getProjectHelper().openProject();
    app.getProjectHelper().createProjectNewNode();
  }
}
