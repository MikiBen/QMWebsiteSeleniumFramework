package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article17 extends BasePage {
    private final By kiXpath = By.xpath("//a[normalize-space()='KI-Absicherung']");
    private final String kiPageTitle = "KI Absicherung: KI Absicherung";
    private final By bundesXpath = By.xpath("//a[normalize-space()='Bundesministerium für Wirtschaft und Klimaschutz']");
    private final String bundesPageTitle = "BMWK - Bundesministerium für Wirtschaft und Klimaschutz";
    private final By magazinXpath = By.xpath("//a[normalize-space()='German Testing Magazin']");
    private final String magazinPageTitle = "GermanTestingMagazin-1-2020-Druck.indb";
    public Article17(WebDriver driver) {
        super(driver);
    }
    public Article17 load(){
        load("/de/qualitatssicherung-von-ki-die-gefahren-lauern-vor-allem-hinter-den-ecken/");
        return this;
    }
    public Article17 checkKiLink() {
        checkLink(kiXpath, kiPageTitle);
        return this;
    }
    public Article17 checkAgilerLink() {
        checkLink(bundesXpath, bundesPageTitle);
        return this;
    }
    public Article17 checkMagazinLink() {
        checkLink(magazinXpath, magazinPageTitle);
        return this;
    }
}
