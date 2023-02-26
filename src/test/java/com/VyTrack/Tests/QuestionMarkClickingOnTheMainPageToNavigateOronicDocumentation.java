package com.VyTrack.Tests;

import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import com.VyTrack.Utilities.Driver;
import com.VyTrack.Utilities.Utilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuestionMarkClickingOnTheMainPageToNavigateOronicDocumentation extends TestBaseWithDataProvider {

    @Test(dataProvider = "DifferentUserTypes")
    public void OronicDocumentation(String username) {

        LogInPage.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        MainPage mainPage = new MainPage();

        //Storing the main page's window handle as string
        String mainHandle = Driver.getDriver().getWindowHandle();


        wait.until(ExpectedConditions.visibilityOf(mainPage.getHelpIcon));
        mainPage.getHelpIcon.click();

        // Switch to new Window.

        Utilities.sleep(1);

        for (String each : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(each);

            Utilities.sleep(1);
            Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://doc.oroinc.com/");

            // Switch back to VyTrack page
            Driver.getDriver().switchTo().window(mainHandle);

            // Validate user on VyTrack page
            Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");

        }

    }

}
