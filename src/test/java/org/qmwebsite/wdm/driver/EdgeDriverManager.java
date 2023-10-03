package org.qmwebsite.wdm.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.qmwebsite.wdm.DriverManager;

public class EdgeDriverManager implements DriverManager {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.edgedriver().cachePath("drivers").setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public WebDriver createDriverHeadless() {
        WebDriverManager.edgedriver().cachePath("drivers").setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--window-size=1920,1080", "--headless=new");
        return new EdgeDriver(options);
    }
}