package com.VyTrack.Pages;

import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinBar {
    public void PinBar(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div/h3")
    public WebElement HeadLine;

    @FindBy(xpath = "//img")
    public WebElement Image;

    @FindBy(xpath = "//button[@class=\"btn minimize-button\"]")
    public WebElement PinBar;

}
