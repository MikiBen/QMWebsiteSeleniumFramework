package org.qmwebsite.pages.blog.de;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.base.BasePage;

public class Article11 extends BasePage {
    private final By lidarXpath = By.xpath("//a[normalize-space()='LiDAR']");
    private final String lidarPageTitle = "Lidar - Wikipedia";
    private final By raspberryXpath = By.xpath("//a[normalize-space()='Raspberry Pi']");
    private final String raspberryPageTitle = "Teach, learn, and make with the Raspberry Pi Foundation";
    private final By unityXpath = By.xpath("//a[normalize-space()='Unity']");
   // private final String unityPageTitle = "Unity Echtzeit-Entwicklungsplattform | 3D-, 2D-, VR- und AR-Engine";
    private final String unityPageTitle = "Access Denied";
    private final By tensoXpath = By.xpath("//a[normalize-space()='Tensorflow']");
    private final String tensoPageTitle = "TensorFlow";
    private final By alexanderXpath = By.xpath("//a[normalize-space()='Alexander Pohl']");
    //private final String alexanderPageTitle = "Alexander Pohl - Greater Munich Metropolitan Area | Professional Profile | LinkedIn";
    private final String alexanderPageTitle = "";
    public Article11(WebDriver driver) {
        super(driver);
    }

    public Article11 load(){
        load("/de/building-a-simple-autonomous-mobile-robot/");
        return this;
    }

    public Article11 checkLidarLink()
    {
        checkLink(lidarXpath, lidarPageTitle);
        return this;
    }
    public Article11 checkRaspberryLink()
    {
        checkLink(raspberryXpath, raspberryPageTitle);
        return this;
    }

    public Article11 checkUnityLink()
    {
        checkLink(unityXpath, unityPageTitle);
        return this;
    }
    public Article11 checkTensoLink()
    {
        checkLink(tensoXpath, tensoPageTitle);
        return this;
    }

    public Article11 checkAlexanderLink()
    {
        checkLink(alexanderXpath, alexanderPageTitle);
        return this;
    }
}
