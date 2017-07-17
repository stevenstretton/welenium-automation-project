package seleniumTests.pageObject.formObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by stevenstretton on 27/09/2016.
 */
public class FormObject
{
    @FindBy(css = "#name")
    private WebElement formName;
    @FindBy(css = "#address")
    private WebElement formAddress;
    @FindBy(css = "#email")
    private WebElement formEmail;
    @FindBy(css = "#telephone")
    private WebElement formTelephoneNumber;
    @FindBy(css = "#date")
    private WebElement formDateOfAvailability;
    @FindBy(css = "#additional")
    private WebElement formAdditionalInformation;
    @FindBy(css = "#checkbox")
    private WebElement formConfirmTermsAndConditions;
    @FindBy(css = "html>body>table>tbody>tr>td>a>button")
    private WebElement formSubmit;


    public void enterFormName(String name)
    {
        formName.sendKeys(name);
    }

    public void enterFormAddress(String address)
    {
        formAddress.sendKeys(address);
    }

    public void enterFormEmail(String email)
    {
        formEmail.sendKeys(email);
    }

    public void enterFormTelephoneNumber(String telephone)
    {
        formTelephoneNumber.sendKeys(telephone);
    }

    public void enterFormDateOfAvailability(String dateOfAvailability)
    {
        formDateOfAvailability.sendKeys(dateOfAvailability);
    }

    public void enterFormAdditionalInformation(String additionalInformation)
    {
        formAdditionalInformation.sendKeys(additionalInformation);
    }

    public void selectReadTermsAndConditions()
    {
        formConfirmTermsAndConditions.click();
    }

    public void submitForm()
    {
        formSubmit.click();
    }

}
