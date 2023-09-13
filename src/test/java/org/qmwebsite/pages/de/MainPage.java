package org.qmwebsite.pages.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qmwebsite.base.BasePage;
import org.qmwebsite.utils.ConfigLoader;
import org.testng.Assert;

public class MainPage extends BasePage {

    private final By kontaktiereUnsButton = By.xpath("//*[@id=\"post-18582\"]/div/div/div/div[8]/div/div[1]/div[2]/a");
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage load(){
        load("/");
        return this;
    }

    public MainPage checkkontaktiereUnsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(kontaktiereUnsButton));
        Assert.assertEquals(driver.findElement(kontaktiereUnsButton).getAttribute("href"),
                ConfigLoader.getInstance().getBaseUrl() + "/de/kontakt/");
        return this;
    }

    public MainPage checkDifferntLinkToMainPage(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(),
                ConfigLoader.getInstance().getBaseUrl() + "/de/");
        return this;
    }

}
