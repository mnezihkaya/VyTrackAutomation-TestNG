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
    @FindBy (xpath = "//h1//a[@title='Fleet Management']") public WebElement homeButton;
    @FindBy (xpath = "//div/a[@href='/pinbar/help']") public WebElement pinBarHelp;

    // Top right icons
    @FindBy (xpath = "//a[@class='help no-hash']") public WebElement getHelpIcon;

    // Warning Message
    @FindBy (xpath = "//div[@class='message']") public WebElement warningMessage;

    // Warning message close button
    @FindBy (xpath = "//button[@class='close']") public WebElement warningCloseBtn;
    //Main Menu webElements
    @FindBy(xpath = "//span[@class='title title-level-1']")
    public List<WebElement> allModules;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement DashBoards;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement Fleet;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[3]")
    public WebElement Customers;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[4]")
    public WebElement Sales;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[5]")
    public WebElement Activities;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[6]")
    public WebElement Marketing;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[7]")
    public WebElement ReportsAndSegments;
    @FindBy(xpath = "(//span[@class='title title-level-1'])[8]")
    public WebElement Systems;


    //Dashboards sub webElements
    @FindBy(xpath = "//span[text()=\"Dashboard\"]")
    public WebElement Dashboard;
    @FindBy(xpath = "//span[text()=\"Manage Dashboards\"]")
    public WebElement ManageDashboards;

    // Fleet sub webElements
    @FindBy(xpath = "//span[text()=\"Vehicles\"]")
    public WebElement Vehicles;
    @FindBy(xpath = "//span[text()=\"Vehicle Odometer\"]")
    public WebElement VehicleOdometer;
    @FindBy(xpath = "//span[text()=\"Vehicle Costs\"]")
    public WebElement VehicleCosts;
    @FindBy(xpath = "//span[text()=\"Vehicle Contracts\"]")
    public WebElement VehicleContracts;
    @FindBy(xpath = "//span[text()=\"Vehicles Fuel Logs\"]")
    public WebElement VehiclesFuelLogs;
    @FindBy(xpath = "//span[text()=\"Vehicle Services Logs\"]")
    public WebElement VehicleServicesLogs;
    @FindBy(xpath = "//span[text()=\"Vehicles Model\"]")
    public WebElement VehiclesModel;

    // Activities sub elements
    @FindBy (xpath = "//span[text()='Calendar Events']") public WebElement activitiesSubCalendar;

    // Customers sub elements
    @FindBy (xpath = "//span[text()='Accounts']") public WebElement customersSubAccounts;

    // Marketing sub elements
    @FindBy (xpath = "//span[text()='Campaigns']") public WebElement marketingSubCampaigns;


























































































































































}
