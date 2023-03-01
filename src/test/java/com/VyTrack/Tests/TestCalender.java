package com.VyTrack.Tests;

import com.VyTrack.Pages.Calender;
import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalender extends TestBaseWithDataProvider {

    //user should see the number “1” by default at repeatBox
    @Test(dataProvider = "DifferentUserTypes")
    public void TestCalenderDefault(String username) {
        // user should see the number “1” by default.

        LogInPage.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainpage = new MainPage();
        Calender calender = new Calender();


        // Navigate calenderPAge
        wait.until(ExpectedConditions.visibilityOf(mainpage.activities));
        actions.moveToElement(mainpage.activities).perform();
        mainpage.activitiesSubCalendar.click();


        //Click Create event
        wait.until(ExpectedConditions.visibilityOf(calender.createEvent));
        calender.createEvent.click();

        //click the create checkbox
        wait.until(ExpectedConditions.visibilityOf(calender.repeatBox));
        calender.repeatBox.click();

        //validate user see 1 in the box
        wait.until(ExpectedConditions.visibilityOf(calender.dayInput));
        String actualValue = calender.dayInput.getAttribute("value");
        String expectedValue = "1";
        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test(dataProvider = "DifferentUserTypes")
    public void TestEmptyBox(String username) {
        // user should see the number “1” by default.

        LogInPage.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainpage = new MainPage();
        Calender calender = new Calender();


        // Navigate calenderPAge
        wait.until(ExpectedConditions.visibilityOf(mainpage.activities));
        actions.moveToElement(mainpage.activities).perform();
        mainpage.activitiesSubCalendar.click();


        //Click Create event
        wait.until(ExpectedConditions.visibilityOf(calender.createEvent));
        calender.createEvent.click();

        //click the repeat checkbox
        wait.until(ExpectedConditions.visibilityOf(calender.repeatBox));
        calender.repeatBox.click();

        //clear daysInput box
        wait.until(ExpectedConditions.visibilityOf(calender.errorMessage));
        calender.dayInput.clear();

        //validate error Message
        wait.until(ExpectedConditions.visibilityOf(calender.errorMessage));
        String actualTitle = calender.errorMessage.getText();
        String expectedTitle = "This value should not be blank.";
        Assert.assertEquals(actualTitle, expectedTitle);


        //user should see an error message “This value should not be blank.”
        // when the Calendar event repeat field is cleared(delete the number 1).

    }
}