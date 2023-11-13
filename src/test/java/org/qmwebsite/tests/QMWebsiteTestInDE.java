package org.qmwebsite.tests;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.TimeoutException;
import org.qmwebsite.pages.de.*;
import org.qmwebsite.base.BaseTest;
import org.qmwebsite.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
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
    public void checkExitsEventsPages(){
        EventsDE eventsDE = new EventsDE(getDriver());
        eventsDE.load("/de/veranstaltungen/");
        eventsDE.checkExitsPage();
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

    @Test (dataProvider = "UrlList")
    public void checkTabName(String pageName, String url, String tabName){
        MainPage mainPage = new MainPage(getDriver());
                    mainPage.load(url);
                    Assert.assertEquals(mainPage.getTabName(), tabName);
    }

    @Test (dataProvider = "UrlList")
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

    @Test (dataProvider = "UrlList")
    public void checkMainMenu(String pageName, String url, String tabName){
        MainMenu mainMenu = new MainMenu(getDriver());
            mainMenu.load(url);
            mainMenu.checkQMStoreButton();
    }


    @Test(dataProvider="UrlListOnPages")
    public void checkUrlLinkOnPages(String pageName, String url, String xpath, List<String> tabName, Boolean getPageOpenInNewTab)
    {

        Article article = new Article(getDriver());
        try {
            article.load(url);
            if (!getPageOpenInNewTab) {
                article.checkLinkOpensOnTheSamePage(By.xpath(xpath), tabName, pageName, url);
            } else {
                article.checkLink(By.xpath(xpath), tabName, pageName, url);
            }
        }catch (TimeoutException | InvalidSelectorException e){
            Assert.fail("Xpath: " + xpath + " is not available on page: " + ConfigLoader.getInstance().getBaseUrl() + url);
        } catch (Exception e){
            Assert.fail("An exception occured on page: " + url);
        }

    }

    @DataProvider(name="UrlList")
    public Object[] myDataProvider() throws IOException {
        jsonFile.readFile();

        Object data[][]= new Object[jsonFile.getPages().getUrlModelList().size()][3];

        IntStream.range(0,jsonFile.getPages().getUrlModelList().size()).forEach(i-> {

            data[i][0] = jsonFile.getPages().getUrlModelList().get(i).getName();
            data[i][1] = jsonFile.getPages().getUrlModelList().get(i).getUrl();
            data[i][2] = jsonFile.getPages().getUrlModelList().get(i).getTabName();

        });
        return data;
    }

    @DataProvider(name="UrlListOnPages")
    public Object[] myDataProviderWithUrliLikOnPages() throws IOException {
        jsonFile.readFileWithUrlOnPages();

        Object data[][]= new Object[jsonFile.getUrls().getUrlOnPagesModelList().size()][5];

        IntStream.range(0,jsonFile.getUrls().getUrlOnPagesModelList().size()).forEach(i-> {

            data[i][0] = jsonFile.getUrls().getUrlOnPagesModelList().get(i).getName();
            data[i][1] = jsonFile.getUrls().getUrlOnPagesModelList().get(i).getPageAddress();
            data[i][2] = jsonFile.getUrls().getUrlOnPagesModelList().get(i).getXpath();
            data[i][3] = jsonFile.getUrls().getUrlOnPagesModelList().get(i).getTabName();
            data[i][4] = jsonFile.getUrls().getUrlOnPagesModelList().get(i).getPageOpenInNewTab();
        });
        return data;
    }

}





