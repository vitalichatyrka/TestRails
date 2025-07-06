package wrappers;

import static com.codeborne.selenide.Selenide.$$x;

import com.codeborne.selenide.Condition;

public class DropDown {
  String label;
  String dropDownLocator = ".//label[@for='%s']/following-sibling::div";
  String optionLocator = "//ul[contains(@class,'chosen-results')]//li[contains(text(), '%s')]";

  public DropDown(String label) {
    this.label = label;
  }

  public void selectValueInDropdown(String option) {
    $$x(String.format(dropDownLocator, label, label)).filter(Condition.visible).first().click();
    $$x(String.format(optionLocator, option)).filter(Condition.visible).first().click();
  }
}

