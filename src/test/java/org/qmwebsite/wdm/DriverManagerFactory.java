package org.qmwebsite.wdm;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.qmwebsite.constans.DriverType;
import org.qmwebsite.wdm.driver.ChromeDriverManager;
import org.qmwebsite.wdm.driver.EdgeDriverManager;
import org.qmwebsite.wdm.driver.FirefoxDriverManager;

@UtilityClass
public class DriverManagerFactory {

    @Contract("_ -> new")
    public @NotNull DriverManager getManager(@NotNull DriverType driverType) {
        return switch (driverType) {
            case CHROME -> new ChromeDriverManager();
            case FIREFOX -> new FirefoxDriverManager();
            case EDGE -> new EdgeDriverManager();
        };
    }
}