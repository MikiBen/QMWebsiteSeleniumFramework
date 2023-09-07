package org.selenium.pom.tests;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.de.Footer;
import org.selenium.pom.pages.de.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.stream.IntStream;

@Slf4j
public class QMWebsiteTestInDE extends BaseTest {

    @Test
    public void mainPageTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.load();
    }

    @Test
    public void checkTabName(){
        BasePage basePage = new BasePage(getDriver());

            IntStream.range(0,jsonFile.getPages().getUrlModelList().size()).forEach(i->{
                        basePage.load(jsonFile.getPages().getUrlModelList().get(i).getUrl());

                Assert.assertEquals(basePage.getTabName(), jsonFile.getPages().getUrlModelList().get(i).getTabName());
                   //log.info("Wrong Tab NAME");
                    }
            );
    }


    @Test
    public void checkFooter(){
        Footer footer = new Footer(getDriver());
        for(int i=1; i<jsonFile.getPages().getUrlModelList().size();i++) {
            footer.load(jsonFile.getPages().getUrlModelList().get(i).getUrl());
            footer.navigateToQualityMindsLogo().
                   checkQualityMindsLogo().
                    checkStyleImpressum().
                    checkNavigateToImpessum();
        }
    }
}
