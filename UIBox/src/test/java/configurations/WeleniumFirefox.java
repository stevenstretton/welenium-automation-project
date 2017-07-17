package configurations;

import configurations.drivers.WeleniumFirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import welenium.WebElement;
import weleniumTests.pageObject.WebForm;

import static configurations.FirefoxSettings.driver;

/**
 * Created by stevenstretton on 04/01/2017.
 */
public class WeleniumFirefox
{
    private WebElement element = new WebElement();

    public void navigateToPage(String ADDRESS)
    {
        pageFactoryConfig();
        WeleniumFirefoxDriver.goToPage(ADDRESS);
        element.collectElement();
    }

    public void getElement()
    {
         element.collectElement();
    }

    private void pageFactoryConfig()
    {
        PageFactory.initElements(driver, WebForm.class);
    }

}
