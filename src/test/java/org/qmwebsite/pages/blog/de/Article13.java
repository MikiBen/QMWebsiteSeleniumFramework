package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article13 extends BasePage {
    private final By colearnXpath = By.xpath("//a[normalize-space()='www.colearn.de']");
    private final String colearPageTitle = "Corporate Learning Community – Beiträge zur Entwicklung von Learning & Development aus der Corporate Learning Community";
    public Article13(WebDriver driver) {
        super(driver);
    }

    public Article13 load(){
        load("/de/learntec-2020-das-lernen-wir-digital/");
        return this;
    }
    public Article13 checkColearnLink()
    {
        checkLink(colearnXpath, colearPageTitle);
        return this;
    }
}
