package com.VyTrack.Tests;

import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import com.VyTrack.Pages.VehicleModel;
import com.VyTrack.Utilities.Driver;
import com.VyTrack.Utilities.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VehicleModelsDisplay extends TestBaseWithDataProvider {
    //AC #1: The store manager and sales manager should see 10 columns on the Vehicle Model page.
    //Expected Column names:
    //MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED),
    //TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS

    @Test(dataProvider = "managers")
    public void DisplaysHeader(String username) {

        LogInPage.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        MainPage mainPage = new MainPage();
        VehicleModel vehicleModel = new VehicleModel();
        Actions actions = new Actions(Driver.getDriver());

        //navigate to vehicle model page.
        wait.until(ExpectedConditions.visibilityOf(mainPage.fleet));
        actions.moveToElement(mainPage.fleet).perform();
        wait.until(ExpectedConditions.visibilityOf(mainPage.vehiclesModel));
        mainPage.vehiclesModel.click();

        //validate the page
        wait.until(ExpectedConditions.titleIs("All - Vehicles Model - Entities - System - Car - Entities - System"));
        Utilities.verifyTitle("All - Vehicles Model - Entities - System - Car - Entities - System");

        //  expected headlines:
        //  MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED),
        //  TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS

        List<String> expectedHeadlines = new ArrayList<>(Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED",
                "CVVI", "CO2 FEE (/MONTH)", "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS", "FUEL TYPE", "VENDORS"));

        List<String> actualHeadlines = new ArrayList<>();

        for (WebElement each : vehicleModel.allHeaders) {
            actualHeadlines.add(each.getText());
        }
        Assert.assertEquals(actualHeadlines.size(), 10);
        Assert.assertEquals(actualHeadlines, expectedHeadlines);

    }

    @Test(dataProvider = "drivers")
    public void testDriversVehicleModels(String username) {
        // AC #2: Drivers should not able to access the Vehicle Model page, users should see
        // “You do not have permission to perform this action.”
        LogInPage.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainpage = new MainPage();

        // Check if there is  any warning displayed, if yes close it
        if (mainpage.warningCloseBtn.isDisplayed()) mainpage.warningCloseBtn.click();

        // 1. Navigate over Fleet link
        wait.until(ExpectedConditions.visibilityOf(mainpage.fleet));
        Assert.assertTrue(mainpage.fleet.isDisplayed());
        actions.moveToElement(mainpage.fleet).perform();

        // 2. Select and click Vehicle Model page
        wait.until(ExpectedConditions.visibilityOf(mainpage.vehiclesModel));
        Assert.assertTrue(mainpage.vehiclesModel.isDisplayed());
        mainpage.vehiclesModel.click();

        // 3. Drivers should not able to access the Vehicle Model page, users should see
        //    “You do not have permission to perform this action.”

        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");

        String actualWarning = mainpage.warningMessage.getText();
        String expectedWarning = "You do not have permission to perform this action.";

        Assert.assertEquals(actualWarning, expectedWarning);

    }
}