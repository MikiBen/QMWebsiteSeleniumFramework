package org.qmwebsite.tests;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.qmwebsite.base.BaseTest;
import org.qmwebsite.pages.de.MainPage;
import org.qmwebsite.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
@Log
public class QMWebsiteTestInPL extends BaseTest {

    @Test (dataProvider = "AllUrlListPL")
    public void checkTabName(String pageName, String url, String tabName){
        MainPage mainPage = new MainPage(getDriver());
                    mainPage.load(url);
                        Assert.assertEquals(mainPage.getTabName(), tabName,("\nOn page: " + pageName + " with address: "
                                + ConfigLoader.getInstance().getBaseUrl() + url +
                                " the opened page have wrong Tab Name. \nCurrent tabName: " + mainPage.getTabName() +
                                "\nExpected Tab name is one of this: " + tabName));
    }

}





