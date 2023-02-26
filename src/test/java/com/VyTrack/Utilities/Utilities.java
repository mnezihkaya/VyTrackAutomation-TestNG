package com.VyTrack.Utilities;

import org.testng.Assert;

public class Utilities {


    public static void sleep(double second){
        int sec = (int) (second *1000);
        try {
            Thread.sleep(sec);
        }catch (InterruptedException e ) {

        }
    }

    public static void verifyTitle( String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    //This method accepts a String "expectedTitle" and Asserts if it contains in actual title
    public static void verifyTitleContains(String expectedTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }
}
