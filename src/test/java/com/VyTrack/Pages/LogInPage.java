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

    public LogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement LogInButton;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement RememberMeButton;

    @FindBy(xpath = "//a[@href='/user/reset-request']")
    public WebElement ForgotYourPassword;


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
        wait.until(ExpectedConditions.visibilityOf(logInpage.LogInButton));
        logInpage.LogInButton.click();
        //verify login is successful
    }
}
