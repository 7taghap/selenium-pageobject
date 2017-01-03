package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    private By signInButton = By.linkText("Sign in");
    private By loginLink = By.id("logout_span");
    private By username = By.id("username");
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public SignInPage clickLogin() {
      System.out.println("clicking on sign in button");
      WebElement signInBtnElement=driver.findElement(loginLink);
      if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
          signInBtnElement.click();
      else System.out.println("Element not found");
      return new SignInPage(driver);
  }
    
    public SignInPage clickSignInBtn() {
        System.out.println("clicking on sign in button");
        WebElement signInBtnElement=driver.findElement(signInButton);
        if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
            signInBtnElement.click();
        else System.out.println("Element not found");
        return new SignInPage(driver);
    }
    
    public void clickImagesLink() {
        //It should have a logic to click on images link
        //And it should navigate to google images page
    }
    
    public String getPageTitle(){
        String title = driver.getTitle();
        return title;
    }
    
    public String getLoginUser() {
      WebElement user = driver.findElement(username);
      String pageTitle = "Not Found";
      if (user.isDisplayed() || user.isEnabled()) {
        pageTitle = user.getText();
      }
      
      System.out.println("Login user : " + pageTitle);
      return pageTitle;
    }
    
    public boolean verifyBasePageTitle() {
        String expectedPageTitle="admin";
        
        return getLoginUser().contains(expectedPageTitle);
    }
}
