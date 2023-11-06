package org.qmwebsite.pages.blog.de;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qmwebsite.base.BasePage;

public class Article4 extends BasePage {
    private final By vereinXpath = By.xpath("//a[normalize-space()='Verein Brückenhaus e.V.']");
    private final String vereinPageTitle = "Brückenhaus e.V. Kirchheim unter Teck - Wir bauen Brücken!";
    //private final String vereinPageTitle = "";
    private final By hierXpath = By.xpath("//a[normalize-space()='hier']");
    private final String hierPageTitle = "Kinderferienprogramm - Brückenhaus e.V.";

    public Article4(WebDriver driver) {
        super(driver);
    }
    public Article4 load() {
        load("/de/elemente-von-scrum-in-der-kinder-und-jugendarbeit/");
        return this;
    }

    public Article4 checkVereinLink() {
        checkLink(vereinXpath, vereinPageTitle);
        return this;
    }

    public Article4 checkHierLink() {
        checkLinkWithEmptyTitle(hierXpath, hierPageTitle);
        return this;
    }

}
