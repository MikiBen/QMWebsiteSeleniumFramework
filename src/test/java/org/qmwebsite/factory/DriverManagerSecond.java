package org.qmwebsite.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.qmwebsite.constans.DriverType;

public class DriverManagerSecond {
    public WebDriver initializeDriver(String browser){
        WebDriver driver = switch (DriverType.valueOf(browser)) {
            case CHROME -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                yield new ChromeDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().cachePath("Drivers").setup();
                yield new EdgeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                yield new FirefoxDriver();
            }
        };

        driver.manage().window().maximize();
        return driver;
    }
}
