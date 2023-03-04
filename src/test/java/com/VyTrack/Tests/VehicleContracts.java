package com.VyTrack.Tests;

import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import com.VyTrack.Pages.VehicleContractPage;
import com.VyTrack.Utilities.Driver;
import com.VyTrack.Utilities.Utilities;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleContracts extends TestBaseWithDataProvider {

    //Store managers and Sales managers access the Vehicle contracts page.
    //Expected URL: https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract
    //Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System.

    @Test(dataProvider = "managers")
    public void VehicleContractsManager(String username) {

        LogInPage.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainPage = new MainPage();
        VehicleContractPage vehicleContract = new VehicleContractPage();


        //go to vehicle ContractsPage
        wait.until(ExpectedConditions.visibilityOf(mainPage.fleet));
        actions.moveToElement(mainPage.fleet).perform();
        wait.until(ExpectedConditions.visibilityOf(mainPage.vehicleContracts));
        mainPage.vehicleContracts.click();

        //validate Title
        wait.until(ExpectedConditions.visibilityOf(vehicleContract.tableCell));
        Utilities.sleep(1);
        Utilities.verifyTitle("All - Vehicle Contract - Entities - System - Car - Entities - System");


    }

    @Test(dataProvider = "drivers")
    public void VehicleContractsDrivers(String username) {
        //  Drivers should NOT able to access the Vehicle contracts page, the app should display
        // do not have permission to perform this action.

        LogInPage.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainPage = new MainPage();


        //go to vehicle ContractsPage
        wait.until(ExpectedConditions.visibilityOf(mainPage.fleet));
        actions.moveToElement(mainPage.fleet).perform();
        wait.until(ExpectedConditions.visibilityOf(mainPage.vehicleContracts));
        mainPage.vehicleContracts.click();

        //validate Drivers see the error message
        Assert.assertTrue(mainPage.warningMessage.isDisplayed());
        String actualMessage = mainPage.warningMessage.getText();
        String expectedMessage = "You do not have permission to perform this action.";
        Assert.assertEquals(actualMessage, expectedMessage);


    }
}
