package tests.api;

import java.util.List;

import api.models.CreateProjectResponse;
import api.models.GetAllProjectsResponse;
import api.models.Project;
import api.models.ProjectFactory;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

@Log4j2
public class ProjectsTest extends BaseTest {

  @Test(description = "Get all projects")
  public void testGetAllProjects() {

    Project project1 = new ProjectFactory().newProject();
    projectsAdapter.createNewProject(project1);
    Project project2 = new ProjectFactory().newProject();
    projectsAdapter.createNewProject(project2);

    GetAllProjectsResponse response = projectsAdapter.getAllProjects();
    List<Project> allProjects = response.getProjects();

    softAssert.assertTrue(
        allProjects.stream().anyMatch(p -> p.getName().equals(project1.getName())),
        "Project 1 name is not present in the list");
    softAssert.assertTrue(
        allProjects.stream().anyMatch(p -> p.getName().equals(project2.getName())),
        "Project 2 name is not present in the list");
    softAssert.assertAll();
  }

  @Test(description = "Create new project")
  public void testCreateNewProject() {

    Project project = new ProjectFactory().newProject();
    CreateProjectResponse createdProjectResponse = projectsAdapter.createNewProject(project);
    softAssert.assertEquals(createdProjectResponse.getName(), project.getName(),
        "The name of created project is incorrect");
    softAssert.assertEquals(createdProjectResponse.getAnnouncement(), project.getAnnouncement(),
        "The announcement of created project is incorrect");
    softAssert.assertAll();
  }

  @Test(description = "Delete project")
  public void testDeleteProject() {

    Project project = new ProjectFactory().newProject();
    CreateProjectResponse createResponse = projectsAdapter.createNewProject(project);
    projectsAdapter.deleteProject(createResponse.getId());
    Response getProjectResponse = projectsAdapter.getProjectById(createResponse.getId());
    Assert.assertEquals(getProjectResponse.statusCode(), 400, "Expected 400 after deletion");
    Assert.assertTrue(
        getProjectResponse.asString().contains("Field :project_id is not a valid or accessible project."));
  }
}
