package dto;

import com.github.javafaker.Faker;

public class TestCaseFactory {
  Faker faker = new Faker();
  public String title = faker.harryPotter().character();
  public String preconditions = faker.hitchhikersGuideToTheGalaxy().marvinQuote();
  public String steps = faker.beer().name();
  public String expectedResult = faker.artist().name();

  public TestCase newCase() {
    return TestCase.builder()
        .title(title)
        .section("Test Cases")
        .template("Test Case (Text)")
        .type("Functional")
        .priority("High")
        .assignedTo("None")
        .estimate("15 min")
        .references("AQA-12345")
        .automationType(" None")
        .preconditions(preconditions)
        .steps(steps)
        .expectedResult(expectedResult)
        .build();
  }

  public TestCase editedCase() {
    return TestCase.builder()
        .steps(faker.backToTheFuture().quote())
        .priority("Low")
        .preconditions(faker.gameOfThrones().house())
        .build();
  }
}
