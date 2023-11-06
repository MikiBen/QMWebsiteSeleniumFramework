package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article32 extends BasePage {
    private final By thomsonXpath = By.xpath("//a[normalize-space()='Thomson Reuters Labs']");
    private final  String thomsonPageTitle = "Join Thomson Reuters Labs | Thomson Reuters";
    //private final  String thomsonPageTitle = "";
    private final By jobAdsXpath = By.xpath("//a[normalize-space()='inclusive language for job ads']");
    private final  String jobAdsPageTitle = "Diversifier-NLP - Automated Text Analysis for more Inclusion in Job Ads";
    private final By kiXpath = By.xpath("//a[normalize-space()='KI-Absicherung']");
    private final  String kiPageTitle = "KI Absicherung: KI Absicherung";
    private final By namrataXpath = By.xpath("//a[normalize-space()='https://www.namratagurung.com/']");
    private final  String namrataPageTitle = "Home | Namrata Gurung";
    public Article32(WebDriver driver) {
        super(driver);
    }

    public Article32 load(){
        load("/de/meet-the-dev-namrata/");
        return this;
    }

    public Article32 checkThomsonLink() {
        checkLinkWithEmptyTitle(thomsonXpath,thomsonPageTitle);
        return this;
    }
    public Article32 checkJobsAdsLink() {
        checkLink(jobAdsXpath,jobAdsPageTitle);
        return this;
    }
    public Article32 checkKiLink() {
        checkLink(kiXpath,kiPageTitle);
        return this;
    }
    public Article32 checkNamaratLink() {
        checkLink(namrataXpath,namrataPageTitle);
        return this;
    }
}
