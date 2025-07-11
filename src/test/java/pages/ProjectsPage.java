package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProjectsPage extends BasePage {

  private final String SUCCESSFUL_NOTIFICATION_XPATH = "//div[@class='message message-success']";

  public ProjectsPage() {
  }

  @Step("Getting  created project name")
  public String getCreatedProjectName(String projectName) {
    log.info("Getting  created project name - {}", projectName);
    return $(byText(projectName)).getText();
  }

  @Step("Getting  successful message about project creation")
  public String getSuccessMessageAboutProjectCreation() {
    log.info("Checking if the Projects page is opened");
    return $x(SUCCESSFUL_NOTIFICATION_XPATH).getText();
  }
}
