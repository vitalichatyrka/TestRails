package wrappers;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;

public class TextInput {
  String label;
  String textBoxLocator = ".//label[@for='%s']/following-sibling::textarea";

  public TextInput(String label) {
    this.label = label;
  }

  public void enterSomeTextToTextInput(String someText) {
    $x(String.format(textBoxLocator, label)).shouldBe(Condition.visible).sendKeys(someText);
  }
}
