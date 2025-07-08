package pages;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProjectsPage extends BasePage {

  private final String SUCCESSFUL_NOTIFICATION_XPATH = "//div[@class='message message-success']";

  public ProjectsPage() {
  }

  @Step("Checking  the project is created")
  public String getCreatedProjectName(String projectName) {
    log.info("Checking if the Projects page is opened");
    return $(byText(projectName)).getText();
  }

  @Step("Getting  successful message about project creation")
  public String getSuccessMessageAboutProjectCreation() {
    log.info("Checking if the Projects page is opened");
    return $x(SUCCESSFUL_NOTIFICATION_XPATH).getText();
  }

  @Step("Opening Projects page")
  public ProjectsPage openProjectsPage() {
    log.info("Opening Projects page {}", baseUrl + PRJECTS_URL);
    Selenide.open(baseUrl + PRJECTS_URL);
    return this;
  }
}

