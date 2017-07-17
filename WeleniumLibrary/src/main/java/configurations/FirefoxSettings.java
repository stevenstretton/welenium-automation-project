package configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Created by stevenstretton on 04/09/2016.
 */
public class FirefoxSettings {

    private FirefoxProfile firefoxProfile = new FirefoxProfile();

    public static WebDriver driver = new FirefoxDriver();

    public static WebDriver navigateToPage(String webpage) {
        driver.get(webpage);
        return driver;
    }

    WebDriver getBrowser() {
        setupBrowser();
        return driver;
    }

    WebDriver closeBrowser() {
        driver.quit();
        return driver;
    }

    private WebDriver setupBrowser() {
        setBrowserSize();
        setBrowserHomepage();
        clearAllBrowserCookies();

        return driver;
    }

    private WebDriver setBrowserSize() {
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver setBrowserHomepage() {
        String BLANK_HOMEPAGE = "about:blank";

        firefoxProfile.setPreference("browser.startup.homepage", BLANK_HOMEPAGE);
        firefoxProfile.setPreference("startup.homepage_welcome_url", BLANK_HOMEPAGE);
        firefoxProfile.setPreference("startup.homepage_welcome_url.additional", BLANK_HOMEPAGE);
        firefoxProfile.setPreference("network.proxy.type", "1");

        return driver;
    }

    private WebDriver clearAllBrowserCookies() {
        driver.manage().deleteAllCookies();
        return driver;
    }

}
