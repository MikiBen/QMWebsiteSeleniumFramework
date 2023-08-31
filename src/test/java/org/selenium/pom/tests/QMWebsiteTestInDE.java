package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.de.MainPage;
import org.testng.annotations.Test;

public class QMWebsiteTestInDE extends BaseTest {

    @Test
    public void mainPageTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.load();
        System.out.println("CURRENT ADDRES: ");
        System.out.println(mainPage.getCcurrentAddress());

    }

}
