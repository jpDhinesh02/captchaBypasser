package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fieldValidations {
  private WebDriver driver;
  fieldValidations object = new fieldValidations(driver);

  public fieldValidations(WebDriver driver) {
    this.driver = driver;
    object.reportInitiate();
  }

  public void reportInitiate() {
    extentReports.initalizeExtent("field validations");
  }

  public void checkPlaceholder(WebElement element, String placeholderText, String fieldName) throws Exception {
    String actualText = element.getAttribute("placeholder");
    if (placeholderText.equals(actualText)) {
      extentReports.logPass(fieldName + " Placeholder text matched Testcase1");
    } else {
      extentReports.takeScreenShot(driver, "field validations Testcase1");
      extentReports.logFail(driver,fieldName,fieldName + " Placeholder text not matched Testcase1");
    }
  }

  public void checkMaxlenght(WebElement element, String maxLenght, String fieldName) throws Exception {
    String actualText = element.getAttribute("maxlength");
    if (maxLenght.equals(actualText)) {
      extentReports.logPass(fieldName + " Maxlenght value matched Testcase2");
    } else {
      extentReports.takeScreenShot(driver, "field validations Testcase2");
      extentReports.logFail(driver,fieldName,fieldName + " Maxlenght value not matched Testcase2");
    }
  }

  public void checkTextfiled(WebElement element, String fieldName) throws Exception {
    String actualText = element.getAttribute("type");
    if (actualText.equals("text")) {
      extentReports.logPass(fieldName + "  is a text field Testcase3");
    } else {
      extentReports.takeScreenShot(driver, "field validations Testcase3");
      extentReports.logFail(driver,fieldName,fieldName + "  is not a text field Testcase3");
    }
  }

  public void checkContactfiled(WebElement element, String fieldName) throws Exception {
    String actualText = element.getAttribute("type");
    if (actualText.equals("tel")) {
      extentReports.logPass(fieldName + "  is a contact no field Testcase4");
    } else {
      extentReports.takeScreenShot(driver, "field validations Testcase4");
      extentReports.logFail(driver,fieldName,fieldName + "  is not a contact no field Testcase4");
    }
  }

  public void checkEmailfiled(WebElement element, String fieldName) throws Exception {
    String actualText = element.getAttribute("type");
    if (actualText.equals("email")) {
      extentReports.logPass(fieldName + "  is a contact no field TestCase5");
    } else {
      extentReports.takeScreenShot(driver, "field validations TestCase5");
      extentReports.logFail(driver,fieldName,fieldName + "  is not a contact no field TestCase5");
    }
  }

  public void isDisabled(WebElement element, String fieldName) throws Exception {
    boolean isDisabled = !element.isEnabled();
    if (isDisabled) {
      extentReports.logPass(fieldName + "  button is disabled Testcase6");
    } else {
      extentReports.takeScreenShot(driver, "field validations Testcase6");
      extentReports.logFail(driver,fieldName,fieldName + "  button is not disabled Testcase6");
    }
  }

  public void isEnabled(WebElement element, String fieldName) throws Exception {
    boolean isEnabled = element.isEnabled();
    if (isEnabled) {
      extentReports.logPass(fieldName + "  button is enabled Testcase7");
    } else {
      extentReports.takeScreenShot(driver, "field validations Testcase7");
      extentReports.logFail(driver,fieldName,fieldName + "  button is not disabled Testcase7");
    }
  }

  public void emptyCheck(WebElement element, String fieldName, WebElement buttonElement) throws Exception {
    buttonElement.click();
    String styleValue = element.getAttribute("style");
    if (styleValue.contains("border: 1px solid red")) {
      extentReports.logPass(fieldName + " field didn't accept empty Testcase8");
    } else {
      extentReports.takeScreenShot(driver, "field validations Testcase8");
      extentReports.logFail(driver,fieldName,fieldName + "  field accept empty Testcase8");
    }
  }

  public void invalidCheck(WebElement element, String fieldName, String invalidText, WebElement buttonElement)
      throws Exception {
    element.sendKeys(invalidText);
    buttonElement.click();
    String styleValue = element.getAttribute("style");
    if (styleValue.contains("border: 1px solid red")) {
      extentReports.logPass(fieldName + " field didn't accept invalid value Testcase9");
    } else {
      extentReports.takeScreenShot(driver, "field validations Testcase9");
      extentReports.logFail(driver,fieldName,fieldName + "  field accept invalid value Testcase9");
    }
    element.clear();
  }

}
