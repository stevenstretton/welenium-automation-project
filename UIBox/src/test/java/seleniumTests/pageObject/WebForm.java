package seleniumTests.pageObject;

import configurations.FirefoxSettings;
import configurations.WeleniumFirefox;
import org.openqa.selenium.support.PageFactory;
import seleniumTests.pageObject.formObjects.FormObject;
import seleniumTests.pageObject.formObjects.IndexObject;


/**
 * Created by stevenstretton on 25/09/2016.
 */
public class WebForm
{
    private FormObject formObject;

    protected void start()
    {
        formObject = PageFactory.initElements(FirefoxSettings.driver, FormObject.class);
    }

    @SuppressWarnings("Duplicates")
    protected void navigateToFormWebpage(Character testToExecute)
    {
        String SIMPLE_FORM_URL = "http://localhost:8080/UIBox/";
        WeleniumFirefox weleniumFirefox = new WeleniumFirefox();
        weleniumFirefox.navigateToPage(SIMPLE_FORM_URL);

        IndexObject indexObject = new IndexObject();

        switch (testToExecute)
        {
            case 'A':
                indexObject.selectTestA();
                break;
            case 'B':
                indexObject.selectTestB();
                break;
            case 'C':
                indexObject.selectTestC();
                break;
            default:
                indexObject.invalidTestSelection();
                break;
        }

    }

    @SuppressWarnings("Duplicates")
    protected void fillInForm(String name, String address, String email, String telephone,
                           String date, String information, boolean termsAndConditions)
    {
        formObject.enterFormName(name);
        formObject.enterFormAddress(address);
        formObject.enterFormEmail(email);
        formObject.enterFormTelephoneNumber(telephone);
        formObject.enterFormDateOfAvailability(date);
        formObject.enterFormAdditionalInformation(information);
        isTermsAndConditionsChecked(termsAndConditions);
    }

    protected void submitForm()
    {
        formObject.submitForm();
    }

    private void isTermsAndConditionsChecked(boolean termsAndConditions)
    {
       if (termsAndConditions)
       {
           formObject.selectReadTermsAndConditions();
       }

    }
}
