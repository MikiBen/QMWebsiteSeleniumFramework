package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article16 extends BasePage {
    private final By agilerXpath = By.xpath("//a[normalize-space()='www.agiler-Lerncoach.de']");
    private final String agilerPageTitle = "QualityMinds | Ausbildung zum agilen Lerncoach";
    public Article16(WebDriver driver) {
        super(driver);
    }
    public Article16 load(){
        load("/de/so-geht-prufung-digital-ein-positives-beispiel-in-covid19-zeiten/");
        return this;
    }

    public Article16 checkAgilerLink()
    {
        checkLink(agilerXpath, agilerPageTitle);
        return this;
    }
}
