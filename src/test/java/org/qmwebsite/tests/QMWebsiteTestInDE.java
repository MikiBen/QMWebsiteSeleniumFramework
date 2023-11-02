package org.qmwebsite.tests;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.qmwebsite.pages.blog.de.*;
import org.qmwebsite.pages.de.MainPage;
import org.qmwebsite.base.BaseTest;
import org.qmwebsite.pages.de.EventsDE;
import org.qmwebsite.pages.de.Footer;
import org.qmwebsite.pages.de.MainMenu;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
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


    @Test
    public void checkArticle1() {
        Article1 article = new Article1(getDriver());
        article.load()
                .checkHierLink()
                .checkMagazineLink();
    }

    @Test
    public void checkArticle2() {
    }
    @Test
    public void checkArticle3() {
        Article3 article = new Article3(getDriver());
        article.load().
                checkStephanLink();
    }

    @Test
    public void checkArticle4() {
        Article4 article = new Article4(getDriver());
        article.load().
                checkVereinLink().
                checkHierLink();
    }
    @Test
    public void checkArticle5(){
        Article5 article = new Article5(getDriver());
        article.load().
                checkUnsecoLink();
    }

    @Test
    public void checkArticle6(){
        Article6 article = new Article6(getDriver());
        article.load().
                checkAlianzLink();
    }

    @Test
    public void checkArticle9(){
        Article9 article = new Article9(getDriver());
        article.load().
                checkAgilenLink();
    }

    @Test
    public void checkArticle10(){
        Article10 article = new Article10(getDriver());
        article.load().
                checkStuttgartLink();
    }
    @Test
    public void checkArticle11() {
        Article11 article = new Article11(getDriver());
        article.load().
                //checkUnityLink().
                //checkLidarLink().
                //checkTensoLink().
                checkRaspberryLink().
                checkAlexanderLink();
    }
    @Test
    public void checkArticle12(){
        Article12 article = new Article12(getDriver());
        article.load().
                checkLearnDochLink().
                checkLearnDochSecondLink();
    }

    @Test
    public void checkArticle13(){
        Article13 article = new Article13(getDriver());
        article.load().
                checkColearnLink();
    }
    @Test
    public void checkArticle15(){
        Article15 article = new Article15(getDriver());
        article.load().
                checkKudoboxLink().
                checkAgilesLink();
    }
    @Test
    public void checkArticle16(){
        Article16 article = new Article16(getDriver());
        article.load().
                checkAgilerLink();
    }
    @Test
    public void checkArticle17(){
        Article17 article = new Article17(getDriver());
        article.load().
                //checkMagazinLink().
                checkAgilerLink().
                checkKiLink();

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
            mainMenu.checkQMStoreButton().
                    checkQMStoreButton();

    }
/*
    @Test
    public void checkExitsEventsPages(){
        EventsDE eventsDE = new EventsDE(getDriver());
        eventsDE.load("/de/veranstaltungen/");
        eventsDE.checkExitsPage();
    }
*/
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





