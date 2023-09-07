package org.selenium.pom.pages.de;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.Assert;


public class Footer extends BasePage {
    private final By qualityMindsLogo = By.cssSelector("img[title='QualityMinds logo']");
    private final By impressum = By.xpath("//*[@id=\"menu-item-17644\"]/a");
    private final By hinwesgebersystem = By.cssSelector("a[href='https://qualityminds.com/de/hinweisgebersystem/'][shub-ins='1']");
    private final By datenschutzerklarung = By.cssSelector("ul[id='menu-footer-de'] a[rel='privacy-policy']");
    private final By kontaktInFooter = By.cssSelector("a[href='https://qualityminds.com/de/kontakt/'][shub-ins='1']");

    public Footer(WebDriver driver) {
        super(driver);
    }

    public Footer navigateToQualityMindsLogo(){
        wait.until(ExpectedConditions.elementToBeClickable(qualityMindsLogo)).click();
        return this;
    }

    public Footer checkNavigateToImpessum(){
        wait.until(ExpectedConditions.elementToBeClickable(impressum)).click();
        Assert.assertEquals(driver.getCurrentUrl(),ConfigLoader.getInstance().getBaseUrl() + "/de/impressum/" );
        driver.navigate().back();
        return this;
    }

    public Footer checkQualityMindsLogo(){
        try {
            if(driver.getCurrentUrl() == ConfigLoader.getInstance().getBaseUrl() + "/de/"){
                Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/", driver.getCurrentUrl());
            }
            else {
                Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/", driver.getCurrentUrl());
                driver.navigate().back();
            }
        } catch (Exception e) {
            org.testng.Assert.fail("On page: " + driver.getCurrentUrl() + " I can not find MainPage button in Footer");
        }
        return this;
    }

    private void checkStyle(By selector){
        try{
            org.testng.Assert.assertEquals(driver.findElement(selector).getCssValue("font-style"), "normal");
            org.testng.Assert.assertEquals(driver.findElement(selector).getCssValue("font-variant"), "normal");
            org.testng.Assert.assertEquals(driver.findElement(selector).getCssValue("font-family"),"\"Source Sans Pro\", sans-serif");
        }catch (Exception e){
            org.testng.Assert.fail("On page: " + driver.getCurrentUrl() + " I can not find " + selector + " button in Footer");
        }
    }

    public Footer checkStyleImpressum(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(impressum));
            checkStyle(impressum);
        return this;
    }


}

