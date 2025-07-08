package api.models;

import lombok.Data;

@Data
public class CreateProjectResponse {

  private String name;
  private String announcement;
  private int id;
}
