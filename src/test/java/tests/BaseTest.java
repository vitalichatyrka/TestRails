package tests;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.screenshot;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.DashboardPage;
import pages.LoginPage;
import utils.PropertyReader;
import utils.TestListener;


@Listeners(TestListener.class)
public class BaseTest {
  Faker faker = new Faker();
  LoginPage loginPage;
  DashboardPage dashboardPage;

  String user;
  String password;

  @Parameters({"browser"})
  @BeforeMethod(description = "Setup browser")
  public void setup(@Optional("chrome") String browser) {

    //       Configuration.headless = true;
    Configuration.timeout = 20000;
    Configuration.clickViaJs = false;
    Configuration.baseUrl = "https://testprojectchatyrka.testrail.io/";
    Configuration.browserSize = "1920x1080";

    user = System.getenv().getOrDefault("user", PropertyReader.getProperty("user"));
    password = System.getenv().getOrDefault("password", PropertyReader.getProperty("password"));

    loginPage = new LoginPage();
    dashboardPage = new DashboardPage();

  }

  @AfterMethod(alwaysRun = true, description = "Closing browser")
  public void tearDown(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
      screenshot("failure_" + result.getName());
    }
    closeWebDriver();
  }
}
