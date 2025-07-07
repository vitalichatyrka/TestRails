package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import dto.TestCase;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.DropDown;
import wrappers.TextBox;
import wrappers.TextInput;

@Log4j2
public class AddTestCasePage extends BasePage {

  private final String ADD_TEST_CASE_XPATH = "//button[@id='accept']",
      TITLE_FIELD_ID = "#title";


  @Step("Opening the 'Add test case' page")
  public AddTestCasePage isPageOpened() {
    $x(ADD_TEST_CASE_XPATH).shouldBe(Condition.visible);
    return this;
  }

  @Step("Fill in fields in a new test case")
  public AddTestCasePage fillInAllTestCaseFields(TestCase testCase) {
    $(TITLE_FIELD_ID).sendKeys(testCase.getTitle());
    new DropDown("section_id").selectValueInDropdown(testCase.getSection());
    new DropDown("template_id").selectValueInDropdown(testCase.getTemplate());
    new DropDown("type_id").selectValueInDropdown(testCase.getType());
    new DropDown("priority_id").selectValueInDropdown(testCase.getPriority());
    new DropDown("assigned_to_id").selectValueInDropdown(testCase.getAssignedTo());
    new TextInput("estimate").enterSomeTextToTextInput(testCase.getEstimate());
    new TextInput("refs").enterSomeTextToTextInput(testCase.getReferences());
    new DropDown("custom_automation_type").selectValueInDropdown(testCase.getAutomationType());
    new TextBox("Preconditions").enterSomeTextToTextArea(testCase.getPreconditions());
    new TextBox("Steps").enterSomeTextToTextArea(testCase.getSteps());
    new TextBox("Expected Result").enterSomeTextToTextArea(testCase.getExpectedResult());
    log.info("The '{}' test case is created", testCase.getTitle());
    return this;
  }

  @Step("Click to 'Add Test Cases' button")
  public TestCaseDetailsPage clickAddTestCasesButton() {
    log.info("Clicking 'Add Test Cases' button");
    $x(ADD_TEST_CASE_XPATH).click();
    return new TestCaseDetailsPage();
  }
}
