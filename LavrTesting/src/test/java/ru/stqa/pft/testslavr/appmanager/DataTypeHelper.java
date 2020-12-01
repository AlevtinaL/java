package ru.stqa.pft.testslavr.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataTypeHelper extends HelperBase {

  public DataTypeHelper(WebDriver driver) {
    super(driver);
  }

  public void creatingPersonInModalWindow() throws InterruptedException {
    By firstname = By.xpath("//*[@class='content-input-group null-content-group Person.firstName']//input");
    By lastname = By.xpath("//*[@class='content-input-group null-content-group Person.lastName']//input");
    By middlename = By.xpath("//*[@class='content-input-group null-content-group Person.middleName']//input");

    addFieldValue(firstname, "Игорь");
    addFieldValue(lastname, "Мариянов");
    addFieldValue(middlename, "Олегович");
    addFieldValue(By.xpath("//*[@class='content-input-group null-content-group date Std.date']//input"), "29.09.1988");
    addFieldValue(By.xpath("//*[@class='content-input-group null-content-group date Std.endDate']//input"), "18.12.2020");
    addFieldValue(By.xpath("//*[@class='content-input-group null-content-group Person.firstNameAtBirth']//input"), "Игорь");
    addFieldValue(By.xpath("//*[@class='content-input-group null-content-group Person.middleNameAtBirth']//input"), "Олегович");
    addFieldValue(By.xpath("//*[@class='content-input-group null-content-group Person.lastNameAtBirth']//input"), "Мариянов");
    click(By.className("selected-value"));
    click(By.xpath("//*[@class='dropdown-menu show']//a[@value='Male']"));
    addFieldValue(By.xpath("//*[@class='content-input-group null-content-group Person.nativeFirstName']//input"), "Igor");
    addFieldValue(By.xpath("//*[@class='content-input-group null-content-group Person.nativeMiddleName']//input"), "Olegovich");
    addFieldValue(By.xpath("//*[@class='content-input-group null-content-group Person.nativeLastName']//input"), "Marianov");
    click(By.xpath("//*[@class='btn vue-button btn-green btn-lg']"));
    Thread.sleep(2000);

    By elementXpath = By.xpath("//*[@data-test-id='duplicates']");
    //wait(elementXpath);
    if (!driver.findElement(elementXpath).getCssValue("display").equals("none")) {
      percentMatchCheck();
      System.out.println("1");
    } else {
//      waitAndClick(By.xpath("//*[@data-test-id='button-ok-create-person']"));
      waitAndClick(By.xpath("//*[contains(text(),'Открыть созданый узел')]"));
      System.out.println("2");
    }
  }

  public void percentMatchCheck() throws InterruptedException {
    if (driver.findElement(By.xpath("//*[@class='ml-2 match']")).getText().equals("100 %")) {
      System.out.println(driver.findElement(By.xpath("//*[@class='ml-2 match']")).getText());
      System.out.println(driver.findElement(By.xpath("//*[@class='ml-2 match']")).getText().equals("100 %"));
      click(By.xpath("//*[@data-test-id='button-use']"));
      System.out.println("3");
    } else {
      click(By.xpath("//*[@data-test-id='create node']"));
      waitAndClick(By.xpath("//*[@data-test-id='button-ok-create-person']"));
      System.out.println("4");
    }
  }

  public void openViewerPerson() throws InterruptedException {
    driver.navigate().refresh();
    click(By.xpath("//*[contains(text(),'Типы данных')]"));
    wait(By.xpath("//*[@class='counter expanded']"));
    addFieldValue(By.xpath("//*[@data-test-id='input-search']"), "Персона");
//      wait(By.xpath("//*[@class='list-item-content selected']"));
    Thread.sleep(2000);
    click(By.xpath("//*[@class='vue-svg list-icon fill-']"));
    addFieldValue(By.xpath("//*[@class='text-input text-input_filter-toolbar']"), "Мариянов");
    Thread.sleep(2000);
    click(By.xpath("//*[@class='lastName analysis-table']"));
    System.out.println("5");
    Thread.sleep(2000);
  }

  public void addDocuments() throws InterruptedException {
    creatingPersonNodes("Паспорт РФ", 1);
    passportRF();
    Thread.sleep(2000);
    creatingPersonNodes(" ИНН ", 1);
    iNN();
    Thread.sleep(2000);
    creatingPersonNodes(" СНИЛС ", 1);
    sNILS();
    Thread.sleep(2000);
    creatingPersonNodes(" Заграничный паспорт ", 1);
    passportInternational();
    Thread.sleep(2000);
    creatingPersonNodes(" Водительское удостоверение ", 1);
    driverLicense();
    Thread.sleep(2000);
    creatingPersonNodes(" Страховой полис ", 1);
    polis();
    Thread.sleep(2000);
    creatingPersonNodes(" Паспорт иностранного гражданина ", 1);
    passportForeignСitizen();
    Thread.sleep(2000);
  }

  public void addContacts() throws InterruptedException {
    creatingPersonNodes(" Телефонный номер ", 2);
    phoneNumber();
    Thread.sleep(2000);
    creatingPersonNodes(" Адрес электронной почты ", 2);
    email();
    Thread.sleep(2000);
    creatingPersonNodeAddress();
    creatingPersonNodes(" Интернет-профиль ", 2);
    internetProfile();
    Thread.sleep(2000);
  }


  public void addFinance() throws InterruptedException {
    creatingPersonNodesFinance(" Счет в банке ");
    bankAccount();
    Thread.sleep(2000);
    creatingPersonNodesFinance(" Банковская карта ");
    bankCard();
    Thread.sleep(2000);
  }

  public void bankAccount() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "123456789235645897");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[2]/input"), "Мариянов Игорь Олегович");
    addFieldValueAndEnter(By.xpath("//*[@data-test-id='create-documents']/label[3]//input"), "30124545458741546547872");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[4]/input"), "789654321");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[5]/input"), "045698235");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "Реквизиты банковского счета");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }

  public void bankCard() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "1234 5678 9235 6478");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[2]/input"), "30.12.24");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[3]/input"), "Мариянов Игорь Олегович");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[4]/input"), "-");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "Данные карты");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }

  public void passportRF() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "178926");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[2]/input"), "23.11.2020");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[3]/input"), "23.11.2030");
    click(By.xpath("//*[@data-test-id='create-documents']/label[4]/span[1]"));
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[5]/input"), "5456");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[6]/input"), "010-115");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[7]/input"), "Игорь");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[8]/input"), "Олегович");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[9]/input"), "Мариянов");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[10]/input"), "11.12.1988");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[11]/input"), "Новосибирск, пос. Кольцово");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[12]/input"), "ОУФМС по Новосибирской области п. Кольцово");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "Паспорт действительный, выдан гражданину");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }

  public void iNN() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "123456");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[2]/input"), "Игорь");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[3]/input"), "Олегович");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[4]/input"), "Мариянов");
    click(By.xpath("//*[@data-test-id='create-documents']/label[5]/div/div"));
    click(By.xpath("//*[@data-test-id='create-documents']/label[5]/div/div[2]/div[1]/div"));
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[6]/input"), "11.12.1988");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[7]/input"), "Новосибирск");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[8]/input"), "12.12.2000");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "ИНН действительный, выдан гражданину");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }

  public void sNILS() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "789-569-985 45");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[2]/input"), "Игорь");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[3]/input"), "Олегович");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[4]/input"), "Мариянов");
    click(By.xpath("//*[@data-test-id='create-documents']/label[5]/div/div"));
    click(By.xpath("//*[@data-test-id='create-documents']/label[5]/div/div[2]/div[1]/div"));
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[6]/input"), "11.12.1988");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[7]/input"), "Новосибирск");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[8]/input"), "12.12.2000");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "СНИЛС действительный, выдан гражданину");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }

  public void passportInternational() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "123456");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[2]/input"), "Новосибирск, пос. Кольцово");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[3]/input"), "Новосибирск, пос. Кольцово");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[4]/input"), "11.12.1988");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[5]/input"), "23.11.2020");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[6]/input"), "23.11.2030");
    click(By.xpath("//*[@data-test-id='create-documents']/label[7]/div/div"));
    click(By.xpath("//*[@data-test-id='create-documents']/label[7]/div/div[2]/div[1]/div"));
    click(By.xpath("//*[@data-test-id='create-documents']/label[8]/span[1]"));
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[9]/input"), "Игорь");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[10]/input"), "Мариянов");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[11]/input"), "Igor");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[12]/input"), "Olegovich");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[13]/input"), "Mariyanov");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[14]/input"), "Ru");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "Паспорт действительный, выдан гражданину");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }

  public void driverLicense() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "787545");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[2]/input"), "11.12.2015");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[3]/input"), "11.12.2025");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[4]/input"), "Новосибирск, пос. Кольцово");
    click(By.xpath("//*[@data-test-id='create-documents']/label[5]/div"));
    click(By.xpath("//*[@data-test-id='create-documents']/label[5]//div[@class='w-dropdown w-color--secondary-variant w-color--on-primary']/div[3]"));
    click(By.xpath("//*[@data-test-id='create-documents']/label[5]/div"));
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[6]/input"), "Игорь");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[7]/input"), "Мариянов");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[8]/input"), "Олегович");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[9]/input"), "Igor");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[10]/input"), "Olegovich");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[11]/input"), "Mariyanov");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "Удостоверение действительно, выдано гражданину");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }


  public void polis() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "78785698963554");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[2]/input"), "Новосибирск");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[3]/input"), "8795РПН");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[4]/input"), "15.12.2005");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "Страховой полис действительный, выдан гражданину");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }

  public void passportForeignСitizen() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "5697859456");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[2]/input"), "23.11.2020");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[3]/input"), "23.11.2030");
    click(By.xpath("//*[@data-test-id='create-documents']/label[4]/span[1]"));
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[5]/input"), "Игорь");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[6]/input"), "Мариянов");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[7]/input"), "Франция");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[8]/input"), "Переехал много лет назад, двойное гражданство");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "Паспорт действительный, выдан гражданину");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }

  public void phoneNumber() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "89264561234");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "номер рабочий");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }

  public void email() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "mail@gmail.com");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "email рабочий");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }

  public void internetProfile() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "mariyan456");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[2]/input"), "30.12.2015");
    click(By.xpath("//*[@data-test-id='create-documents']/label[3]/div"));
    click(By.xpath("//*[@data-test-id='create-documents']/label[3]//div[contains(text(),'Telegram')]"));
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label/input"), "Интернет");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }

  public void address() {
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[1]/input"), "Россия");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[2]/input"), "Московская область");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[3]/input"), "Городской округ Домодедово");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[4]/input"), "Центральный");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[5]/input"), "Домодедово");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[6]/input"), "Городской");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[7]/input"), "Советская");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[8]/input"), "-");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[9]/input"), "62к1");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[10]/input"), "294");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[11]/input"), "6");
    addFieldValue(By.xpath("//*[@data-test-id='create-documents']/label[12]/input"), "142001");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label[1]/input"), "Проживает по прописке");
    addFieldValue(By.xpath("//*[@data-test-id='comment']/label[2]/input"), "Живет с семьей");
    click(By.xpath("//*[@data-test-id='save-document']"));
    checkForDuplicates();
  }


  public void checkForDuplicates() {
    Boolean findClassDublicates = isElementPresent(By.xpath("//*[@class='duplicates']"));
    if (findClassDublicates) {
      int count = countElements(By.xpath("//*[@class='item duplicate-item']"));
      boolean hasExactMatch = false;
      for (int i = 1; i <= count; i++) {
        String matchPercentage = driver.findElement(By.xpath("//*[@class='duplicate-items']/div[" + i + "]//span[2]")).getText();
        if (matchPercentage.equals("(Совпадение 100%)")) {
          hasExactMatch = true;
          Boolean actionOnElements = isElementPresent(By.xpath("//*[@class='duplicate-items']/div[" + i + "]//span[contains(text(),'Этот элемент уже привязан')]"));
          if (!actionOnElements) {
            click(By.xpath("//*[@class='duplicate-items']/div[" + i + "]/div[3]/span"));
            break;
          } else {
            click(By.xpath("//*[@data-test-id='cancel-button-dublicates']"));
            break;
          }
        }
      }
      if (!hasExactMatch)
        click(By.xpath("//*[@data-test-id='create-button-dublicates']"));
    }
  }

  protected void creatingPersonNodes(String text, int numberBlock) {
    click(By.xpath("//*[@class='multi-column']/div[" + numberBlock + "]//*[@data-test-id='dropdown-button-plus']"));
    wait(By.xpath("//*[@class='dropdown-button w-size--custom w-color--primary w-color--on-primary active']"));
    click(By.xpath("//*[contains(text(),'" + text + "')]"));
    wait(By.xpath("//*[@class='dropdown-button w-size--custom w-state--disabled w-color--primary w-color--on-primary']"));
  }

  protected void creatingPersonNodesFinance(String text) {
    click(By.xpath("//*[@class='content']/div[2]//*[@data-test-id='dropdown-button-plus']"));
    wait(By.xpath("//*[@class='dropdown-button w-size--custom w-color--primary w-color--on-primary active']"));
    click(By.xpath("//*[contains(text(),'" + text + "')]"));
    wait(By.xpath("//*[@class='dropdown-button w-size--custom w-state--disabled w-color--primary w-color--on-primary']"));
  }

  protected void creatingPersonNodeAddress() {
    String xpathContacts = "//*[@class='multi-column']/div[2]//*[@data-test-id='dropdown-button-plus']";
    click(By.xpath(xpathContacts));
    wait(By.xpath("//*[@class='dropdown-button w-size--custom w-color--primary w-color--on-primary active']"));
    click(By.xpath(xpathContacts + "/div[2]/div/div[3]/span"));
    wait(By.xpath("//*[@class='dropdown-button w-size--custom w-state--disabled w-color--primary w-color--on-primary']"));
    address();
    Thread.sleep(2000);
  }

}
