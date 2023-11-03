package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article3 extends BasePage {

    private final By  stephanXpath = By.xpath("//a[normalize-space()='Stephan Merkel']");
    private final String stephanPageTitle = "Sign In | LinkedIn";
    public Article3(WebDriver driver) {
        super(driver);
    }

    public Article3 load() {
        load("/de/agile-leadership-schon-wieder-ein-neuer-fuhrungsstil-oder-mehr-als-nur-ein-buzzword/");
        return this;
    }

    public Article3 checkStephanLink() {
        checkLink(stephanXpath, stephanPageTitle);
        return this;
    }
}
