package com.VyTrack.Tests;

import com.VyTrack.Pages.LogInPage;
import com.VyTrack.Pages.MainPage;
import com.VyTrack.Pages.VehicleContract;
import com.VyTrack.Utilities.Driver;
import com.VyTrack.Utilities.Utilities;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleContractsPage extends TestBaseWithDataProvider {

    //Store managers and Sales managers access the Vehicle contracts page.
    //Expected URL: https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract
    //Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System.

    @Test(dataProvider = "managers")
    public void VehicleContractsManager(String username){

        LogInPage.login(username);
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        Actions actions=new Actions(Driver.getDriver());
        MainPage mainPage=new MainPage();
        VehicleContract vehicleContract=new VehicleContract();


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
}
