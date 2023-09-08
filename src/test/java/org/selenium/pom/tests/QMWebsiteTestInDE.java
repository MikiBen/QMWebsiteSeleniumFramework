package org.selenium.pom.tests;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.de.Footer;
import org.selenium.pom.pages.de.MainMenu;
import org.selenium.pom.pages.de.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

@Slf4j
@Log
public class QMWebsiteTestInDE extends BaseTest {

    @Test
    public void mainPageTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.load("/de/");
        mainPage.checkkontaktiereUnsButton().
                checkDifferntLinkToMainPage("https://qualityminds.de/");

    }

    @Test
    public void checkTabName(){
        BasePage basePage = new BasePage(getDriver());

            IntStream.range(0,jsonFile.getPages().getUrlModelList().size()).forEach(i->{
                        basePage.load(jsonFile.getPages().getUrlModelList().get(i).getUrl());
                        Assert.assertEquals(basePage.getTabName(), jsonFile.getPages().getUrlModelList().get(i).getTabName());
                    }
            );
    }

    @Test
    public void checkFooter(){
        Footer footer = new Footer(getDriver());

        IntStream.range(0,jsonFile.getPages().getUrlModelList().size()).forEach(i-> {
                footer.load(jsonFile.getPages().getUrlModelList().get(i).getUrl());
                log.info(footer.getCurrentAddress());
                footer.checkQualityMindsLogoButton().
                        checkImpessumButton().
                        checkHinweisgebersystemButton().
                        checkDatenschutzerklarungButton().
                        checkKontakButton().
                        checkTwitterButton().
                        checkLinkedInButton().
                        checkFacebookButton().
                        checkXingButton().
                        checkFeedButton();
             }
        );
    }

    @Test
    public void checkMainMenu(){
        MainMenu mainMenu = new MainMenu(getDriver());

        IntStream.range(0,jsonFile.getPages().getUrlModelList().size()).forEach(i-> {
            mainMenu.load(jsonFile.getPages().getUrlModelList().get(i).getUrl());
            mainMenu.checkQMStoreButton().
                    checkQMStoreButton();

        });
    }
}
