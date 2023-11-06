package org.qmwebsite.base;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.constans.DriverType;
import org.qmwebsite.jsonFile.JsonFile;
import org.qmwebsite.factory.DriverManagerSecond;
import org.qmwebsite.wdm.DriverManager;
import org.qmwebsite.wdm.DriverManagerFactory;
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

    @Parameters({"browser", "headless"})
    @BeforeMethod
    public void startDriver(@Optional String browser, @Optional String headless) {
        // browser = System.getProperty("browser", browser); //testNg

        DriverType myBrowser = DriverType.valueOf(resolve(browser, "browser", DriverType.FIREFOX));
        boolean myHeadless = Boolean.parseBoolean(resolve(headless, "headless", true));
        driver.set(myHeadless
                ? DriverManagerFactory.getManager(myBrowser).createDriverHeadless()
                : DriverManagerFactory.getManager(myBrowser).createDriver());
    }

    @AfterMethod
    public void quitDriver() {
        driver.get().quit();
    }

    private  <T> String resolve(String param, String prop, T defValue) {
        return isNullOrBlank(System.getProperty(prop))
                ? isNullOrBlank(param) ? String.valueOf(defValue) : param
                : System.getProperty(prop);
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

}
