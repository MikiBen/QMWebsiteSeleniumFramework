package org.qmwebsite.base;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.qmwebsite.constans.DriverType;
import org.qmwebsite.jsonFile.JsonFile;
import org.qmwebsite.factory.DriverManagerSecond;
import org.qmwebsite.pages.de.Article;
import org.qmwebsite.utils.ConfigLoader;
import org.qmwebsite.wdm.DriverManager;
import org.qmwebsite.wdm.DriverManagerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

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

        DriverType myBrowser = DriverType.valueOf(resolve(browser, "browser", DriverType.CHROME));
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


    protected void checkLink(String pageName, String url, String xpath, List<String> tabName, Boolean getPageOpenInNewTab) {
        Article article = new Article(getDriver());
        try {
            article.load(url);
            //wait(500);
            if (!getPageOpenInNewTab) {
                article.checkLinkOpensOnTheSamePage(By.xpath(xpath), tabName, pageName, url);
            } else {
                article.checkLink(By.xpath(xpath), tabName, pageName, url);
            }
        } catch (TimeoutException | InvalidSelectorException e) {
            Assert.fail("Xpath: " + xpath + " is not available on page: " + ConfigLoader.getInstance().getBaseUrl() + url);
        } catch (Exception e) {
            Assert.fail("An exception occured on page: " + url);
        }

    }

    @DataProvider(name="AllUrlListDE")
    protected Object[] getAllUrlListDE() throws IOException {
        return (Object[]) readFileWithUrl("src/test/resources/DE/urlPagesAddressDE.json");
    }

    @DataProvider(name="AllUrlListENG")
    protected Object[] getAllUrlListENG() throws IOException {
        return (Object[]) readFileWithUrl("src/test/resources/ENG/urlPagesAddressENG.json");
    }

    @DataProvider(name="AllUrlListPL")
    protected Object[] getAllUrlListPL() throws IOException {
        return (Object[]) readFileWithUrl("src/test/resources/PL/urlPagesAddressPL.json");
    }

    @DataProvider(name="UrlListOnArticlesDE")
    protected Object[] getAllLinkOnArticlesDE() throws IOException {
        return (Object[]) readFileWithLinksOnPages("src/test/resources/DE/linkOnArticlesDEWithoutLinkedInProfile.json");
    }

    @DataProvider(name="UrlListOnBlogQualityHereosDE")
    protected Object[] getAllLinkOnBlogQualityHeroesDE() throws IOException {
        return (Object[]) readFileWithLinksOnPages("src/test/resources/DE/linkOnBlogQualityHeroesDEWithoutLinkedInProfile.json");
    }

    @DataProvider(name="UrlListOnBlogIWantChangeDE")
    protected Object[] getAllLinkOnBlogIWantChangeDE() throws IOException {
        return (Object[]) readFileWithLinksOnPages("src/test/resources/DE/linkOnBlogIWantChangeWithoutLinkedInProfile.json");
    }

    @DataProvider(name="UrlListWithRedirection")
    protected Object[] getUrlListWithRedirection() throws IOException {
        return (Object[]) readFileWithUrl("src/test/resources/DE/Redirection.json");
    }


    private Object readFileWithUrl (String path) throws IOException {

        jsonFile.readFileWithAllUrl(path);
        Object data[][]= new Object[jsonFile.getPages().getUrlModelList().size()][3];

        IntStream.range(0,jsonFile.getPages().getUrlModelList().size()).forEach(i-> {

            data[i][0] = jsonFile.getPages().getUrlModelList().get(i).getName();
            data[i][1] = jsonFile.getPages().getUrlModelList().get(i).getUrl();
            data[i][2] = jsonFile.getPages().getUrlModelList().get(i).getTabName();
        });
        return data;
    }

    private Object readFileWithLinksOnPages (String path) throws IOException {

        jsonFile.readFileWithAllLinksOnPages(path);
        Object data[][]= new Object[jsonFile.getLinks().getUrlOnPagesModelList().size()][5];

        IntStream.range(0,jsonFile.getLinks().getUrlOnPagesModelList().size()).forEach(i-> {

            data[i][0] = jsonFile.getLinks().getUrlOnPagesModelList().get(i).getName();
            data[i][1] = jsonFile.getLinks().getUrlOnPagesModelList().get(i).getPageAddress();
            data[i][2] = jsonFile.getLinks().getUrlOnPagesModelList().get(i).getXpath();
            data[i][3] = jsonFile.getLinks().getUrlOnPagesModelList().get(i).getTabName();
            data[i][4] = jsonFile.getLinks().getUrlOnPagesModelList().get(i).getPageOpenInNewTab();
        });
        return data;
    }
}
