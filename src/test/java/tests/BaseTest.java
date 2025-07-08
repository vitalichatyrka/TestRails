package tests;

import java.util.UUID;

import adapters.ProjectsAdapter;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProjectOverviewPage;
import pages.ProjectsPage;
import pages.TestCaseDetailsPage;
import pages.TestCasesOverviewPage;
import utils.PropertyReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {
  protected Faker faker = new Faker();
  protected LoginPage loginPage;
  protected DashboardPage dashboardPage;
  protected AddProjectPage addProjectPage;
  protected ProjectsPage projectsPage;
  protected String user;
  protected String password;
  protected SoftAssert softAssert;
  protected ProjectOverviewPage projectOverviewPage;
  protected TestCaseDetailsPage testCaseDetailsPage;
  protected TestCasesOverviewPage testCasesOverviewPage;
  protected ProjectsAdapter projectsAdapter;

  @Parameters({"browser"})
  @BeforeMethod(description = "Setup browser")
  public void setup(@Optional("chrome") String browser) {

    ChromeOptions options = new ChromeOptions();

    options.addArguments("--headless=new");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-gpu");

    Configuration.browserCapabilities = options;

    Configuration.headless = false;
    Configuration.timeout = 20000;
    Configuration.clickViaJs = false;
    Configuration.baseUrl = "https://testprojectchatyrka.testrail.io/";
    Configuration.browserSize = "1920x1080";

    SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
        .screenshots(false)
        .savePageSource(true)
    );

    user = System.getProperty("testrailUser", PropertyReader.getProperty("user"));
    password = System.getProperty("testrailPassword", PropertyReader.getProperty("password"));

    loginPage = new LoginPage();
    dashboardPage = new DashboardPage();
    addProjectPage = new AddProjectPage();
    projectsPage = new ProjectsPage();
    softAssert = new SoftAssert();
    projectOverviewPage = new ProjectOverviewPage();
    testCaseDetailsPage = new TestCaseDetailsPage();
    testCasesOverviewPage = new TestCasesOverviewPage();
    projectsAdapter = new ProjectsAdapter();
  }

  @AfterMethod(alwaysRun = true, description = "Closing browser")
  public void tearDown(ITestResult result) {
    Selenide.closeWebDriver();
  }
}
