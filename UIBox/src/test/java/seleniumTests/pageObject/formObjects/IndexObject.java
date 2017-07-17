package seleniumTests.pageObject.formObjects;

import configurations.FirefoxSettings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by stevenstretton on 06/12/2016.
 */
public class IndexObject
{
    @FindBy(css = "#itemList>ul>li:nth-child(1)>a")
    private WebElement testA;
    @FindBy(css = "#itemList>ul>li:nth-child(2)>a")
    private WebElement testB;
    @FindBy(css = "#itemList>ul>li:nth-child(3)>a")
    private WebElement testC;

    public void selectTestA()
    {
        String TEST_A_URL = "http://localhost:8080/UIBox/forms/testA/form/form.html";
        FirefoxSettings.navigateToPage(TEST_A_URL);
    }

    public void selectTestB()
    {
        String TEST_B_URL = "http://localhost:8080/UIBox/forms/testB/form/form.html";
        FirefoxSettings.navigateToPage(TEST_B_URL);
    }

    public void selectTestC()
    {
        String TEST_C_URL = "http://localhost:8080/UIBox/forms/testC/form/form.html";
        FirefoxSettings.navigateToPage(TEST_C_URL);
    }

    public void invalidTestSelection()
    {
        System.out.println("invalid test selected");
    }
}
