package org.qmwebsite.pages.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;
import org.testng.Assert;

public class EventsDE extends BasePage {
    //*[@id=\"menu-item-38208\"]/a");
    private final By eventText = By.xpath("//*[@class='entry-title']");
    public EventsDE(WebDriver driver) {
        super(driver);
    }

    public EventsDE checkExitsPage(){

        Assert.assertEquals("Veranstaltungen", driver.findElement(eventText).getText());

        return this;
    }
}
