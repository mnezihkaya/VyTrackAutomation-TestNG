package com.VyTrack.Pages;

import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehicleModel {

    public VehicleModel(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//span[@class=\"grid-header-cell__label\"]")
    public List<WebElement> allHeaders;
}
