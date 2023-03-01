package com.VyTrack.Tests;

import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import com.VyTrack.Pages.VehiclePage;
import com.VyTrack.Utilities.Driver;
import com.VyTrack.Utilities.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DotsViews extends TestBaseWithDataProvider {
    //users should see “view, edit, delete” when they hover the mouse to the threeDots “...”.
    @Test(dataProvider = "userTypes")
    public void testVehicleIcons(String username) {
        LogInPage logInPage = new LogInPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainPage = new MainPage();
        VehiclePage vehiclePage = new VehiclePage();

        //navigate vehicle page
        actions.moveToElement(mainPage.fleet).perform();
        mainPage.fleet.click();

        //hover over the threeDots
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.lastCell));
        actions.moveToElement(vehiclePage.FirstDot).perform();

        //check view/edit/delete IsDisplayed
        for (WebElement each : vehiclePage.iconsList) {

            Assert.assertTrue(each.isDisplayed());

        }

    }
}