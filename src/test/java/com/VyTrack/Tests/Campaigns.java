package com.VyTrack.Tests;

import com.VyTrack.Pages.CampaignPage;
import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import com.VyTrack.Utilities.Driver;
import com.VyTrack.Utilities.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Campaigns extends TestBaseWithDataProvider {


    @Test(dataProvider = "managers")
    public void TestCampaign(String username) {
        LogInPage.login(username);
        CampaignPage campaignPage = new CampaignPage();
        MainPage mainPage = new MainPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());

        //  Navigate over Marketing link
        wait.until(ExpectedConditions.visibilityOf(mainPage.marketing));
        actions.moveToElement(mainPage.marketing).perform();
        mainPage.marketingSubCampaigns.click();


        // Click Filters button
        wait.until(ExpectedConditions.visibilityOf(campaignPage.filters));
        campaignPage.filters.click();

        // Click on the Manage filters
        wait.until(ExpectedConditions.visibilityOf(campaignPage.manageFilters));
        campaignPage.manageFilters.click();

        // Validate if all 5 filters are displayed and filter options are checked by default.
        for (WebElement each : campaignPage.filterCheckboxes) {
            Assert.assertTrue(each.isSelected());

        }

    }

    @Test(dataProvider = "managers")
    public void TestCampaignUncheck(String username) {
        LogInPage.login(username);
        CampaignPage campaignPage = new CampaignPage();
        MainPage mainPage = new MainPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());

        //  Navigate over Marketing link
        wait.until(ExpectedConditions.visibilityOf(mainPage.marketing));
        actions.moveToElement(mainPage.marketing).perform();
        wait.until(ExpectedConditions.visibilityOf(mainPage.marketingSubCampaigns));
        mainPage.marketingSubCampaigns.click();


        // Click Filters button
        wait.until(ExpectedConditions.visibilityOf(campaignPage.filters));
        campaignPage.filters.click();

        // Click on the Manage filters
        wait.until(ExpectedConditions.visibilityOf(campaignPage.manageFilters));
        campaignPage.manageFilters.click();

        // Validate any amount of boxes should be unchecked. (can check only 1, or multiple)
        for (int i = 0; i < campaignPage.filterCheckboxes.size(); i++) {
            campaignPage.filterCheckboxes.get(i).click();
            Utilities.sleep(2);
        }


        // Validate if all 5 filters are displayed and filter options are checked by default.
        for (WebElement each : campaignPage.filterCheckboxes) {
            wait.until(ExpectedConditions.elementToBeClickable(each));
            Assert.assertFalse(each.isSelected());
        }
    }
}
