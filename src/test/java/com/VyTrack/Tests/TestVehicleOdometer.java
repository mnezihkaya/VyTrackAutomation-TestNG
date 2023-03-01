package com.VyTrack.Tests;

import com.VyTrack.Pages.Calender;
import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import com.VyTrack.Pages.VehicleOdometer;
import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVehicleOdometer extends TestBaseWithDataProvider {

    @Test(dataProvider = "managers")
    public void testOdometer(String username) {

        // Store and Sales managers should see an error message
        // “You do not have permission to perform this action.”
        // when they click the “Vehicle Odometer” module.

        LogInPage.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainpage = new MainPage();

        //check if there is any displayed,if yes close it
        if (mainpage.warningMessage.isDisplayed()) {
            mainpage.warningMessage.click();
        }
        //  Navigate over Fleet link
        wait.until(ExpectedConditions.visibilityOf(mainpage.fleet));
        actions.moveToElement(mainpage.fleet).perform();

        //  Select and click Vehicle Odometer page
        wait.until(ExpectedConditions.visibilityOf(mainpage.vehicleOdometer));
        mainpage.vehicleOdometer.click();


        // Validate Store and Sales managers should see an error message
        String actualWarning = mainpage.warningMessage.getText();
        String expectedWarning = "You do not have permission to perform this action.";
        Assert.assertEquals(actualWarning, expectedWarning);
    }

    @Test(dataProvider = "drivers")
    public void testVehicleOdometerDrivers(String username) {
        //  Drivers should see the default page as 1.
        //  Divers should see the View Per Page is 25 by default.
        LogInPage.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainpage = new MainPage();
        VehicleOdometer vehicleOdometer = new VehicleOdometer();


        //  Navigate over Fleet link
        wait.until(ExpectedConditions.visibilityOf(mainpage.fleet));
        actions.moveToElement(mainpage.fleet).perform();

        //  Select and click Vehicle Odometer page
        wait.until(ExpectedConditions.visibilityOf(mainpage.vehicleOdometer));
        mainpage.vehicleOdometer.click();
        // Wait till last cell is loaded
        wait.until(ExpectedConditions.visibilityOf(vehicleOdometer.lastCell));

        // Validate Drivers should see the default page as 1.
        String actual = vehicleOdometer.pageNumber.getAttribute("value");
        String expected = "1";
        Assert.assertEquals(actual, expected);

        // Validate Divers should see the View Per Page is 25 by default.
        actual = vehicleOdometer.viewPage.getText();
        expected = "25";
        Assert.assertEquals(actual, expected);

    }
}


