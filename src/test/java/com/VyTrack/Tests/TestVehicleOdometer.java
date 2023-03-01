package com.VyTrack.Tests;

import org.testng.annotations.Test;

public class TestVehicleOdometer extends TestBaseWithDataProvider{

    @Test(dataProvider = "managers")
    public void testOdometer(String username){

        // Store and Sales managers should see an error message
        // “You do not have permission to perform this action.”
        // when they click the “Vehicle Odometer” module.
    }
}
