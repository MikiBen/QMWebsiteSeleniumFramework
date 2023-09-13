package org.qmwebsite.pages.pl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;
import org.testng.Assert;

public class EventsPL extends BasePage {

    private final By eventText = By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/div[2]/div/div/h1");
    public EventsPL(WebDriver driver) {
        super(driver);
    }

    public EventsPL checkExitsPage(){

        Assert.assertEquals("Veranstaltungen", driver.findElement(eventText).getText());

        return this;
    }
}
