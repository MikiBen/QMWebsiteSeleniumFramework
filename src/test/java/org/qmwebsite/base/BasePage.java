package org.qmwebsite.base;

import org.openqa.selenium.By;
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
       wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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

}
