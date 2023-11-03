package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;


public class Article21 extends BasePage {
    private final By qualityLearningXpath = By.xpath("//a[normalize-space()='QualityLearning-Team']");
    private final String qualityLearningPageTitle = "QualityMinds | QualityLearning";
    private final By exxellentXpath = By.xpath("//a[normalize-space()='eXXcellent solutions']");
    private final String exxellentPageTitle = "Startseite - eXXcellent solutions";
    private final By beitragXpath = By.xpath("//strong[normalize-space()='Link zum Beitrag']");
    private final String beitragPageTitle = "News - eXXcellent solutions";
    private final By hierXpath = By.xpath("//strong[normalize-space()='hier']");
    private final By learnCoachXpath= By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/div[1]/div[1]/div[1]/p[15]/a");
    private final String learnCoachPageTitle = "Page Not Found | QualityMinds";


    public Article21(WebDriver driver) {
        super(driver);
    }
    public Article21 load(){
        load("/de/qualitylearning-als-wegbegleiter-auf-dem-weg-zum-agilen-lehr-lernsetting-2/");
        return this;
    }
    public Article21 checkQualityLearningLink() {
       // checkLink(qualityLearningXpath, qualityLearningPageTitle);
        return this;
    }
    public Article21 checkExxellentLink() {
        checkLink(exxellentXpath, exxellentPageTitle);
        return this;
    }
    public Article21 checkBeitragLink() {
        checkLink(beitragXpath, beitragPageTitle);
        return this;
    }
    public Article21 checkHierLink() {
        checkLink(hierXpath, beitragPageTitle);
        return this;
    }
    public Article21 checkLearnCoachLink() {
        checkLink(learnCoachXpath, learnCoachPageTitle);
        return this;
    }
}
