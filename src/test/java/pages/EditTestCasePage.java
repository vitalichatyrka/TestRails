package pages;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import dto.TestCase;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.DropDown;
import wrappers.TextBox;

@Log4j2
public class EditTestCasePage extends BasePage {

  private final String ADD_TEST_CASE_XPATH = "//button[@id='accept']";


  @Step("Opening the 'Edit test case' page")
  public EditTestCasePage isPageOpened() {
    $x(ADD_TEST_CASE_XPATH).shouldBe(Condition.visible);
    return this;
  }

  @Step("Fill in fields in a new test case")
  public EditTestCasePage editSomeFields(TestCase testCase) {
    new DropDown("priority_id").selectValueInDropdown(testCase.getPriority());
    new TextBox("Preconditions").enterSomeTextToTextArea(testCase.getPreconditions());
    new TextBox("Steps").enterSomeTextToTextArea(testCase.getSteps());
    log.info("The '{}' test case is created", testCase.getTitle());
    return this;
  }

  @Step("Click to 'Save Test Cases' button")
  public TestCaseDetailsPage clickSaveTestCasesButton() {
    log.info("Clicking 'Save Test Cases' button");
    $x(ADD_TEST_CASE_XPATH).click();
    return new TestCaseDetailsPage();
  }
}
