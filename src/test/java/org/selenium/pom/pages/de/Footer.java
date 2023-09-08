package org.selenium.pom.pages.de;

import com.beust.ah.A;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.Assert;

import java.util.Objects;

@Slf4j
@Log
public class Footer extends BasePage {
    private final By qualityMindsLogo = By.xpath("//*[@id=\"et-main-area\"]/footer/div/div/div[1]/div/div[1]/a");
    private final By impressum = By.xpath("//*[@id=\"menu-item-17644\"]/a");
    private final By hinweisgebersystem = By.xpath("//*[@id=\"menu-item-38208\"]/a");
    private final By datenschutzerklarung = By.xpath("//*[@id=\"menu-item-17643\"]/a");
    private final By kontaktInFooter = By.xpath("//*[@id=\"menu-item-21489\"]/a");

    private final By twitterInFooter = By.xpath("//*[@id=\"et-main-area\"]/footer/div/div/div[1]/div/ul/li[1]/a");
    private final By linkedInInFooter = By.xpath("//*[@id=\"et-main-area\"]/footer/div/div/div[1]/div/ul/li[2]/a");
    private final By faceBookInFooter = By.xpath("//*[@id=\"et-main-area\"]/footer/div/div/div[1]/div/ul/li[3]/a");
    private final By xingInFooter = By.xpath("//*[@id=\"et-main-area\"]/footer/div/div/div[1]/div/ul/li[4]/a");
    private final By feedInFooter = By.xpath("//*[@id=\"et-main-area\"]/footer/div/div/div[1]/div/ul/li[5]/a");

    public Footer(WebDriver driver) {
        super(driver);
    }


    public Footer checkImpessumButton(){
        wait.until(ExpectedConditions.elementToBeClickable(impressum));
        Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/impressum/",
        driver.findElement(impressum).getAttribute("href"));
       checkStyle(impressum);
        return this;
    }

    public Footer checkHinweisgebersystemButton(){
        wait.until(ExpectedConditions.elementToBeClickable(hinweisgebersystem));
        Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/hinweisgebersystem/",
                driver.findElement(hinweisgebersystem).getAttribute("href"));
        checkStyle(hinweisgebersystem);
        return this;
    }

    public Footer checkDatenschutzerklarungButton(){
        wait.until(ExpectedConditions.elementToBeClickable(datenschutzerklarung));
        Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/datenschutzerklarung/",
                driver.findElement(datenschutzerklarung).getAttribute("href"));
        checkStyle(datenschutzerklarung);
        return this;
    }

    public Footer checkKontakButton(){
        wait.until(ExpectedConditions.elementToBeClickable(kontaktInFooter));
        Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/kontakt/",
                driver.findElement(kontaktInFooter).getAttribute("href"));
        checkStyle(kontaktInFooter);
        return this;
    }

    public Footer checkQualityMindsLogoButton(){
        wait.until(ExpectedConditions.elementToBeClickable(qualityMindsLogo));
        Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/",
                driver.findElement(qualityMindsLogo).getAttribute("href"));
        return this;
    }

    public Footer checkTwitterButton(){
        wait.until(ExpectedConditions.elementToBeClickable(twitterInFooter));
        Assert.assertEquals("https://twitter.com/qualitymindsde",
                driver.findElement(twitterInFooter).getAttribute("href"));
        return this;
    }

    public Footer checkLinkedInButton(){
        wait.until(ExpectedConditions.elementToBeClickable(linkedInInFooter));
        Assert.assertEquals("https://www.linkedin.com/company/qualityminds-gmbh/",
                driver.findElement(linkedInInFooter).getAttribute("href"));
        return this;
    }

    public Footer checkFacebookButton(){
        wait.until(ExpectedConditions.elementToBeClickable(faceBookInFooter));
        Assert.assertEquals("https://de-de.facebook.com/QualityMindsGmbH/",
                driver.findElement(faceBookInFooter).getAttribute("href"));
        return this;
    }

    public Footer checkXingButton(){
        wait.until(ExpectedConditions.elementToBeClickable(xingInFooter));
        Assert.assertEquals("https://www.xing.com/pages/qualitymindsgmbh",
                driver.findElement(xingInFooter).getAttribute("href"));
        return this;
    }

    public Footer checkFeedButton(){
        wait.until(ExpectedConditions.elementToBeClickable(feedInFooter));
        Assert.assertEquals("https://qualityminds.com/de/feed/",
                driver.findElement(feedInFooter).getAttribute("href"));
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



}

