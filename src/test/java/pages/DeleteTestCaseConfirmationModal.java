package pages;

import static com.codeborne.selenide.Selenide.$$x;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeleteTestCaseConfirmationModal extends BasePage {

  private final String MARK_AS_DELETE_BUTTON_XPATH = "//a[contains(.,'Mark as Deleted')]";

  @Step("Click to 'Mark As Deleted' button")
  public TestCasesOverviewPage clickMarkAsDeleteButton() {
    log.info("Click to 'Mark As Deleted' button");
    $$x(MARK_AS_DELETE_BUTTON_XPATH).filter(Condition.visible).first().click();
    return new TestCasesOverviewPage();
  }
}
