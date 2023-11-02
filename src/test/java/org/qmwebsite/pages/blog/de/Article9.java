package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article9 extends BasePage {
    private final By agilenzXpath = By.xpath("//a[contains(text(),'https://qualityminds.com/de/quality-learning/weite')]");
    private final String agilenPageTitle = "QualityMinds | Ausbildung zum agilen Lerncoach";
    public Article9(WebDriver driver) {
        super(driver);
    }

    public Article9 load(){
        load("/de/erste-einblicke-ausbildung-zum-agilen-lerncoach/");
        return this;
    }

    public Article9 checkAgilenLink()
    {
        checkLink(agilenzXpath, agilenPageTitle);
        return this;
    }
}
