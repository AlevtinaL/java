package ru.stqa.pft.testslavr;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {
  WebDriver driver;

  @BeforeMethod
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Develop\\Webdrivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/home");

    authorization("admin", "admin");
  }

  private void authorization(String username, String userpass) {
    WebElement login = driver.findElement(By.id("login"));
    login.sendKeys(username);
    WebElement pass = driver.findElement(By.cssSelector("#password"));
    pass.sendKeys(userpass);
    driver.findElement(By.name("button")).click();
  }

  @Test
  public void testGroupCreation() {
    gotoCreateProject();
//    cancelCreateProject();
    addUserProject();
    fillFormProject(new ProjectData("Test32", "TestDescription"));
    openProject();
  }

  private void cancelCreateProject() {
    addUserProject();
    driver.findElement(By.xpath("//*[@data-test-id='checkbox-cancel-data-button']")).click();
    String cancelButton = "//*[@data-test-id='cancel-data-button']";
    driver.findElement(By.xpath(cancelButton)).click();
  }

  private void addUserProject() {
    String addUser = "//*[@data-test-id='add-user-project']";
    driver.findElement(By.xpath(addUser)).click();
    driver.findElement(By.xpath("//div[@data-test-id='checkbox-user-project']")).findElement(By.tagName("label")).click();
    driver.findElement(By.xpath("//*[@data-test-id='checkbox-add-data-button']")).click();
  }

  private void gotoCreateProject() {
    String xpathExpression = "//*[@data-test-id='toolbar-create-project-button']";
    driver.findElement(By.xpath(xpathExpression)).click();
//    driver.findElement(By.xpath("html/body/div[1]/main/div/div[1]/div/div/div[2]/div[1]/section/div/header/div[3]/div[4]/div/div[1]")).click();
  }

  private void fillFormProject(ProjectData projectData) {
    WebElement name = driver.findElement(By.xpath("//*[@data-test-id='name-create-project']"));
    name.sendKeys(projectData.getNameProject());
    WebElement discrip = driver.findElement(By.xpath("//*[@data-test-id='description-create-project']"));
//    Еще рабочие варианты
//    WebElement discrip = driver.findElement(By.cssSelector("textarea[id^='__BVID__'][class='form-control']"));
//    WebElement discrip = driver.findElement(By.cssSelector("textarea[id*='__BVID__']"));
//    WebElement discrip = driver.findElement(By.xpath("//textarea[contains(@id,'__BVID__')]"));
//    WebElement discrip = driver.findElement(By.xpath("//textarea[starts-with(@id,'__BVID__')]"));
    discrip.sendKeys(projectData.getDescription());
    String saveButton = "//*[@data-test-id='save-data-button']";
    driver.findElement(By.xpath(saveButton)).click();
  }

  private void openProject() {
//    driver.findElement(By.xpath("//*[@data-test-id='open-new-project']")).findElement(By.tagName("a")).click();
    String openLinkProject = "//*[@data-test-id='open-new-project']/a";
    String x = driver.findElement(By.xpath(openLinkProject)).getAttribute("href");
    System.out.println("Ссылка после открытия нового проекта: " + x);
    driver.findElement(By.xpath(openLinkProject)).click();
    String d = driver.findElement(By.className("project")).findElement(By.className("name")).getText();
    System.out.println(d);
    String c = driver.getCurrentUrl();
    System.out.println("Текущий url: " + c);
    System.out.println(driver.findElement(By.xpath("//*[@data-test-id='name-project']")).getText());
    System.out.println(x.equals(c));
    int lengthUrl = x.length();
    String idLength = x.substring(30, lengthUrl);
    System.out.println("Id проекта: " + idLength.substring(0, idLength.indexOf("/")));
  }


  @AfterMethod
  public void tearDown() throws InterruptedException {
    Thread.sleep(5000);
    driver.quit();
  }
}