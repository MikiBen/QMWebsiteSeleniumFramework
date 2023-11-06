package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article38 extends BasePage {
    private final By sciaraXpath = By.xpath("//a[normalize-space()='SCIARA']");
   // private final  String sciaraPageTitle = "Wirksam gegen den Klimawandel - SCIARA";
    private final  String sciaraPageTitle = "";
    private final By potsdamerXpath = By.xpath("//a[normalize-space()='Potsdamer Instituts für Klimaforschung']");
    private final  String potsdamerPageTitle = "Potsdam-Institut für Klimafolgenforschung";
    private final By quyenXpath = By.xpath("//a[normalize-space()='Quyen']");
    //private final  String quyenPageTitle = "(20) Quyen P. | LinkedIn";
    private final  String quyenPageTitle = "Zaloguj się | LinkedIn";
    private final By umweltXpath = By.xpath("//a[normalize-space()='Deutsche Bundesstiftung Umwelt']");
    private final  String umweltPageTitle = "DBU - Deutsche Bundesstiftung Umwelt";
    public Article38(WebDriver driver) {
        super(driver);
    }

    public Article38 load(){
        load("/de/klimaschutz-durch-digitale-technologien-gelebtes-csr-bei-qualityminds/");
        return this;
    }

    public Article38 checkSciaraLink() {
        checkLink(sciaraXpath,sciaraPageTitle);
        return this;
    }
    public Article38 checkPotsdamLink() {
        checkLink(potsdamerXpath,potsdamerPageTitle);
        return this;
    }
    public Article38 checkQuyenLink() {
        checkLink(quyenXpath,quyenPageTitle);
        return this;
    }
    public Article38 checkUmweltLink() {
        checkLink(umweltXpath,umweltPageTitle);
        return this;
    }

}
