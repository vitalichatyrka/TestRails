package api.models;

import com.github.javafaker.Faker;

public class ProjectFactory {

  Faker faker = new Faker();
  public String projectName = faker.company().name();
  public String announcement = faker.animal().name();

  public Project newProject() {
    return Project.builder()
        .name(projectName)
        .announcement(announcement)
        .build();
  }
}
