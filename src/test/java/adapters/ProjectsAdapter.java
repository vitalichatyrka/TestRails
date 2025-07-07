package adapters;

import dto.Project;
import io.restassured.response.Response;

public class ProjectsAdapter extends BaseAdapter {

  public Response createNewProject(Project project) {
    Response response = request.
        body(project).
        when().
        post(BASE_API_URL + "index.php?/api/v2/add_project").
        then().
        log().ifValidationFails().
        statusCode(200)
        .extract().response();
    return response;
  }

  public void getAllProjects() {
    request.
        when().
        get(BASE_API_URL + "index.php?/api/v2/get_projects").
        then().
        log().ifValidationFails().
        statusCode(200);
  }

  public void deleteProject(String code) {
    request.
        when().
        post(BASE_API_URL + "index.php?/api/v2/delete_project/" + code).
        then().
        log().ifValidationFails().
        statusCode(200);
  }

}
