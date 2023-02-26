package com.VyTrack.Pages;

import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // HomeButton
    @FindBy(xpath = "//h1//a[@title='Fleet Management']")
    public WebElement homeButton;
    @FindBy(xpath = "//div/a[@href='/pinbar/help']")
    public WebElement pinBarHelp;

    // Top right icons
    @FindBy(xpath = "//a[@class='help no-hash']")
    public WebElement getHelpIcon;

    // Warning Message
    @FindBy(xpath = "//div[@class='message']")
    public WebElement warningMessage;

    // Warning message close button
    @FindBy(xpath = "//button[@class='close']")
    public WebElement warningCloseBtn;
    //Main Menu webElements
    @FindBy(xpath = "//span[@class='title title-level-1']")
    public List<WebElement> allModules;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement dashBoards;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement fleet;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[3]")
    public WebElement customers;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[4]")
    public WebElement sales;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[5]")
    public WebElement activities;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[6]")
    public WebElement marketing;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[7]")
    public WebElement reportsAndSegments;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[8]")
    public WebElement systems;


    //Dashboards sub webElements
    @FindBy(xpath = "//span[text()=\"Dashboard\"]")
    public WebElement dashboard;
    @FindBy(xpath = "//span[text()=\"Manage Dashboards\"]")
    public WebElement manageDashboards;

    // Fleet sub webElements
    @FindBy(xpath = "//span[text()=\"Vehicles\"]")
    public WebElement vehicles;
    @FindBy(xpath = "//span[text()=\"Vehicle Odometer\"]")
    public WebElement vehicleOdometer;
    @FindBy(xpath = "//span[text()=\"Vehicle Costs\"]")
    public WebElement vehicleCosts;
    @FindBy(xpath = "//span[text()=\"Vehicle Contracts\"]")
    public WebElement vehicleContracts;
    @FindBy(xpath = "//span[text()=\"Vehicles Fuel Logs\"]")
    public WebElement vehiclesFuelLogs;
    @FindBy(xpath = "//span[text()=\"Vehicle Services Logs\"]")
    public WebElement vehicleServicesLogs;
    @FindBy(xpath = "//span[text()=\"Vehicles Model\"]")
    public WebElement vehiclesModel;

    // Activities sub elements
    @FindBy(xpath = "//span[text()='Calendar Events']")
    public WebElement activitiesSubCalendar;

    // Customers sub elements
    @FindBy(xpath = "//span[text()='Accounts']")
    public WebElement customersSubAccounts;

    // Marketing sub elements
    @FindBy(xpath = "//span[text()='Campaigns']")
    public WebElement marketingSubCampaigns;


}
