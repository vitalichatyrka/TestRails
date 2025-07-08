package api.adapters;

import static io.restassured.RestAssured.given;
import static pages.BasePage.CREATE_PROJECT_ENDPOINT;
import static pages.BasePage.DELETE_PROJECT_ENDPOINT;
import static pages.BasePage.GET_PROJECTS_ENDPOINT;
import static pages.BasePage.GET_PROJECT_ENDPOINT;

import api.models.CreateProjectResponse;
import api.models.GetAllProjectsResponse;
import api.models.Project;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.PropertyReader;

public class ProjectsAdapter extends BaseAdapter {

  private static final Gson gson = new Gson();

  public ProjectsAdapter() {
    super();
  }

  public CreateProjectResponse createNewProject(Project project) {
    String jsonBody = gson.toJson(project);

    Response response = given()
        .contentType(ContentType.JSON)
        .auth().preemptive()
        .basic(
            System.getProperty("testrailUser", PropertyReader.getProperty("user")),
            System.getProperty("testrailPassword", PropertyReader.getProperty("password"))
        )
        .body(jsonBody)
        .when()
        .post(BASE_API_URL + CREATE_PROJECT_ENDPOINT)
        .then()
        .log().ifValidationFails()
        .statusCode(200)
        .extract().response();

    return gson.fromJson(response.asString(), CreateProjectResponse.class);
  }

  public GetAllProjectsResponse getAllProjects() {
    Response response = given()
        .contentType(ContentType.JSON)
        .auth().preemptive()
        .basic(
            System.getProperty("testrailUser", PropertyReader.getProperty("user")),
            System.getProperty("testrailPassword", PropertyReader.getProperty("password"))
        )
        .when()
        .get(BASE_API_URL + GET_PROJECTS_ENDPOINT)
        .then()
        .log().ifValidationFails()
        .statusCode(200)
        .extract().response();
    return gson.fromJson(response.asString(), GetAllProjectsResponse.class);
  }

  public Response getProjectById(int projectId) {
    return given()
        .contentType(ContentType.JSON)
        .auth().preemptive()
        .basic(
            System.getProperty("testrailUser", PropertyReader.getProperty("user")),
            System.getProperty("testrailPassword", PropertyReader.getProperty("password"))
        )
        .when()
        .get(BASE_API_URL + GET_PROJECT_ENDPOINT + projectId)
        .then()
        .log().ifValidationFails()
        .extract().response();
  }

  public Response deleteProject(int idOfProject) {
    Response response = given()
        .contentType(ContentType.JSON)
        .auth().preemptive()
        .basic(
            System.getProperty("testrailUser", PropertyReader.getProperty("user")),
            System.getProperty("testrailPassword", PropertyReader.getProperty("password"))
        )
        .when()
        .post(BASE_API_URL + DELETE_PROJECT_ENDPOINT + idOfProject)
        .then()
        .log().ifValidationFails()
        .statusCode(200)
        .extract().response();

    return gson.fromJson(response.asString(), Response.class);
  }
}
