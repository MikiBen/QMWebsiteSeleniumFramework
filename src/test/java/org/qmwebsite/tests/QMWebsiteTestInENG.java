package org.qmwebsite.tests;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.TimeoutException;
import org.qmwebsite.base.BaseTest;
import org.qmwebsite.pages.de.*;
import org.qmwebsite.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Log
public class QMWebsiteTestInENG extends BaseTest {

    @Test (dataProvider = "AllUrlListENG")
    public void checkTabName(String pageName, String url, String tabName){
        MainPage mainPage = new MainPage(getDriver());
                    mainPage.load(url);
                        Assert.assertEquals(mainPage.getTabName(), tabName,("\nOn page: " + pageName + " with address: "
                                + ConfigLoader.getInstance().getBaseUrl() + url +
                                " the opened page have wrong Tab Name. \nCurrent tabName: " + mainPage.getTabName() +
                                "\nExpected Tab name is one of this: " + tabName));
    }

}





