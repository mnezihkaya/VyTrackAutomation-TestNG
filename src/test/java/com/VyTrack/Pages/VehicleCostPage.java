package com.VyTrack.Pages;

import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehicleCostPage {

    public VehicleCostPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//span[@class=\"grid-header-cell__label\"]")
    public List<WebElement>headers;

    @FindBy(xpath = "//th//input[@type=\"checkbox\"]")
    public WebElement firstCheckBox;

    @FindBy(xpath = "//td//input[@type=\"checkbox\"]")
    public List<WebElement> allCheckBoxes;

    @FindBy(xpath = "//tr[1]//td[@class=\"date-cell grid-cell grid-body-cell grid-body-cell-Date\"]")
    public WebElement date;
    @FindBy(xpath = "//tr[1]//td[@class=\"number-cell grid-cell grid-body-cell grid-body-cell-TotalPrice\"]")
    public WebElement totalPrice;

    @FindBy(xpath = "//tr[1]//td[@class=\"string-cell grid-cell grid-body-cell grid-body-cell-Type\"]")
    public WebElement type;

    @FindBy(xpath = "//input[@id=\"ui-multiselect-3-3-option-0\"]")
    public WebElement filterType;

    @FindBy(xpath = "//input[@id=\"ui-multiselect-3-3-option-1\"]")
    public WebElement filterTotalPrice;

    @FindBy(xpath = "//input[@id=\"ui-multiselect-3-3-option-2\"]")
    public WebElement filterDate;
}
