package ru.stqa.pft.testslavr.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.testslavr.model.DataTypeNodeName;

public class PersonCreationTests extends TestBase {

  @Test
  public void testPersonCreation() throws InterruptedException {
    app.getProjectHelper().openProject();
    app.getProjectHelper().createProjectNewNode(new DataTypeNodeName("Персона"));
    app.getDataTypeHelper().creatingPersonInModalWindow();
    app.getDataTypeHelper().openViewerPerson();
//    app.getDataTypeHelper().addDocuments();
//    app.getDataTypeHelper().addContacts();
    app.getDataTypeHelper().addFinance();
  }
}
