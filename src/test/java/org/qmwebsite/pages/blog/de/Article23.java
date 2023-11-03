package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article23 extends BasePage {
    private final By htcXpath = By.xpath("//a[normalize-space()='HTC Vive Setting']");
    private final String htcPageTitle = "VIVE Deutschland | Discover Virtual Reality Beyond Imagination";
    private final By oculusXpath = By.xpath("//a[normalize-space()='HTC Vive Setting']");
    private final String oculusPageTitle = "VIVE Deutschland | Discover Virtual Reality Beyond Imagination";
    public Article23(WebDriver driver) {
        super(driver);
    }

    public Article23 load(){
        load("/de/nextgencollab-update/");
        return this;
    }
    public Article23 checkHTCLink() {
        checkLink(htcXpath, htcPageTitle);
        return this;
    }
    public Article23 checkOculusLink() {
        checkLink(oculusXpath, oculusPageTitle);
        return this;
    }
}
