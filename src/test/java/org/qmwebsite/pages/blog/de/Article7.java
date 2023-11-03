package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article7 extends BasePage {
    public Article7(WebDriver driver) {
        super(driver);
    }

    public Article7 load(){
        load("/de/qm-conference-input-und-fazit/");
        return this;
    }

}
