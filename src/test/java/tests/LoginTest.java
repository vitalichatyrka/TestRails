package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  public String invalidUser = faker.internet().emailAddress();
  public String invalidPassword = faker.internet().password(5, 12, true, true);

  @Test(description = "Successful login")
  public void testLoginWithValidCredentials() {
    loginPage
        .openLoginPage()
        .isPageOpened()
        .login(user, password);
    assertTrue(dashboardPage.isDashboardPageOpened(), "User is not logged in.");
  }

  @Test(description = "Log in with invalid email")
  public void testInvalidLoginWithWrongEmail() {
    loginPage
        .openLoginPage()
        .isPageOpened()
        .login(invalidUser, password);
    assertEquals(loginPage.getErrorMessageWhenInvalidCredentials(), loginPage.getLOGIN_ERROR_MESSAGE());
  }

  @Test(description = "Log in with invalid password")
  public void testInvalidLoginWithWrongPassword() {
    loginPage
        .openLoginPage()
        .isPageOpened()
        .login(user, invalidPassword);
    assertEquals(loginPage.getErrorMessageWhenInvalidCredentials(), loginPage.getLOGIN_ERROR_MESSAGE());
  }


  @Test(description = "Unsuccessful log in with empty email")
  public void testInvalidLoginWithEmptyEmail() {
    loginPage
        .openLoginPage()
        .isPageOpened()
        .login("", password);
    assertEquals(loginPage.getErrorMessageAboutRequiredEmail(), loginPage.getEMAIL_REQUIRED_ERROR_MESSAGE());
  }

  @Test(description = "Unsuccessful log in with empty password")
  public void testInvalidLoginWithEmptyPassword() {
    loginPage
        .openLoginPage()
        .isPageOpened()
        .login(user, "");
    assertEquals(loginPage.getErrorMessageAboutRequiredPassword(), loginPage.getPASSWORD_REQUIRED_ERROR());
  }
}

