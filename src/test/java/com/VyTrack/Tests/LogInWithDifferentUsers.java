package com.VyTrack.Tests;

import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogInWithDifferentUsers extends TestBaseWithDataProvider {

    @Test(dataProvider = "managers")
    //store and sales managers should view 8 module names.
    public void testMainModulesAppearedForManagers(String username) {


        LogInPage.login(username);
        MainPage mainPage = new MainPage();


        List<String> ExpectedModuleNames = new ArrayList<>(Arrays.asList("Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"
        ));

        List<String> ActualModuleNames = new ArrayList<>();
        for (WebElement each : mainPage.allModules) {
            ActualModuleNames.add(each.getText());
        }
        //verify moduleNames
        Assert.assertEquals(ActualModuleNames, ExpectedModuleNames);


    }


}

