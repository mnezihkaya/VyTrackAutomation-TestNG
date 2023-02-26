package com.VyTrack.Tests;

import com.VyTrack.Utilities.ConfigurationReader;
import com.VyTrack.Utilities.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class TestBaseWithDataProvider {

    private static final String env = ConfigurationReader.getProperty("env1");
    @BeforeMethod
    public void setUp() {
        //Go to VY TRACK Page
        Driver.getDriver().get(env);
    }


    @DataProvider(name = "DifferentUserTypes")
    public Object[][] DifferentUserTypes() {
        return new Object[][]{
                {ConfigurationReader.getProperty("username1")},
                {ConfigurationReader.getProperty("username2")},
                {ConfigurationReader.getProperty("username3")},
        };


    }

    @DataProvider(name = "AllUsers")
    public Object[][] allUsers() {
        return new Object[][]{
                {ConfigurationReader.getProperty("username1")},
                {ConfigurationReader.getProperty("username2")},
                {ConfigurationReader.getProperty("username3")},
                {ConfigurationReader.getProperty("username4")},
                {ConfigurationReader.getProperty("username5")},
                {ConfigurationReader.getProperty("username6")},
        };
    }
    // Data for Drivers users
    @DataProvider(name="drivers")
    public Object[][] drivers(){
        return new Object[][]{
                {ConfigurationReader.getProperty("username1")},
                {ConfigurationReader.getProperty("username4")},
        };
    }

    // Data for Store Managers users
    @DataProvider(name="storeManagers")
    public Object[][] storeManagers(){
        return new Object[][]{
                {ConfigurationReader.getProperty("username2")},
                {ConfigurationReader.getProperty("username5")},
        };
    }

    // Data for Sales Managers users
    @DataProvider(name="salesManagers")
    public Object[][] salesManagers(){
        return new Object[][]{
                {ConfigurationReader.getProperty("username3")},
                {ConfigurationReader.getProperty("username6")},
        };
    }

    // Data for All Managers users
    @DataProvider(name="managers")
    public Object[][] StoreAndSalesManagers(){
        return new Object[][]{
                {ConfigurationReader.getProperty("username2")},
                {ConfigurationReader.getProperty("username5")},
                {ConfigurationReader.getProperty("username3")},
                {ConfigurationReader.getProperty("username6")},
        };
    }

}