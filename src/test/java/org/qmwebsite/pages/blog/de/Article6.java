package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article6 extends BasePage {

    private final By alianzXpath = By.xpath("//a[normalize-space()='http://www.it-mittelstandsallianz.de/partner/']");
    private final String alianzPageTitle = "Unsere Allianz - RVSE-Mittelstandsallianz";
    public Article6(WebDriver driver) {
        super(driver);
    }

    public Article6 load(){
        load("/de/7-rahmenvertrag-mit-der-bundesagentur-fur-arbeit/");
        return this;
    }

    public Article6 checkAlianzLink()
    {
        checkLink(alianzXpath, alianzPageTitle);
        return this;
    }
}
