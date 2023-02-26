package com.VyTrack.Pages;

import com.VyTrack.Utilities.ConfigurationReader;
import com.VyTrack.Utilities.Driver;
import com.VyTrack.Utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {

    private static final String userName = ConfigurationReader.getProperty("username2");
    private static final String passWord = ConfigurationReader.getProperty("password");

    public LogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement logInButton;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeButton;

    @FindBy(xpath = "//a[@href='/user/reset-request']")
    public WebElement forgotYourPassword;

    @FindBy(xpath = "//a[@href='/user/logout']")
    public WebElement logOut;


    //overwrite Login method with different
    public static void login() {
        // Calling webElements from Login Page
        LogInPage loginPage = new LogInPage();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        // Enter valid username
        wait.until(ExpectedConditions.visibilityOf(loginPage.username));
        loginPage.username.clear();
        loginPage.username.sendKeys(userName);

        // Enter valid password
        wait.until(ExpectedConditions.visibilityOf(loginPage.password));
        loginPage.password.clear();
        loginPage.password.sendKeys(passWord);
        ;

        // Click to Log In button
        wait.until(ExpectedConditions.visibilityOf(loginPage.logInButton));
        loginPage.logInButton.click();

        // Verify login successful

    }

    public static void login(String username) {
        // Calling webElements from Login Page
        LogInPage loginPage = new LogInPage();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        // Enter valid username
        wait.until(ExpectedConditions.visibilityOf(loginPage.username));
        loginPage.username.clear();
        loginPage.username.sendKeys(username);

        // Enter valid password
        wait.until(ExpectedConditions.visibilityOf(loginPage.password));
        loginPage.password.clear();
        loginPage.password.sendKeys(passWord);
        ;

        // Click to Log In button
        wait.until(ExpectedConditions.visibilityOf(loginPage.logInButton));
        loginPage.logInButton.click();

        // Verify login successful

    }

    public static void LogIn(String username, String password) {

        LogInPage logInpage = new LogInPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(logInpage.username));
        //enter valid username
        logInpage.username.clear();
        logInpage.username.sendKeys(username);
        //enter valid password
        wait.until(ExpectedConditions.visibilityOf(logInpage.password));
        logInpage.password.clear();
        logInpage.password.sendKeys(password);

        //click to login Button
        wait.until(ExpectedConditions.visibilityOf(logInpage.logInButton));
        logInpage.logInButton.click();
        //verify login is successful
    }


}
