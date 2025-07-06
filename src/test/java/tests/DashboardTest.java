package tests;

import dto.Project;
import dto.ProjectFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

  @Test(description = "Opening project overview page from dashboard page")
  public void testOpeningProjectOverviewPage() {
    Project project = new ProjectFactory().newProject();
    loginPage
        .openLoginPage()
        .isPageOpened()
        .login(user, password)
        .isDashboardPageOpened();
    dashboardPage.clickAddProjectButton()
        .fillProjectFields(project)
        .clickAddProjectButton();
    dashboardPage.open()
        .openProject(project.getName());
    Assert.assertEquals(projectOverviewPage.getProjectTitle(), project.getName(),
        "Project overview page is not opened");
  }
}
