package pages;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DashboardPage extends BasePage {

  private final String ADD_PROJECT_BUTTON_ID = "#sidebar-projects-add";

  @Step("Opening the 'Dashboard Page'")
  public DashboardPage open() {
    log.info("Open 'Dashboard Page' by link: " + baseUrl + DASHBOARD_URL);
    Selenide.open(DASHBOARD_URL);
    return this;
  }

  @Step("Checking the dashboard page is opened")
  public boolean isDashboardPageOpened() {
    log.info("Checking if the dashboard page is opened");
    return $(ADD_PROJECT_BUTTON_ID).isDisplayed();
  }

  @Step("Click to 'ADD Project' button")
  public AddProjectPage clickAddProjectButton() {
    log.info("Clicking 'ADD Project' button");
    $(ADD_PROJECT_BUTTON_ID).click();
    return new AddProjectPage();
  }

  @Step("Getting created project name")
  public String getCreatedProjectName(String projectName) {
    log.info("Getting created project name - {}", projectName);
    return $$(byText(projectName)).filter(Condition.visible).first().getText();
  }

  @Step("Opening  the project")
  public ProjectOverviewPage openProject(String projectName) {
    log.info("Opening {} the Project", projectName);
    $$(byText(projectName)).filter(Condition.visible).first().click();
    return new ProjectOverviewPage();
  }
}
