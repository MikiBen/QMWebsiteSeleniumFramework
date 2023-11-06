package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article39 extends BasePage {

    private final By softwareXpath = By.xpath("//a[normalize-space()='Software Bauhaus']");
    private final  String softwarePageTitle = "QualityMinds | Agile Software-Entwicklungsteams";
    public Article39(WebDriver driver) {
        super(driver);
    }

    public Article39 load(){
        load("/de/meet-the-dev-ralph/");
        return this;
    }

    public Article39 checkSoftwareLink() {
        checkLink(softwareXpath,softwarePageTitle);
        return this;
    }
}
