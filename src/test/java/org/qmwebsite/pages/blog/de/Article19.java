package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article19 extends BasePage {
    private final By facebookXpath = By.xpath("//a[contains(text(),'https://www.facebook.com/jamin.heppell/posts/10223')]");
    //private final String facebookPageTitle = "Jamin Heppell - I RAN FOR ME and then it became WE.";
    private final String facebookPageTitle = "";
    private final By baliXpath = By.xpath("//a[normalize-space()='https://www.balichildrenfoundation.org/support-us']");

    private final String baliPageTitle = "Bali Children Foundation";
    public Article19(WebDriver driver) {
        super(driver);
    }
    public Article19 load(){
        load("/de/9k-for-90k-bali-children-foundation-campaign/");
        return this;
    }
    public Article19 checkFacebookLink() {
        checkLink(facebookXpath, facebookPageTitle);
        return this;
    }
    public Article19 checkBaliLink() {
        checkLink(baliXpath, baliPageTitle);
        return this;
    }
}
