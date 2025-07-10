package api.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GetAllProjectsResponse {
  @SerializedName("projects")
  private List<Project> projects;
}
