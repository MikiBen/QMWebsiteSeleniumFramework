package org.qmwebsite.pages.de;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qmwebsite.utils.ConfigLoader;
import org.qmwebsite.base.BasePage;
import org.testng.Assert;

@Slf4j
@Log
public class Footer extends BasePage {


    private final By qualityMindsLogo = By.xpath("//footer//*[contains(@class, 'et_pb_image_0_tb_footer')]/a");
    private final By impressum = By.xpath("//*[@id=\"menu-item-17644\"]/a");
    private final By hinweisgebersystem = By.xpath("//*[@id=\"menu-item-38208\"]/a");
    private final By datenschutzerklarung = By.xpath("//*[@id=\"menu-item-17643\"]/a");
    private final By kontaktInFooter = By.xpath("//*[@id=\"menu-item-21489\"]/a");

    private final By twitterInFooter = By.xpath("//footer//*[contains(@class, 'twitter')]/a");
    private final By linkedInInFooter = By.xpath("//footer//*[contains(@class, 'linkedin')]/a");
    private final By faceBookInFooter = By.xpath("//footer//*[contains(@class, 'facebook')]/a");
    private final By xingInFooter = By.xpath("//footer//*[contains(@class, 'xing')]/a");
    private final By feedInFooter = By.xpath("//footer//*[contains(@class, 'rss')]/a");

    public Footer(WebDriver driver) {
        super(driver);
    }


    public Footer checkImpessumButton(){
        waitForElementToBeClickable(impressum);
        Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/impressum/",
                driver.findElement(impressum).getAttribute("href"));
       checkStyle(impressum);
        return this;
    }

    public Footer checkHinweisgebersystemButton(){
        waitForElementToBeClickable(hinweisgebersystem);
        Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/hinweisgebersystem/",
                driver.findElement(hinweisgebersystem).getAttribute("href"));
        checkStyle(hinweisgebersystem);
        return this;
    }

    public Footer checkDatenschutzerklarungButton(){
        waitForElementToBeClickable(datenschutzerklarung);
        Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/datenschutzerklarung/",
                driver.findElement(datenschutzerklarung).getAttribute("href"));
        checkStyle(datenschutzerklarung);
        return this;
    }

    public Footer checkKontakButton(){
        waitForElementToBeClickable(kontaktInFooter);
        Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/kontakt/",
                driver.findElement(kontaktInFooter).getAttribute("href"));
        checkStyle(kontaktInFooter);
        return this;
    }

    public Footer checkQualityMindsLogoButton(){
        waitForElementToBeClickable(qualityMindsLogo);
        Assert.assertEquals(ConfigLoader.getInstance().getBaseUrl() + "/de/",
                driver.findElement(qualityMindsLogo).getAttribute("href"));
        return this;
    }

    public Footer checkTwitterButton(){
        waitForElementToBeClickable(twitterInFooter);
        Assert.assertEquals("https://twitter.com/qualitymindsde",
                driver.findElement(twitterInFooter).getAttribute("href"));
        return this;
    }

    public Footer checkLinkedInButton(){
        waitForElementToBeClickable(linkedInInFooter);
        Assert.assertEquals("https://www.linkedin.com/company/qualityminds-gmbh/",
                driver.findElement(linkedInInFooter).getAttribute("href"));
        return this;
    }

    public Footer checkFacebookButton(){
        waitForElementToBeClickable(faceBookInFooter);
        Assert.assertEquals("https://de-de.facebook.com/QualityMindsGmbH/",
                driver.findElement(faceBookInFooter).getAttribute("href"));
        return this;
    }

    public Footer checkXingButton(){
        waitForElementToBeClickable(xingInFooter);
        Assert.assertEquals("https://www.xing.com/pages/qualitymindsgmbh",
                driver.findElement(xingInFooter).getAttribute("href"));
        return this;
    }

    public Footer checkFeedButton(){
        waitForElementToBeClickable(feedInFooter);
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

