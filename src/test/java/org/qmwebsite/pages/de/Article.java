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
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();

        String winHandleBefore = driver.getWindowHandle();
        try {
                for (String winHandle : driver.getWindowHandles()) {
                    driver.switchTo().window(winHandle);
                }
                getTabName();
                Boolean status = title.contains(getTabName());
                Assert.assertTrue(("On page: " + pageName + " with address: " + ConfigLoader.getInstance().getBaseUrl() + url +
                        ". After click on link with xpath: " + xpath +
                        " the opened page have wrong Tab Name. \nCurrent tabName: " + getTabName() +
                        "\nExpected Tab name is one of this: " + title), status);

               // driver.navigate().back();
               // driver.close();
               // driver.switchTo().window(winHandleBefore);
            } catch (Exception e) {
                Assert.fail("On page: " + pageName + " with address: " + url + " the link: " + xpath + " is wrong");
            }
    }

    public void checkLinkOpensOnTheSamePage(By xpath, List<String> title, String  pageName, String url) {

        removeCookies();
        waitForElementToBeClickable(xpath).click();

        try {
            Assert.assertTrue(("On page: " + pageName + " with address: " + ConfigLoader.getInstance().getBaseUrl() + url +
                    ". After click on link with xpath: " + xpath +
                    " the opened page have wrong Tab Name. \nCurrent tabName: " + getTabName() +
                    "\nExpected Tab name is one of this: " + title), title.contains(getTabName())); // dodać tutaj i usuna try catch
            //driver.navigate().back(); // dodać url
        } catch (Exception e) {
            Assert.fail("On page: " + pageName + " with address: " + ConfigLoader.getInstance().getBaseUrl() + url +
                    " the link: " + xpath + " is wrong");
        }

    }
}
