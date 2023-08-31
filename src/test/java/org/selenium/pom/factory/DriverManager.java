package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.constans.DriverType;

public class DriverManager {
    public WebDriver initializeDriver(String browser){
        WebDriver driver;

        // localBrowser = browser;
        switch (DriverType.valueOf(browser)){
            case CHROME:
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().cachePath("Drivers").setup();
                driver = new EdgeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser : " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
