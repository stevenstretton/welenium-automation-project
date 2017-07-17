package configurations.drivers;

import configurations.FirefoxSettings;
import org.openqa.selenium.WebDriver;

import static configurations.FirefoxSettings.driver;

/**
 * Created by stevenstretton on 02/01/2017.
 */
public class WeleniumFirefoxDriver {

    public static void goToPage(String link) {
        goToFirefoxURL(link);
    }

    public static String getFirefoxSource() {
        return driver.getPageSource();
    }

    private static WebDriver goToFirefoxURL(String link) {
        return FirefoxSettings.navigateToPage(link);
    }

}
