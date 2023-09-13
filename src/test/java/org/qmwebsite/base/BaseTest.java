package org.qmwebsite.base;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.constans.DriverType;
import org.qmwebsite.jsonFile.JsonFile;
import org.qmwebsite.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;

@Log
public class BaseTest {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected final JsonFile jsonFile = new JsonFile();

    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){

        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(@Optional String browser) throws IOException {
        // browser = System.getProperty("browser", browser); //testNg

        jsonFile.readFile();
        if(browser ==null) browser = "CHROME";
        setDriver(new DriverManager().initializeDriver(browser));// może to zastopić
        // DriverType driverType = DriverType.valueOf(browser.toUpperCase());

        log.info("CURRENT THREAD: " + Thread.currentThread().getId() + " DRIVER : " + getDriver());
    }

    @AfterMethod
    public void quitDriver() {
        driver.get().quit();
    }

}
