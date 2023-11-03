package org.qmwebsite.pages.blog.de;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article31 extends BasePage {

    private final By cornerXpath = By.xpath("//strong[normalize-space()='corner cases']");
    private final  String cornerPageTitle = "Qualitätssicherung von KI – Die Gefahren lauern vor allem hinter den Ecken | QualityMinds";
    private final By findBagXpath = By.xpath("//strong[normalize-space()='Find the Bug Sessions']");
    private final  String findBagPageTitle = "QualityHeroes Podcast Folge 21: Wie funktioniert eine Find-The-Bug-Session? | QualityMinds";
    private final By riskBagXpath = By.xpath("//strong[normalize-space()='Risk Storming']");
    private final  String riskBagPageTitle = "QualityHeroes Podcast Folge 20: Was ist ein Risk-Storming-Workshop und wie kann er einem Projektteam helfen? | QualityMinds";
    public Article31(WebDriver driver) {
        super(driver);
    }

    public Article31 load(){
        load("/de/meet-the-tester-bastian/");
        return this;
    }

    public Article31 checkCornerLink() {
        checkLinkOpensOnTheSamePage(cornerXpath,cornerPageTitle);
        return this;
    }

    public Article31 checkFindBagLink() {
        checkLinkOpensOnTheSamePage(findBagXpath,findBagPageTitle);
        return this;
    }

    public Article31 checkRiskLink() {
        checkLinkOpensOnTheSamePage(riskBagXpath,riskBagPageTitle);
        return this;
    }
}
