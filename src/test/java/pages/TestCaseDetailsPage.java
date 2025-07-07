package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestCaseDetailsPage extends BasePage {

  private final String SUCCESSFUL_NOTIFICATION_XPATH = "//div[@class='message message-success']",
      STEPS_VALUE_XPATH = "",
      PRECONDITIONS_VALUE_XPATH = "",
      PRIORITY_VALUE_XPATH = "";


  @Step("Getting  successful message about test case creation or updation")
  public String getSuccessMessage() {
    log.info("Getting  successful message about test case creation or updation");
    return $x(SUCCESSFUL_NOTIFICATION_XPATH).getText();
  }


  @Step("Click to 'Edit'  button")
  public EditTestCasePage clickEditButton() {
    log.info("Clicking 'Edit' button");
    $(byText("Edit")).click();
    return new EditTestCasePage();
  }

  @Step("Click to 'Test Cases' button")
  public TestCasesOverviewPage clickTestCasesButton() {
    log.info("Clicking 'Test Cases' button");
    $$(byText("Test Cases")).filter(Condition.visible).first().click();
    return new TestCasesOverviewPage();
  }
}
