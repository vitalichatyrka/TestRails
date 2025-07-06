package pages;

import static com.codeborne.selenide.Selenide.$;

import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AddProjectPage extends BasePage {

  private final String PROJECT_NAME_ID = "#name",
      ANNOUNCEMENT_ID = "#announcement_display",
      ADD_PROJECT_BUTTON_ID = "#accept";

  @Step("Filling project name field")
  public AddProjectPage fillProjectFields(Project project) {
    log.info("Project fields is filling with " +
        "Name = '{}', Announcement = '{}'", project.getName(), project.getAnnouncement());
    $(PROJECT_NAME_ID).sendKeys(project.getName());
    $(ANNOUNCEMENT_ID).sendKeys(project.getAnnouncement());
    return this;
  }

  @Step("Click to 'ADD Project' button")
  public ProjectsPage clickAddProjectButton() {
    log.info("Clicking 'ADD Project' button");
    $(ADD_PROJECT_BUTTON_ID).click();
    return new ProjectsPage();
  }
}
