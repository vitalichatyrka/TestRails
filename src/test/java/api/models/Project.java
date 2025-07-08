package api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

  @SerializedName("name")
  @Expose
  String name;
  @SerializedName("announcement")
  @Expose
  String announcement;
}
