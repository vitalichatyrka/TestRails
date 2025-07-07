package tests.api;

import dto.Project;
import dto.ProjectFactory;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import tests.BaseTest;

@Log4j2
public class ProjectsTest extends BaseTest {

  @Test(description = "Get all projects")
  public void testGetAllProjects() {
    projectsAdapter.getAllProjects();
  }

  @Test(description = "Create new project")
  public void testCreateNewProject() {
    Project project = new ProjectFactory().newProject();
    projectsAdapter.createNewProject(project);
  }

  @Test(description = "Delete project")
  public void testDeleteProject() {
    Project project = new ProjectFactory().newProject();
    Response createResponse = projectsAdapter.createNewProject(project);
    projectsAdapter.deleteProject(String.valueOf(createResponse.jsonPath().getInt("id")));
  }

}
