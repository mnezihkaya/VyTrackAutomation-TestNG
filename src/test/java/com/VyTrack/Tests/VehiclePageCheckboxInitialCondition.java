package com.VyTrack.Tests;

import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import com.VyTrack.Pages.VehiclePage;
import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehiclePageCheckboxInitialCondition extends TestBaseWithDataProvider {
    //once the user launched to the Vehicle page, all the checkboxes should be unchecked
    @Test(dataProvider = "managers")
    public void testVehicleIcons(String username) {

        LogInPage logInPage = new LogInPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainPage = new MainPage();
        VehiclePage vehiclePage = new VehiclePage();

        //navigate to vehiclePage
        LogInPage.login(username);
        wait.until(ExpectedConditions.visibilityOf(mainPage.fleet));
        actions.moveToElement(mainPage.fleet).perform();
        mainPage.vehicles.click();

        //check if the all checkboxes are unchecked
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.lastCell));
        for (WebElement each : vehiclePage.checkboxes) {
            Assert.assertTrue(each.isDisplayed());
            Assert.assertFalse(each.isSelected());
        }
    }

    //user check the first checkbox to check all the cars
    // users can select any car
    @Test(dataProvider = "managers")
    public void testVehicleCheckbox(String username) {

        LogInPage logInPage = new LogInPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainPage = new MainPage();
        VehiclePage vehiclePage = new VehiclePage();

        //navigate to vehiclePage
        LogInPage.login(username);
        wait.until(ExpectedConditions.visibilityOf(mainPage.fleet));
        actions.moveToElement(mainPage.fleet).perform();
        mainPage.vehicles.click();
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.lastCell));

        //click first checkbox
        vehiclePage.FirstCheckBox.click();

        //validate if allOther check boxes selected when the first was selected

        for (WebElement each : vehiclePage.carCheckboxes) {
            Assert.assertTrue(each.isSelected());

        }

    }

    // users can select any car
    @Test(dataProvider = "managers")
    public void testCheckbox(String username) {

        LogInPage logInPage = new LogInPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainPage = new MainPage();
        VehiclePage vehiclePage = new VehiclePage();

        //navigate to vehiclePage
        LogInPage.login(username);
        wait.until(ExpectedConditions.visibilityOf(mainPage.fleet));
        actions.moveToElement(mainPage.fleet).perform();
        mainPage.vehicles.click();
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.lastCell));


    }
}