package pages;

public abstract class BasePage {

  public static final String DELETE_PROJECT_ENDPOINT = "index.php?/api/v2/delete_project/",
      GET_PROJECTS_ENDPOINT = "index.php?/api/v2/get_projects",
      CREATE_PROJECT_ENDPOINT = "index.php?/api/v2/add_project",
      DASHBOARD_URL = "index.php?/dashboard",
      PROJECTS_URL = "/index.php?/admin/projects/overview",
      GET_PROJECT_ENDPOINT = "index.php?/api/v2/get_project/";

  public BasePage() {

  }
}
