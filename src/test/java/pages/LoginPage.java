package pages;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class LoginPage extends BasePage {

  private final String EMAIL_ID = "#name",
      PASSWORD_ID = "#password",
      LOGIN_BUTTON_ID = "#button_primary",
      LOGIN_ERROR_ALERT_XPATH = "//div[@class='error-alert']",
      LOGIN_ERROR_TEXT_XPATH = "//div[@class='error-text']",
      EMAIL_REQUIRED_ERROR_MESSAGE = "Email/Login is required.",
      PASSWORD_REQUIRED_ERROR = "Password is required.",
      LOGIN_ERROR_MESSAGE = "Sorry, there was a problem." +
          "Email/Login or Password is incorrect. Please try again.",
      REQUIRED_FIELD_ERROR_XPATH = "//div[@class='loginpage-message-image loginpage-message ']";

  public LoginPage() {
    super();
  }

  public LoginPage openLoginPage() {
    log.info("Opening Login page {}", baseUrl);
    Selenide.open(baseUrl);
    return this;
  }

  @Step("Validate that 'Login page' was opened")
  public LoginPage isPageOpened() {
    $(LOGIN_BUTTON_ID).shouldBe(Condition.visible);
    return this;
  }

  @Step("Input name: {userName} and password: {password} and click to the 'Log in' button for login action")
  public DashboardPage login(String adminEmail, String adminPassword) {
    log.info("Log in with credentials {} in to {}", adminEmail, adminPassword);
    $(EMAIL_ID).sendKeys(adminEmail);
    $(PASSWORD_ID).sendKeys(adminPassword);
    $(LOGIN_BUTTON_ID).click();
    log.info("Log in with username: {} and password: {} ", adminEmail, adminPassword);
    return new DashboardPage();
  }

  @Step("Get an error message if admin with invalid credentials")
  public String getErrorMessageWhenInvalidCredentials() {
    String errorAlertName = $x(LOGIN_ERROR_ALERT_XPATH).getText();
    String errorText = $x(LOGIN_ERROR_TEXT_XPATH).getText();
    String commonError = errorAlertName + errorText;
    log.info("Getting error message '{}'", commonError);
    return commonError;
  }

  @Step("Get an error message about required email.")
  public String getErrorMessageAboutRequiredEmail() {
    String requiredErrorMessage = $x(REQUIRED_FIELD_ERROR_XPATH).getText();
    log.info("Getting error message '{}'", requiredErrorMessage);
    return requiredErrorMessage;
  }

  @Step("Get an error message about required password.")
  public String getErrorMessageAboutRequiredPassword() {
    String requiredErrorMessage = $x(REQUIRED_FIELD_ERROR_XPATH).getText();
    log.info("Getting error message '{}'", requiredErrorMessage);
    return requiredErrorMessage;
  }
}
