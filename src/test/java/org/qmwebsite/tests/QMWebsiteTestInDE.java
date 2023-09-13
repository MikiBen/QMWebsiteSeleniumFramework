package org.qmwebsite.tests;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.qmwebsite.jsonFile.UrlModel;
import org.qmwebsite.pages.de.MainPage;
import org.qmwebsite.base.BasePage;
import org.qmwebsite.base.BaseTest;
import org.qmwebsite.pages.de.EventsDE;
import org.qmwebsite.pages.de.Footer;
import org.qmwebsite.pages.de.MainMenu;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
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

/*    @Test
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
    }*/


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
                            checkTwitterButton().
                            checkLinkedInButton().
                            checkFacebookButton().
                            checkXingButton().
                            checkFeedButton();
                }


    @Test (dataProvider = "UrlList")
    public void checkMainMenu(String pageName, String url, String tabName){
        MainMenu mainMenu = new MainMenu(getDriver());
            mainMenu.load(url);
            mainMenu.checkQMStoreButton().
                    checkQMStoreButton();

    }

    @Test
    public void checkExitsEventsPages(){
        EventsDE eventsDE = new EventsDE(getDriver());
        eventsDE.load("/de/veranstaltungen/");
        eventsDE.checkExitsPage();
    }

    //This method will provide data to any test method that declares that its Data Provider
    @Test(dataProvider="UrlList")
    public void studentRegistration(String pageName, String url, String tabName)
    {
        System.out.println(""+pageName+" "+url+" "+tabName);
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


}





