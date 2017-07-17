package weleniumTests.pageObject.formObjects;

import configurations.WeleniumFirefox;
import welenium.WeleniumElement;

/**
 * Created by stevenstretton on 27/09/2016.
 */
public class CompletedFormPage extends WeleniumFirefox
{
    private WeleniumElement formPage = new WeleniumElement();

    public void pageTitle(String title) {
        formPage.readFromPage(title);
    }
}
