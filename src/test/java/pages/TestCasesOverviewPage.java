package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestCasesOverviewPage extends BasePage {

  private final String ADD_TEST_CASES_BUTTON_ID = "#sidebar-cases-add",
      DELETE_TEST_CASE_XPATH = "//tr[.//span[text()='%s']]//a[contains(@class,'deleteLink')]",
      TEST_CASE_TITLE_XPATH = "//tr[.//span[text()='%s']]";

  @Step("Click to 'Add test cases' button")
  public AddTestCasePage clickAddTestCasesButton() {
    log.info("Clicking 'Add test cases' button");
    $(ADD_TEST_CASES_BUTTON_ID).click();
    return new AddTestCasePage();
  }

  @Step("Click to 'Delete' button")
  public DeleteTestCaseConfirmationModal clickDeleteButton(String testCaseTitle) {
    log.info("Click to 'Delete' button for {} test case", testCaseTitle);
    $x(String.format(DELETE_TEST_CASE_XPATH, testCaseTitle)).hover().click();
    return new DeleteTestCaseConfirmationModal();
  }

  @Step("Check that test case is deleted")
  public boolean isTestCaseDeleted(String testCaseTitle) {
    log.info("Check that test case {} is deleted", testCaseTitle);
    return !$x(String.format(TEST_CASE_TITLE_XPATH, testCaseTitle)).shouldNot(Condition.exist).exists();
  }

  @Step("Click to test case title")
  public TestCaseDetailsPage clickToTestCaseTitle(String testCaseTitle) {
    log.info("Click to 'Delete' button for {} test case", testCaseTitle);
    $x(String.format(TEST_CASE_TITLE_XPATH, testCaseTitle)).click();
    return new TestCaseDetailsPage();
  }
}
