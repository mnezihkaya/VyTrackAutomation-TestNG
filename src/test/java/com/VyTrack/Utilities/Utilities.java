package com.VyTrack.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utilities {


    public static void sleep(double second) {
        int sec = (int) (second * 1000);
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {

        }
    }

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    //This method accepts a String "expectedTitle" and Asserts if it contains in actual title
    public static void verifyTitleContains(String expectedTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }


    public static void logout() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        WebElement userBlock = Driver.getDriver().findElement(By.xpath("//li[@id='user-menu']//a[@class='dropdown-toggle']"));
        wait.until(ExpectedConditions.visibilityOf(userBlock));
        userBlock.click();

        WebElement logoutBtn = Driver.getDriver().findElement(By.xpath("//a[.='Logout']"));
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));
        logoutBtn.click();
    }
}