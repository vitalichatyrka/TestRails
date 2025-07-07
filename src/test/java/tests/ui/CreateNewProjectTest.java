package tests.ui;

import dto.Project;
import dto.ProjectFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.BaseTest;

public class CreateNewProjectTest extends BaseTest {

  @Test(description = "Successful creation new project")
  public void testNewProjectCreate() {
    Project project = new ProjectFactory().newProject();
    loginPage
        .openLoginPage()
        .isPageOpened()
        .login(user, password)
        .isDashboardPageOpened();
    dashboardPage.clickAddProjectButton()
        .fillProjectFields(project)
        .clickAddProjectButton();
    softAssert.assertEquals(projectsPage.getCreatedProjectName(project.getName()), project.getName(),
        "Created project is not found in the projects list");
    softAssert.assertEquals(projectsPage.getSuccessMessageAboutProjectCreation(),
        "Successfully added the new project.",
        "Successful notification is not shown or is not correct");
    softAssert.assertAll();
  }

  @Test(description = "Successful creation new project")
  public void testNewProjectIsShownOnDashboardPage() {
    Project project = new ProjectFactory().newProject();
    loginPage
        .openLoginPage()
        .isPageOpened()
        .login(user, password)
        .isDashboardPageOpened();
    dashboardPage.clickAddProjectButton()
        .fillProjectFields(project)
        .clickAddProjectButton();
    dashboardPage.open();
    Assert.assertEquals(dashboardPage.getCreatedProjectName(project.getName()), project.getName(),
        "Created project is not found in the projects list");
  }
}