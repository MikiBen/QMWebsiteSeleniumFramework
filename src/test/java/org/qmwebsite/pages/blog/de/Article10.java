package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article10 extends BasePage {
    private final By stuttgartXpath = By.xpath("//a[normalize-space()='Stuttgart (29.- 30. Juni)']");
    private final String stuttgartPageTitle = "Home - CCON | COMIC CON STUTTGART";
    public Article10(WebDriver driver) {
        super(driver);
    }

    public Article10 load(){
        load("/de/helden-news-qualityminds-auf-der-comic-con-2019/");
        return this;
    }

    public Article10 checkStuttgartLink()
    {
        checkLink(stuttgartXpath, stuttgartPageTitle);
        return this;
    }
}
