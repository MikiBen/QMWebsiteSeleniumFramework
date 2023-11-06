package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article35 extends BasePage {

    private final By blogXpath = By.xpath("//a[normalize-space()='unserem erstem Blogbeitrag']");
    private final  String blogPageTitle = "Wie haben wir ohne große Schwierigkeiten die Nachhaltigkeit im Unternehmen verankert? | QualityMinds";
    private final By aktionXpath = By.xpath("//a[normalize-space()='Unternehmen Ehrensache IN AKTION']");
    private final  String aktionPageTitle = "\"Unternehmen Ehrensache IN AKTION\" - Einsatztag mal anders - Wir bleiben engagiert!";
    private final By sfzXpath = By.xpath("//a[normalize-space()='Sonderpädagogischen Förderzentrums Nürnberg']");
    private final  String sfzPageTitle = "Sonderpädagogisches Förderzentrum Jean-Paul-Platz Nürnberg - Home";
    private final By sciaraXpath = By.xpath("//a[normalize-space()='Homepage von SCIARA']");
    private final  String sciaraPageTitle = "Wirksam gegen den Klimawandel - SCIARA";
    private final By nextBlogXpath = By.xpath("//strong[normalize-space()='nächsten Blogbeitrag']");
    private final  String nextBlogPageTitle = "Klimaschutz durch Digitale Technologien – Gelebtes CSR bei QualityMinds | QualityMinds";
    public Article35(WebDriver driver) {
        super(driver);
    }
    public Article35 load(){
        load("/de/gelebte-nachhaltigkeit-und-csr-bei-qualityminds-erfolgsgeschichten-die-sich-sehen-lassen-koennen/");
        return this;
    }
    public Article35 checkBlogLink() {
        checkLinkOpensOnTheSamePage(blogXpath,blogPageTitle);
        return this;
    }
    public Article35 checkAktionLink() {
        checkLink(aktionXpath,aktionPageTitle);
        return this;
    }
    public Article35 checkSFZLink() {
        checkLink(sfzXpath,sfzPageTitle);
        return this;
    }
    public Article35 checkSciaraLink() {
        checkLink(sciaraXpath,sciaraPageTitle);
        return this;
    }

    public Article35 checkNextBlogLink() {
        checkLinkOpensOnTheSamePage(nextBlogXpath,nextBlogPageTitle);
        return this;
    }


}
