package wrappers;

import static com.codeborne.selenide.Selenide.$$x;

import com.codeborne.selenide.Condition;

public class TextBox {
  String label;
  String textBoxLocator = "//label[contains(.,'%s')]/following-sibling::div//div[@role='textbox' or @role='input']";

  public TextBox(String label) {
    this.label = label;
  }

  public void enterSomeTextToTextArea(String someText) {
    $$x(String.format(textBoxLocator, label)).filter(Condition.visible).first().sendKeys(someText);
  }
}
