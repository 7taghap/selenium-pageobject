package pageobject.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.BasePage;
import pageobjects.SignInPage;


public class BasePageTest extends base.TestBaseSetup{
    
    private WebDriver driver;
    
    @BeforeClass
    public void setUp() {
        driver=getDriver();
    }
    
//    @Test
//    public void verifyHomePage() {
//        System.out.println("Home page test...");
//        BasePage basePage = new BasePage(driver);
//        Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
//    }
    @Test
    public void signIn() {
        System.out.println("Home page test...");
        BasePage basePage = new BasePage(driver);
        SignInPage signInPage = basePage.clickLogin();
        signInPage.enterUserName("admin");
        signInPage.enterPassword("admin");
        signInPage.clickOnSignIn();
        basePage = new BasePage(driver);
        Assert.assertTrue(basePage.verifyBasePageTitle());
    }

}