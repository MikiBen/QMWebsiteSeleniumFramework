package org.qmwebsite.pages.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qmwebsite.utils.ConfigLoader;
import org.qmwebsite.base.BasePage;
import org.testng.Assert;

public class MainMenu extends BasePage {

    private final By mainLogo = By.xpath("//*[@class='logo_container']a");
    private final By qmStore = By.xpath("//*[@id=\"store-butt\"]/a");
    public MainMenu(WebDriver driver) {
        super(driver);
    }

    public MainMenu checkQualityMindsLogoButton(){
        wait.until(ExpectedConditions.elementToBeClickable(mainLogo));
        Assert.assertEquals(driver.findElement(mainLogo).getAttribute("href"),
                ConfigLoader.getInstance().getBaseUrl() + "/de/");
        return this;
    }

    public MainMenu checkQMStoreButton(){
        wait.until(ExpectedConditions.elementToBeClickable(qmStore));
        Assert.assertEquals(driver.findElement(qmStore).getAttribute("href"),
                "https://store.qualityminds.com/");
        return this;
    }
}
