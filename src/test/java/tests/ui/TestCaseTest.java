package tests.ui;

import dto.Project;
import dto.ProjectFactory;
import dto.TestCase;
import dto.TestCaseFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TestCaseTest extends BaseTest {

  @Test
  public void testCreateNewTestCaseWithAllFields() {
    Project project = new ProjectFactory().newProject();
    TestCase newCase = new TestCaseFactory().newCase();
    loginPage
        .openLoginPage()
        .isPageOpened()
        .login(user, password)
        .clickAddProjectButton()
        .fillProjectFields(project)
        .clickAddProjectButton();
    dashboardPage.open()
        .openProject(project.getName())
        .clickTestCasesButton()
        .clickAddTestCasesButton()
        .isPageOpened()
        .fillInAllTestCaseFields(newCase)
        .clickAddTestCasesButton();
    Assert.assertEquals(testCaseDetailsPage.getSuccessMessage(),
        "Successfully added the new test case. Add another",
        "The notification is absent or incorrect");
  }

  @Test
  public void testEditTestCase() {
    Project project = new ProjectFactory().newProject();
    TestCase newCase = new TestCaseFactory().newCase();
    TestCase editCase = new TestCaseFactory().editedCase();
    loginPage
        .openLoginPage()
        .isPageOpened()
        .login(user, password)
        .clickAddProjectButton()
        .fillProjectFields(project)
        .clickAddProjectButton();
    dashboardPage.open()
        .openProject(project.getName())
        .clickTestCasesButton()
        .clickAddTestCasesButton()
        .isPageOpened()
        .fillInAllTestCaseFields(newCase)
        .clickAddTestCasesButton()
        .clickEditButton()
        .editSomeFields(editCase)
        .clickSaveTestCasesButton();
    Assert.assertEquals(testCaseDetailsPage.getSuccessMessage(),
        "Successfully updated the test case.");
  }

  @Test
  public void testDeleteTestCase() {
    Project project = new ProjectFactory().newProject();
    TestCase newCase = new TestCaseFactory().newCase();
    loginPage
        .openLoginPage()
        .isPageOpened()
        .login(user, password)
        .clickAddProjectButton()
        .fillProjectFields(project)
        .clickAddProjectButton();
    dashboardPage.open()
        .openProject(project.getName())
        .clickTestCasesButton()
        .clickAddTestCasesButton()
        .isPageOpened()
        .fillInAllTestCaseFields(newCase)
        .clickAddTestCasesButton()
        .clickTestCasesButton()
        .clickDeleteButton(newCase.getTitle())
        .clickMarkAsDeleteButton();
    Assert.assertTrue(testCasesOverviewPage.isTestCaseDeleted(newCase.getTitle()));
  }
}
