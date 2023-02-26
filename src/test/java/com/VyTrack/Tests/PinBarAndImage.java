package com.VyTrack.Tests;

import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import com.VyTrack.Pages.PinBar;
import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PinBarAndImage extends TestBaseWithDataProvider {
    // when users click the “Learn how to use this space” link on the homepage, users should see:
    // “How To Use Pin bar” and
    // “Use pin icon on the right top corner of the page to create fast access link in the pin bar.”
    @Test(dataProvider = "DifferentUserTypes")
    public void TestPinbar(String username) {

        LogInPage.login(username);

        MainPage mainPage = new MainPage();
        PinBar pinBar = new PinBar();


        // Click on “Learn how to use this space” link
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(mainPage.pinBarHelp));
        mainPage.pinBarHelp.click();


        // Validate user sees “How To Use Pin bar”
        wait.until(ExpectedConditions.visibilityOf(pinBar.headLine));
        String expectedTitle = "How To Use Pinbar";
        String actualTitle = pinBar.headLine.getText();
        Assert.assertEquals(actualTitle, expectedTitle);


        // Use pin icon on the right top corner of the page to create fast access link in the pin bar.
        wait.until(ExpectedConditions.visibilityOf(pinBar.pinBarButton));
        pinBar.pinBarButton.click();

        // Validate page is pinned to the Top
        wait.until(ExpectedConditions.visibilityOf(pinBar.pinHolder));
        Assert.assertTrue(pinBar.pinHolder.isDisplayed());

        // Remove pinned page and validate it no more displayed
        wait.until(ExpectedConditions.visibilityOf(mainPage.pinBarHelp));
        Assert.assertTrue(mainPage.pinBarHelp.isDisplayed());
    }


    @Test(dataProvider = "DifferentUserTypes")
    public void testValidateUsersSeeImage(String username) {
        //users should see an image on the page.
        //[in automation testing, just verify the image source.]
        //Expected source: /bundles/oronavigation/images/pinbar-location.jpg

        LogInPage.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        MainPage mainPage = new MainPage();
        PinBar pinBar = new PinBar();

        // Click on “Learn how to use this space” link
        wait.until(ExpectedConditions.visibilityOf(mainPage.pinBarHelp));
        mainPage.pinBarHelp.click();

        wait.until(ExpectedConditions.visibilityOf(pinBar.image));
        Assert.assertTrue(pinBar.image.isDisplayed());
        String actualSource = pinBar.image.getAttribute("src").replace("https://qa1.vytrack.com", "");
        String expectedSource = "/bundles/oronavigation/images/pinbar-location.jpg";
        Assert.assertEquals(actualSource, expectedSource);

    }
}
