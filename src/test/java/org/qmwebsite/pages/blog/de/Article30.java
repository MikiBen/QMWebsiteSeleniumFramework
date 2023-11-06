package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article30 extends BasePage {

    private final By aghXpath = By.xpath("//a[normalize-space()='AGH Racing']");
    private final  String aghPageTitle = "AGH Racing – Zespół wyścigowy Formuły Student";
    private final By vlogXpath = By.xpath("//a[normalize-space()='travel vlog']");
    //private final  String vlogPageTitle = "Zanim przejdziesz do YouTube";
    private final  String vlogPageTitle = "[]";
    private final By podcastXpath = By.xpath("//p[contains(text(),'Listen to the QualityHeroes Podcast episode “What ')]//strong[contains(text(),'here')]");
    private final  String podcastPageTitle = "QualityHeroes Podcast Folge 32: What is DevOps? | QualityMinds";
    private final By hereXpath = By.xpath("//a[@href='https://qualityminds.com/de/services/softwareentwicklung/devops/']//strong[contains(text(),'here')]");
    private final  String herePageTitle = "QualityMinds | DevOps";

    public Article30(WebDriver driver) {
        super(driver);
    }
    public Article30 load(){
        load("/de/meet-the-devops-jakub/");
        return this;
    }
    public Article30 checkAGHLink()  {
        checkLink(aghXpath, aghPageTitle);
        return this;
    }
    public Article30 checkVlogLink() {
        checkLink(vlogXpath, vlogPageTitle);
        return this;
    }
    public Article30 checkPodcastLink() {
        checkLink(podcastXpath, podcastPageTitle);
        return this;
    }
    public Article30 checkHereLink() {
        checkLink(hereXpath, herePageTitle);
        return this;
    }
}
