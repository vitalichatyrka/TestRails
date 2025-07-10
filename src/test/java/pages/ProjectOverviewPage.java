package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProjectOverviewPage extends BasePage {

  private final String PROJECT_TITLE_XPATH = "//div[@class='content-header-title page_title']",
      FIRST_PROJECT_CREATION_SUCCESS_MESSAGE = "//div[@class='empty-title']";

  @Step("Getting project title on the project overview page")
  public String getProjectTitle() {
    String projectTitle = $x(PROJECT_TITLE_XPATH).getText();
    log.info("Getting project title on the project overview page '{}'", projectTitle);
    return projectTitle;
  }

  @Step("Getting success message about first project creation on the project overview page")
  public String getSuccessMessageAboutFirstProjectCreation() {
    String successMessage = $x(FIRST_PROJECT_CREATION_SUCCESS_MESSAGE).getText();
    log.info("Getting success message about first project creation on the project overview page '{}'", successMessage);
    return successMessage;
  }

  @Step("Click to 'Test Cases' button")
  public TestCasesOverviewPage clickTestCasesButton() {
    log.info("Clicking 'Test Cases' button");
    $$(byText("Test Cases")).filter(Condition.visible).first().click();
    return new TestCasesOverviewPage();
  }
}
