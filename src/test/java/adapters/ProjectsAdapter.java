package adapters;

import static pages.BasePage.CREATE_PROJECT_ENDPOINT;
import static pages.BasePage.DELETE_PROJECT_ENDPOINT;
import static pages.BasePage.GET_PROJECTS_ENDPOINT;

import dto.Project;
import io.restassured.response.Response;

public class ProjectsAdapter extends BaseAdapter {

  public Response createNewProject(Project project) {
    Response response = request.
        body(project).
        when().
        post(BASE_API_URL + CREATE_PROJECT_ENDPOINT).
        then().
        log().ifValidationFails().
        statusCode(200)
        .extract().response();
    return response;
  }

  public void getAllProjects() {
    request.
        when().
        get(BASE_API_URL + GET_PROJECTS_ENDPOINT).
        then().
        log().ifValidationFails().
        statusCode(200);
  }

  public void deleteProject(String idOfProject) {
    request.
        when().
        post(BASE_API_URL + DELETE_PROJECT_ENDPOINT + idOfProject).
        then().
        log().ifValidationFails().
        statusCode(200);
  }
}
