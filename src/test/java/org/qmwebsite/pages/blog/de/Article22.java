package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qmwebsite.base.BasePage;

public class Article22 extends BasePage {
    private final By gehlenXpath = By.xpath("//a[normalize-space()='vgl. Gehlen-Baum & Illi, 2019']");
    private final String gehlenPageTitle = "QualityMinds | Lern doch, was Du willst!";
    public Article22(WebDriver driver) {
        super(driver);
    }
    public Article22 load(){
        load("/de/die-lange-des-lernsprints-2/");
        return this;
    }
    public Article22 checkGehlenLink() {
        checkLink(gehlenXpath, gehlenPageTitle);
        return this;
    }
}
