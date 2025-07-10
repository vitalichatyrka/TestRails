package api.helpers;

import java.util.List;

import api.adapters.ProjectsAdapter;
import api.models.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProjectCleaner {

  private final ProjectsAdapter projectsAdapter = new ProjectsAdapter();

  @Step("Delete all projects in Test Rails")
  public void deleteAllProjects() {
    log.info("Deleting all Projects");
    List<Project> allProjects = projectsAdapter.getAllProjects().getProjects();

    for (Project project : allProjects) {
      if (project.getId() != 0) {
        projectsAdapter.deleteProject(project.getId());
      } else {
        System.out.println("Project " + project.getName() + " has null id, skipping deletion.");
      }
    }
  }
}