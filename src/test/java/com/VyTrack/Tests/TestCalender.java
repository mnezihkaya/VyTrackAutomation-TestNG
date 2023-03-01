package com.VyTrack.Tests;

import org.testng.annotations.Test;

public class TestCalender {

    @Test(dataProvider = "DifferentUserTypes")
    public void TestCalenderDefault(String username){
        // user should see the number “1” by default.
    }
}
