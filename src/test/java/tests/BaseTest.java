package tests;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.screenshot;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
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
  Faker faker = new Faker();
  LoginPage loginPage;
  DashboardPage dashboardPage;
  AddProjectPage addProjectPage;
  ProjectsPage projectsPage;
  String user;
  String password;
  SoftAssert softAssert;
  ProjectOverviewPage projectOverviewPage;
  TestCaseDetailsPage testCaseDetailsPage;
  TestCasesOverviewPage testCasesOverviewPage;

  @Parameters({"browser"})
  @BeforeMethod(description = "Setup browser")
  public void setup(@Optional("chrome") String browser) {

    Configuration.headless = true;
    Configuration.timeout = 20000;
    Configuration.clickViaJs = false;
    Configuration.baseUrl = "https://testprojectchatyrka.testrail.io/";
    Configuration.browserSize = "1920x1080";
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));

    user = System.getenv().getOrDefault("user", PropertyReader.getProperty("user"));
    password = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));

    loginPage = new LoginPage();
    dashboardPage = new DashboardPage();
    addProjectPage = new AddProjectPage();
    projectsPage = new ProjectsPage();
    softAssert = new SoftAssert();
    projectOverviewPage = new ProjectOverviewPage();
    testCaseDetailsPage = new TestCaseDetailsPage();
    testCasesOverviewPage = new TestCasesOverviewPage();

  }

  @AfterMethod(alwaysRun = true, description = "Closing browser")
  public void tearDown(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
      screenshot("failure_" + result.getName());
    }
    closeWebDriver();
  }
}
