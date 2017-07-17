package weleniumTests.pageObject.formObjects;

import configurations.WeleniumFirefox;

/**
 * Created by stevenstretton on 06/12/2016.
 */
public class IndexObject
{
    private WeleniumFirefox weleniumFirefox = new WeleniumFirefox();

    public void selectTestA()
    {
        String TEST_A_URL = "http://localhost:8080/UIBox/forms/testA/form/form.html";
        weleniumFirefox.navigateToPage(TEST_A_URL);
    }

    public void selectTestB()
    {
        String TEST_B_URL = "http://localhost:8080/UIBox/forms/testB/form/form.html";
        weleniumFirefox.navigateToPage(TEST_B_URL);
    }

    public void selectTestC()
    {
        String TEST_C_URL = "http://localhost:8080/UIBox/forms/testC/form/form.html";
        weleniumFirefox.navigateToPage(TEST_C_URL);
    }

    public void invalidTestSelection()
    {
        System.out.println("invalid test selected");
    }
}
