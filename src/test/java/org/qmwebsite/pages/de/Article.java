package org.qmwebsite.pages.de;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qmwebsite.base.BasePage;

public class Article extends BasePage {
    public Article(WebDriver driver) {
        super(driver);
    }

    public Article checkLink(By xpath, String title) {
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

    public Article checkLinkWithEmptyTitle(By xpath, String title) {
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
        return this;

    }

    public Article checkLinkOpensOnTheSamePage(By xpath, String title) {

        removeCookies();
        waitForElementToBeClickable(xpath);
        driver.findElement(xpath).click();
        Assert.assertEquals(title, driver.getTitle());
        driver.navigate().back();
        return this;
    }
}
