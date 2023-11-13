package org.qmwebsite.pages.de;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qmwebsite.base.BasePage;
import org.qmwebsite.utils.ConfigLoader;

import java.util.List;

@Log
public class Article extends BasePage {
    public Article(WebDriver driver) {
        super(driver);
    }

    public void checkLink(By xpath, List<String> title, String pageName, String url) {

        removeCookies();
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();

        String winHandleBefore = driver.getWindowHandle();
        try {
                for (String winHandle : driver.getWindowHandles()) {
                    driver.switchTo().window(winHandle);
                }
                getTabName();
                Boolean status = title.contains(getTabName());
                Assert.assertTrue(status);

                driver.navigate().back();
                driver.close();
                driver.switchTo().window(winHandleBefore);
            } catch (Exception e) {
                Assert.fail("On page: " + pageName + " with address: " + url + " the link: " + xpath + " is wrong");
            }catch (AssertionError e){
            Assert.fail("On page: " + pageName + " with address: " + ConfigLoader.getInstance().getBaseUrl() + url +
                    ". After click on link with xpath: " + xpath +
                    " the opened page have wrong Tab Name. \nCurrent tabName: " + getTabName() +
                    "\nExpected Tab name is one of this: " + title);
        }



    }

    public void checkLinkOpensOnTheSamePage(By xpath, List<String> title, String  pageName, String url) {

        removeCookies();
        waitForElementToBeClickable(xpath);
        driver.findElement(xpath).click();

        try {
            org.junit.Assert.assertTrue(title.contains(getTabName()));
            driver.navigate().back();
        } catch (Exception e) {
            Assert.fail("On page: " + pageName + " with address: " + ConfigLoader.getInstance().getBaseUrl() + url +
                    " the link: " + xpath + " is wrong");
        } catch (AssertionError e) {
            Assert.fail("On page: " + pageName + " with address: " + ConfigLoader.getInstance().getBaseUrl() + url +
                    ". After click on link with xpath: " + xpath +
                    " the opened page have wrong Tab Name. \nCurrent tabName: " + getTabName() +
                    "\nExpected Tab name is one of this: " + title);
        }
    }
}
