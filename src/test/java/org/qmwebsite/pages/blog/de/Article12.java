package org.qmwebsite.pages.blog.de;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article12 extends BasePage {
    private final By learnDochXpath = By.xpath("//a[contains(text(),'“Lern doch, was Du willst')]");
    private final By learnDochSecondXpath = By.xpath("//a[normalize-space()='Buch-Homepage']");
    private final String learnDochPageTitle = "QualityMinds | Lern doch, was Du willst!";
    public Article12(WebDriver driver) {
        super(driver);
    }
    public Article12 load(){
        load("/de/das-neue-qualityminds-buch-zum-agilen-lernen-ist-erschienen/");
        return this;
    }


    public Article12 checkLearnDochLink(){
        driver.findElement(learnDochXpath).click();
        Assert.assertEquals(learnDochPageTitle, driver.getTitle());
        driver.navigate().back();
        return this;
    }
    public Article12 checkLearnDochSecondLink(){
        driver.findElement(learnDochSecondXpath).click();
        Assert.assertEquals(learnDochPageTitle, driver.getTitle());
        driver.navigate().back();
        return this;
    }
}
