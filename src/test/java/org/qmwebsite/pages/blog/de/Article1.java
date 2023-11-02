package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article1 extends BasePage {

    public Article1(WebDriver driver) {
        super(driver);
    }

    private final By hierXpath = By.xpath("//a[normalize-space()='hier']");
    private final String hierPageTitle = "SQ-Magazin 44 by International Software Quality Institute - Issuu";
    private final By magazineXpath = By.xpath("//a[normalize-space()='SQ-Magazin']");
    private final String magazinePageTitle = "Ihr Fachmagazin für Softwarequalität - SQ Magazin";


    public Article1 load() {
        load("/de/agilitat-ist-kopfsache/");
        return this;
    }

    public Article1 checkHierLink() {
        checkLink(hierXpath, hierPageTitle);
        return this;
    }

    public Article1 checkMagazineLink() {
        checkLink(magazineXpath, magazinePageTitle);
        return this;
    }


}
