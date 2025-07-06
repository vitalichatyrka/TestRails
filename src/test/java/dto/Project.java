package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
  String name;
  String announcement;
}
