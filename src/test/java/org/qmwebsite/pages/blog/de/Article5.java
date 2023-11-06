package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article5 extends BasePage {

    private final By unescoXpath = By.xpath("//a[contains(text(),'https://en.unesco.org/news/general-assembly-procla')]");
    private final String unescoPageTitle = "UNESCO : Building Peace through Education, Science and Culture, communication and information";
    public Article5(WebDriver driver) {
        super(driver);
    }

    public Article5 load(){
        load("/de/mit-lern-stories-zum-lernerfolg-in-agilen-teams-ein-beitrag-zum-internationalen-tag-der-bildung/");
        return this;
    }

    public Article5 checkUnsecoLink()
    {
        checkLink(unescoXpath, unescoPageTitle);
        return this;
    }
}
