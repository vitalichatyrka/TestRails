package dto;

// import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestCase {

  String title;
  String section;
  String template;
  String type;
  String priority;
  String assignedTo;
  String estimate;
  String references;
  String automationType;
  String preconditions;
  String steps;
  String expectedResult;
}
