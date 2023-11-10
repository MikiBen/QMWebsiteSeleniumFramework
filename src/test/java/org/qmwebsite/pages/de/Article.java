package org.qmwebsite.pages.de;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qmwebsite.base.BasePage;
import org.qmwebsite.utils.ConfigLoader;

@Log
public class Article extends BasePage {
    public Article(WebDriver driver) {
        super(driver);
    }

    public void checkLink(By xpath, String title,String pageName,String url) {

        removeCookies();
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();

        String winHandleBefore = driver.getWindowHandle();
        try {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }

            if (driver.getTitle() == "[Sign In] | LinkedIn") {
                Assert.assertEquals("[Sign In] | LinkedIn", driver.getTitle());
            }else if (driver.getTitle() == "") {
                Assert.assertEquals("", driver.getTitle());
            }else{
                Assert.assertEquals(title, driver.getTitle());
            }
            driver.navigate().back();
            driver.close();
            driver.switchTo().window(winHandleBefore);

        } catch (Exception e) {
            Assert.fail("On page: " + pageName + " with address: " + url + " the link: " + xpath + " is wrong");
        }
    }

    public void checkLinkOpensOnTheSamePage(By xpath, String title, String  pageName, String url) {

        removeCookies();
        waitForElementToBeClickable(xpath);
        driver.findElement(xpath).click();

        try {
            Assert.assertEquals(title, driver.getTitle());
            driver.navigate().back();
        }catch (Exception e) {
            Assert.fail("On page: " + pageName + " with address: " + ConfigLoader.getInstance().getBaseUrl() + url +
                    " the link: " + xpath + " is wrong");
        }

    }
}
