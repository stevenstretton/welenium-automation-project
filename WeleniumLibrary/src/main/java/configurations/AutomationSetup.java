package configurations;


/**
 * Created by stevenstretton on 25/09/2016.
 */
public class AutomationSetup {

    private FirefoxSettings firefoxSettings = new FirefoxSettings();

    public void executeInitialisationSettings() {
        firefoxSettings.getBrowser();
    }

    public void endOfAutomationTest() {
        firefoxSettings.closeBrowser();
    }

}
