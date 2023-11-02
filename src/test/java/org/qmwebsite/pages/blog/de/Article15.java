package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article15 extends BasePage {
    private final By kudoboxXpath = By.xpath("//a[normalize-space()='(http://kudobox.co/)']");
    private final String kudoboxPageTitle = "Kudobox";
    private final By agilesXpath = By.xpath("//a[normalize-space()='https://www.agileteams.de/plus/agile-games/']");
    private final String agilesPageTitle = "Agile Games - AgileTeams.de: Das große Portal für agile Teams und agile Unternehmen | Agile Literatur | Agile Artikel | Agile Videos | Agile Studien | Agiler Blog";
    public Article15(WebDriver driver) {
        super(driver);
    }
    public Article15 load(){
        load("/de/der-remote-scrum-master-wie-die-empathie-nicht-auf-der-strecke-bleibt/");
        return this;
    }
    public Article15 checkKudoboxLink()
    {
        checkLink(kudoboxXpath, kudoboxPageTitle);
        return this;
    }
    public Article15 checkAgilesLink()
    {
        checkLink(agilesXpath, agilesPageTitle);
        return this;
    }
}
