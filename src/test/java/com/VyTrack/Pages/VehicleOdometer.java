package com.VyTrack.Pages;

import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleOdometer {
    public VehicleOdometer(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type=\"number\"]")
    public WebElement pageNumber;

    @FindBy(xpath = "//button[@class=\"btn dropdown-toggle \"]")
    public WebElement viewPage;

    @FindBy(xpath = "//td[@class='action-cell grid-cell grid-body-cell']")
    public WebElement lastCell;
}
