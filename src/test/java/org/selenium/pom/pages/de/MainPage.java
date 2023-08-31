package org.selenium.pom.pages.de;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage load(){
        load("/");
        return this;
    }


}
