package pages;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DashboardPage extends BasePage {


  private final String ADD_PROJECT_BUTTON_ID = "#sidebar-projects-add";

  @Step("Opening the 'Dashboard Page'")
  public DashboardPage open() {
    log.info("Open 'Dashboard Page' by link: " + baseUrl + "index.php?/dashboard");
    Selenide.open("index.php?/dashboard");
    return this;
  }

  @Step("Waiting till the dashboard page is opened")
  public boolean isDashboardPageOpened() {
    log.info("Checking if the Projects page is opened");
    return $(ADD_PROJECT_BUTTON_ID).isDisplayed();
  }

}
