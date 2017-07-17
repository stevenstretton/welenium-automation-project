package seleniumTests.pageObject.formObjects;


import configurations.WeleniumFirefox;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by stevenstretton on 27/09/2016.
 */
public class CompletedFormPage extends WeleniumFirefox
{
    @FindBy(css = "#name")
    private WebElement formMessage;

    public void pageTitle(String title)
    {
        System.out.println(title);
    }
}
