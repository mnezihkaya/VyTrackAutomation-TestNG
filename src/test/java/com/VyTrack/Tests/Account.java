package com.VyTrack.Tests;

import com.VyTrack.Pages.Accounts;
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

public class Account extends TestBaseWithDataProvider{

    @Test(dataProvider = "managers")
    public void testAccountsPage(String username) {

        //users should see 8 filter items on the Accounts page
        //Expected filter names: Account Name, Contact Name, Contact Email, Contact Phone, Owner, Business Unit, Created At, Updated At.

        LogInPage logInPage = new LogInPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        MainPage mainPage = new MainPage();
        Accounts accounts = new Accounts();

        LogInPage.login(username);

        //Navigate Customer Link
        wait.until(ExpectedConditions.visibilityOf(mainPage.customers));
        actions.moveToElement(mainPage.customers).perform();
        wait.until(ExpectedConditions.visibilityOf(mainPage.customersSubAccounts));
        mainPage.customersSubAccounts.click();

        //Click on filter button
        wait.until(ExpectedConditions.visibilityOf(accounts.filters));
        accounts.filters.click();

        // Validate filter names
        List<String> actual= new ArrayList<>();
        List<String> expected=new ArrayList<>(Arrays.asList("Account Name", "Contact Name", "Contact Email", "Contact Phone", "Owner", "Business Unit", "Created At", "Updated At"));

        for (WebElement each:accounts.allFilters) {
            actual.add(each.getText().replace(": All",""));

        }
        Assert.assertEquals(actual,expected);
    }
}