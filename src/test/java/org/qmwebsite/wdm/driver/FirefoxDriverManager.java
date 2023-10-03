package org.qmwebsite.wdm.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.qmwebsite.wdm.DriverManager;

public class FirefoxDriverManager implements DriverManager {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().cachePath("drivers").setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public WebDriver createDriverHeadless() {
        WebDriverManager.firefoxdriver().cachePath("drivers").setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--window-size=1920,1080", "-headless");
        return new FirefoxDriver(options);
    }
}