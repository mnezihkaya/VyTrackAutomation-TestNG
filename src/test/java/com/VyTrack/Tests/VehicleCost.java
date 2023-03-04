package com.VyTrack.Tests;

import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VehicleCost extends TestBaseWithDataProvider {

    @Test(dataProvider = "DifferentUserTypes")
    public void testVehicleCostPagesPage(String username) {
        // Users should see three columns on the Vehicle Costs page.

        LogInPage.login(username);
        com.VyTrack.Pages.VehicleCostPage VehicleCostPage = new com.VyTrack.Pages.VehicleCostPage();
        MainPage mainPage = new MainPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());


        //navigate to FleetMenu
        wait.until(ExpectedConditions.visibilityOf(mainPage.fleet));
        actions.moveToElement(mainPage.fleet).perform();
        wait.until(ExpectedConditions.visibilityOf(mainPage.vehicleCosts));
        mainPage.vehicleCosts.click();

        // Validate if users see three columns on the Vehicle Costs page. TYPE, TOTAL PRICE, DATE
        wait.until(ExpectedConditions.visibilityOfAllElements(VehicleCostPage.headers));
        List<String> expectedColumnNames = new ArrayList<>(Arrays.asList("TYPE", "TOTAL PRICE", "DATE"));

        //create a new Arraylist for expected ColumnNames
        List<String> actualColumnNames = new ArrayList<>();

        for (WebElement each : VehicleCostPage.headers) {
            actualColumnNames.add(each.getText());
        }
        Assert.assertEquals(actualColumnNames, expectedColumnNames);

    }

    @Test(dataProvider = "managers")
    public void testVehicleCostPagePageCheckboxes(String username) {
        LogInPage.login(username);
        com.VyTrack.Pages.VehicleCostPage VehicleCostPage = new com.VyTrack.Pages.VehicleCostPage();
        MainPage mainPage = new MainPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());


        //navigate to FleetMenu
        wait.until(ExpectedConditions.visibilityOf(mainPage.fleet));
        actions.moveToElement(mainPage.fleet).perform();
        wait.until(ExpectedConditions.visibilityOf(mainPage.vehicleCosts));
        mainPage.vehicleCosts.click();

        // Validate users check the first checkbox to check all the Vehicle Costs
        // Click first CheckBox to select all checkboxes
        wait.until(ExpectedConditions.visibilityOf(VehicleCostPage.firstCheckBox));
        VehicleCostPage.firstCheckBox.click();

        for (WebElement each : VehicleCostPage.allCheckBoxes) {
            Assert.assertTrue(each.isSelected());
        }
        // Click first CheckBox to deselect all checkboxes
        VehicleCostPage.firstCheckBox.click();

        // Validate if all other checkboxes are de-selected
        for (WebElement each : VehicleCostPage.allCheckBoxes) {
            Assert.assertFalse(each.isSelected());
        }


    }

    @Test(dataProvider = "DifferentUserTypes")
    public void testVehicleCostPagePageFilters(String username) {
        // users should be able to use table filters

        LogInPage.login(username);
        com.VyTrack.Pages.VehicleCostPage VehicleCostPage = new com.VyTrack.Pages.VehicleCostPage();
        MainPage mainPage = new MainPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());


        //navigate to FleetMenu
        wait.until(ExpectedConditions.visibilityOf(mainPage.fleet));
        actions.moveToElement(mainPage.fleet).perform();
        wait.until(ExpectedConditions.visibilityOf(mainPage.vehicleCosts));
        mainPage.vehicleCosts.click();

        //Validate Filter by Date is working
        String oldValue = VehicleCostPage.date.getText();
        VehicleCostPage.filterDate.click();
        String newValue = VehicleCostPage.date.getText();
        Assert.assertNotEquals(oldValue, newValue);

        //  Validate Filter by Type is working
        oldValue = VehicleCostPage.type.getText();
        VehicleCostPage.filterType.click();
        newValue = VehicleCostPage.type.getText();
        Assert.assertNotEquals(oldValue, newValue);

        //  Validate second Filter by Price is working
        oldValue = VehicleCostPage.totalPrice.getText();
        VehicleCostPage.filterTotalPrice.click();
        newValue = VehicleCostPage.totalPrice.getText();
        Assert.assertNotEquals(oldValue, newValue);
    }


}


