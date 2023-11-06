package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article40 extends BasePage {
    private final By enterpriseXpath = By.xpath("//a[normalize-space()='Enterprise Europe Network der Bayern Innovativ']");
    private final  String enteprisePageTitle = "EEN - Enterprise Europe Network";
    private final By inovationsXpath = By.xpath("//a[normalize-space()='Innovations-Assessment']");
    private final  String inovationsPageTitle = "Assessments der Bayern Innovativ – Ihr Erfolgsplan für die Zukunft";
    private final By sustainableXpath = By.xpath("//strong[normalize-space()='Sustainable Development Goals']");
    private final  String sustainablePageTitle = "THE 17 GOALS | Sustainable Development";
    public Article40(WebDriver driver) {
        super(driver);
    }
    public Article40 load(){
        load("/de/wie-innovativ-und-nachhaltig-ist-qualityminds-eigentlich/");
        return this;
    }

    public Article40 checkEnterproseLink() {
        checkLink(enterpriseXpath,enteprisePageTitle);
        return this;
    }

    public Article40 checkInovationsLink() {
        checkLink(inovationsXpath,inovationsPageTitle);
        return this;
    }
    public Article40 checkSustainableLink() {
        checkLink(sustainableXpath,sustainablePageTitle);
        System.out.println("ddd");
        return this;
    }
}
