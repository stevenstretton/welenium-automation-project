package weleniumTests.automationTests;

import configurations.AutomationSetup;
import weleniumTests.pageObject.WebForm;
import org.junit.Test;
import weleniumTests.pageObject.formObjects.CompletedFormPage;

import static library.FormUtil.*;
import static library.FormUtil.DATE_2017;
import static library.FormUtil.MESSAGE;
import static library.NavigationUtil.NAVIGATE_TO_TEST_A;

/**
 * Created by stevenstretton on 25/09/2016.
 */
public class TestA extends WebForm {
    @SuppressWarnings("Duplicates")
    @Test
    public void testA() throws InterruptedException {

        char navigationChar = NAVIGATE_TO_TEST_A.getTestPage().charAt(0);
        AutomationSetup automationSetup = new AutomationSetup();
        CompletedFormPage completedFormPage = new CompletedFormPage();
        automationSetup.executeInitialisationSettings();
        navigateToFormWebpage(navigationChar);
        start();

        fillInForm(
                NAME_STEVEN_STRETTON.getFormData(),
                ADDRESS_SOMEWHERE_ST.getFormData(),
                EMAIL_STEVEN.getFormData(),
                PHONE_LOCAL.getFormData(),
                DATE_2017.getFormData(),
                MESSAGE.getFormData(),
                true
        );

        Thread.sleep(1000);

        submitForm();

        Thread.sleep(1000);

        completedFormPage.pageTitle("Thank You!");

        Thread.sleep(1000);

        automationSetup.endOfAutomationTest();

    }

}
