package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

  private WebDriver driver;

  private By logout_span = By.id("logout_span");
  private By login_button = By.id("pop_login");
  // private By createAccountLink = By.id("link-signup");

  private By username = By.id("username");
  private By emailTextBox = By.id("password");
  private By passwordTextBox = By.id("password");
  private By loginBtn = By.id("signIn");
  private By errorMsgTxt = By.id("errormsg_0_Passwd");

  public SignInPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getSignInPageTitle() {
    WebElement user = driver.findElement(username);
    String pageTitle = user.getText();
    System.out.println(pageTitle);
    return pageTitle;
  }


  // public CreateAccountPage clickonCreateAnAccount() {
  // WebElement element = driver.findElement(createAccountLink);
  // if (element.isDisplayed() || element.isEnabled())
  // element.click();
  // return new CreateAccountPage(driver);
  // }

  // public boolean verifySignIn() {
  // enterUserName("test");
  // enterPassword("pass");
  // clickOnSignIn();
  // return getErrorMessage().contains("incorrect");
  // }

  public void enterUserName(String userName) {
    WebElement emailTxtBox = driver.findElement(username);
    if (emailTxtBox.isDisplayed())
      emailTxtBox.sendKeys(userName);
  }

  public void enterPassword(String password) {
    WebElement passwordTxtBox = driver.findElement(passwordTextBox);
    if (passwordTxtBox.isDisplayed())
      passwordTxtBox.sendKeys(password);
  }

  public void clickOnSignIn() {
    WebElement signInBtn = driver.findElement(login_button);
    if (signInBtn.isDisplayed())
      signInBtn.click();
  }

  public String getErrorMessage() {
    String strErrorMsg = null;
    WebElement errorMsg = driver.findElement(errorMsgTxt);
    if (errorMsg.isDisplayed() && errorMsg.isEnabled())
      strErrorMsg = errorMsg.getText();
    return strErrorMsg;
  }

  public boolean verifySignInUser() {
    String expectedPageTitle = "admin";
    return getSignInPageTitle().contains(expectedPageTitle);
  }
}
