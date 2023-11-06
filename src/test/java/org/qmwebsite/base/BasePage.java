package org.qmwebsite.base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qmwebsite.utils.ConfigLoader;
import lombok.extern.java.Log;

import java.time.Duration;
import java.util.List;
@Log
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
       wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void load(String endPoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }

    public void wairForIverlaysToDisappear(By overlay) {
        List<WebElement> overlays = driver.findElements(overlay);
        if (!overlays.isEmpty()) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
        }else {
            log.info("OVERLAY NOT FOUND"); //na logera
        }
    }

    public WebElement waitForElementToBeVisible(By element){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitForElementToBeClickable(By element){
        return  wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getCurrentAddress(){
        return driver.getCurrentUrl();
    }

    public String getTabName(){
        return driver.getTitle();
    }

    protected void removeCookies(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(
                "const element = document.querySelector('#cmplz-cookiebanner-container');" +
                        "if (element) { element.parentNode.removeChild(element); }"
        );


    }

    protected BasePage checkLink(By xpath, String title) {
        removeCookies();
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();

        String winHandleBefore = driver.getWindowHandle();
        try {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }

            //Assert.assertTrue((driver.getTitle().equals("") )|| (driver.getTitle().equals(title)));
            Assert.assertEquals(title, driver.getTitle());
            driver.navigate().back();

            driver.close();
            driver.switchTo().window(winHandleBefore);
        } catch (Exception e) {
            System.out.println("On page: " + driver.getCurrentUrl() + " I can not find proper link");
            Assert.fail();
        }

        return this;
    }

    protected void checkLinkWithEmptyTitle(By xpath, String title) {
        removeCookies();
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();

        String winHandleBefore = driver.getWindowHandle();
        try {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }

            Assert.assertTrue((driver.getTitle().equals("") )|| (driver.getTitle().equals(title)));
            //Assert.assertEquals(title, driver.getTitle());
            driver.navigate().back();

            driver.close();
            driver.switchTo().window(winHandleBefore);
        } catch (Exception e) {
            System.out.println("On page: " + driver.getCurrentUrl() + " I can not find proper link");
            Assert.fail();
        }

    }

    protected void checkLinkOpensOnTheSamePage(By xpath, String title) {

        removeCookies();
        waitForElementToBeClickable(xpath);
        driver.findElement(xpath).click();
        Assert.assertEquals(title, driver.getTitle());
        driver.navigate().back();
    }

}
