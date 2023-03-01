package com.VyTrack.Pages;

import com.VyTrack.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Calender {

    public Calender() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title=\"Create Calendar event\"]")
    public WebElement createEvent;

    @FindBy(xpath = "//div[@class=\"controls\"]//input[@id=\"recurrence-repeat-view9796\"]")
    public WebElement repeatBox;

    @FindBy(xpath = "//input[@class='recurrence-subview-control__number']")
    public WebElement dayInput;

    @FindBy(xpath = "//span[@id=\"temp-validation-name-9848-error\"]")
    public WebElement errorMessage;

    @FindBy(xpath = "//input[@id=\"oro_calendar_event_form_title-uid-63feb54f9759c\"]")
    public WebElement inputTitle;

    @FindBy(xpath = "//iframe")
    public WebElement iFrame;

    @FindBy(xpath = "//body")
    public WebElement textBody;
    @FindBy(xpath = "//p")
    public WebElement message;


}
