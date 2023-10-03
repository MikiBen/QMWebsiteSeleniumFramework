package org.qmwebsite.wdm;

import org.openqa.selenium.WebDriver;

public interface DriverManager {
    WebDriver createDriver();
    WebDriver createDriverHeadless();
}
