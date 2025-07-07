package adapters;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

public class BaseAdapter {

  public static final String BASE_API_URL =
      System.getenv().getOrDefault("apiURL", PropertyReader.getProperty("apiURL"));
  RequestSpecification request;

  public BaseAdapter() {
    request = given()
        .contentType(ContentType.JSON)
        .auth().preemptive()
        .basic(
            System.getProperty("testrailUser", PropertyReader.getProperty("user")),
            System.getProperty("testrailPassword", PropertyReader.getProperty("password"))
        )
        .log().all();
  }
}
