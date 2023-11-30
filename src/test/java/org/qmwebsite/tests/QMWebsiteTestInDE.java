package org.qmwebsite.tests;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.qmwebsite.pages.de.*;
import org.qmwebsite.base.BaseTest;
import org.qmwebsite.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Slf4j
@Log
public class QMWebsiteTestInDE extends BaseTest {


    @Test
    public void mainPageTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.load("/de/");
        mainPage.checkkontaktiereUnsButton().
                checkDifferntLink("https://qualityminds.de/");
    }
   /* @Test
    public void checkExitsEventsPages(){
        EventsDE eventsDE = new EventsDE(getDriver());
        eventsDE.load("/de/veranstaltungen/");
        eventsDE.checkExitsPage();
    }
*/
    @Test (dataProvider = "AllUrlListDE")
    public void checkTabName(String pageName, String url, String tabName){
        MainPage mainPage = new MainPage(getDriver());
                    mainPage.load(url);
                        Assert.assertEquals(mainPage.getTabName(), tabName,("On page: " + pageName + " with address: "
                                + ConfigLoader.getInstance().getBaseUrl() + url +
                                " the opened page have wrong Tab Name. \nCurrent tabName: " + mainPage.getTabName() +
                                "\nExpected Tab name is one of this: " + tabName));
    }

    @Test (dataProvider = "AllUrlListDE")
    public void checkFooter(String pageName, String url, String tabName){
        Footer footer = new Footer(getDriver());
                    footer.load(url);
                    log.info(footer.getCurrentAddress());
                    footer.checkQualityMindsLogoButton().
                            checkImpessumButton().
                            checkHinweisgebersystemButton().
                            checkDatenschutzerklarungButton().
                            checkKontakButton().
                           // checkTwitterButton().
                            checkLinkedInButton().
                            checkFacebookButton().
                            checkXingButton().
                            checkFeedButton();
                }

    @Test (dataProvider = "AllUrlListDE")
    public void checkMainMenu(String pageName, String url, String tabName){
        MainMenu mainMenu = new MainMenu(getDriver());
            mainMenu.load(url);
            mainMenu.checkQMStoreButton();
    }

    @Test(dataProvider="UrlListOnArticlesDE")
    public void checkUrlLinkOnPages(String pageName, String url, String xpath, List<String> tabName, Boolean getPageOpenInNewTab)
    {
        checkLink(pageName, url, xpath, tabName, getPageOpenInNewTab);
    }

    @Test(dataProvider="UrlListOnBlogQualityHereosDE")
    public void checkUrlLinkOnBlogsQualityHeroesDE(String pageName, String url, String xpath, List<String> tabName, Boolean getPageOpenInNewTab)
    {
        checkLink(pageName, url, xpath, tabName, getPageOpenInNewTab);
    }
    @Test(dataProvider="UrlListOnBlogIWantChangeDE")
    public void checkUrlLinkOnBlogsIWantChangeDE(String pageName, String url, String xpath, List<String> tabName, Boolean getPageOpenInNewTab)
    {
        checkLink(pageName, url, xpath, tabName, getPageOpenInNewTab);
    }

    @Test(dataProvider="UrlListWithRedirection")
    public void checkRedirection(String pageName, String url, String tabName)
    {
        getDriver().get(url);
        Assert.assertEquals(getDriver().getCurrentUrl(), tabName, pageName);
    }






    /*
    @Test
    public void checkTabName(){
        MainPage mainPage = new MainPage(getDriver());

            IntStream.range(0,jsonFile.getPages().getUrlModelList().size()).forEach(i->{
                mainPage.load(jsonFile.getPages().getUrlModelList().get(i).getUrl());
                        Assert.assertEquals(mainPage.getTabName(), jsonFile.getPages().getUrlModelList().get(i).getTabName());
                    }
            );
    }
*/

}





