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
/*

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
                checkLidarLink().
                checkTensoLink().
                checkUnityLink().
                load().
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
                //heckMagazineLink();
                checkBundesLink().
                checkTestLink();
                //checkKiLink();
    }

    @Test
    public void checkArticle19(){
        Article19 article = new Article19(getDriver());
        article.load().
                checkFacebookLink().
                checkBaliLink();
    }
    @Test
    public void checkArticle21(){
        Article21 article = new Article21(getDriver());
        article.load().
                //checkBeitragLink().
                //checkExxellentLink().
                //checkHierLink().
                checkQualityLearningLink().
                checkLearnCoachLink();
    }
    @Test
    public void checkArticle22(){
        Article22 article = new Article22(getDriver());
        article.load().
                checkGehlenLink();
    }

    @Test
    public void checkArticle23(){
        Article23 article = new Article23(getDriver());
        article.load().
                checkHTCLink().
                checkOculusLink();
    }
    @Test
    public void checkArticle30() {
        Article30 article = new Article30(getDriver());
        article.load().
                checkAGHLink().
                checkVlogLink().
                checkPodcastLink().
                checkHereLink();
    }
    @Test
    public void checkArticle31() {
        Article31 article = new Article31(getDriver());
        article.load().
                checkFindBagLink().
                checkCornerLink().
                checkRiskLink();
    }

    @Test
    public void checkArticle32() {
        Article32 article = new Article32(getDriver());
        article.load().
                checkThomsonLink().
                checkNamaratLink().
                checkJobsAdsLink().
                checkKiLink();
    }
    @Test
    public void checkArticle35() {
        Article35 article = new Article35(getDriver());
        article.load().
                checkBlogLink().
                checkSFZLink().
                checkAktionLink().
                checkSciaraLink().
                checkNextBlogLink();
    }
    @Test
    public void checkArticle38() {
        Article38 article = new Article38(getDriver());
        article.load().
                checkSciaraLink().
                checkPotsdamLink().
                checkQuyenLink().
                checkUmweltLink();
    }

    @Test
    public void checkArticle39() {
        Article39 article = new Article39(getDriver());
        article.load().
                checkSoftwareLink();
    }

    @Test
    public void checkArticle40() {
        Article40 article = new Article40(getDriver());
        article.load().
                checkEnterproseLink().
                checkInovationsLink().
                checkSustainableLink();
    }


*/


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





