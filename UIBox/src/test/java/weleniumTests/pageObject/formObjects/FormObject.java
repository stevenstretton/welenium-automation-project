package weleniumTests.pageObject.formObjects;

import configurations.WeleniumFirefox;
import welenium.WeleniumElement;

/**
 * Created by stevenstretton on 27/09/2016.
 */
public class FormObject
{
    private WeleniumElement formPage = new WeleniumElement();
    private WeleniumFirefox weleniumFirefox = new WeleniumFirefox();

    public void enterFormName(String name)
    {
        formPage.writeToPage(name, "name");
    }

    public void enterFormAddress(String address)
    {
        formPage.writeToPage(address, "address");
    }

    public void enterFormEmail(String email)
    {
        formPage.writeToPage(email, "email");
    }

    public void enterFormTelephoneNumber(String telephone)
    {
        formPage.writeToPage(telephone, "telephone");
    }

    public void enterFormDateOfAvailability(String dateOfAvailability)
    {
        formPage.writeToPage(dateOfAvailability, "date");
    }

    public void enterFormAdditionalInformation(String additionalInformation)
    {
        formPage.writeToPage(additionalInformation, "additional");
    }

    public void selectReadTermsAndConditions()
    {
        formPage.selectOnPage("checkbox");
    }

    public void submitForm()
    {
        formPage.selectOnPage("submit");
        weleniumFirefox.getElement();
    }

}
