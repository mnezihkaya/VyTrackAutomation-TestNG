package com.VyTrack.Pages;

import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclePage {

    public VehiclePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='more-bar-holder']/div")
    public List<WebElement> AllDot;
    @FindBy(xpath = "//tr[1]//div[@class='more-bar-holder']/div")
    public WebElement FirstDot;
    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkboxes;
    @FindBy(xpath = "//th//input[@type='checkbox']")
    public WebElement FirstCheckBox;
    @FindBy(xpath = "//td//input[@type='checkbox']")
    public List<WebElement> carCheckboxes;
    @FindBy(xpath = "//li[@class='launcher-item']/a")
    public List<WebElement> iconsList;
    @FindBy(xpath = "//tr[20]//td[20]")
    public WebElement lastCell;

}
