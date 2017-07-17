package welenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import welenium.exceptions.ElementMissingFromPathException;

import static configurations.FirefoxSettings.driver;

/**
 * Created by stevenstretton on 25/10/2016.
 */
public class VerifyElementFound {
    private WeleniumLogger logger = new WeleniumLogger();

    public void processElementVerificationOnSendKey(String value, String extractedElement)
            throws ElementMissingFromPathException {
        if (containsElement(extractedElement)) {
            processElementRequestOnSendKeys(value, extractedElement);
        } else {
            throw new ElementMissingFromPathException(extractedElement);
        }
    }

    public void processElementVerificationOnClick(String extractedElement) throws ElementMissingFromPathException {
        if (containsElement(extractedElement)) {
            processElementRequestOnClick(extractedElement);
        } else {
            throw new ElementMissingFromPathException(extractedElement);
        }
    }

    public void processElementVerificationOnRead(String extractedElement) throws ElementMissingFromPathException {
        if (containsElement(extractedElement)) {
            processElementRequestOnRead(extractedElement);
        } else {
            throw new ElementMissingFromPathException(extractedElement);
        }
    }

    private boolean containsElement(String extractedElement) {
        return extractedElement != null;
    }

    private void processElementRequestOnSendKeys(String value, String passedElement) {
        By path = By.xpath(passedElement);
        logger.getGeneratedPathOnSendKey(passedElement);

        WebElement element = driver.findElement(path);
        element.sendKeys(value);
    }

    private void processElementRequestOnClick(String passedElement) {
        By path = By.xpath(passedElement);
        logger.getGeneratedPathOnClick(passedElement);

        WebElement element = driver.findElement(path);
        element.click();
    }

    private void processElementRequestOnRead(String passedElement) {
        By path = By.xpath(passedElement);
        logger.getGeneratedPathOnTextSearch(passedElement);

        WebElement element = driver.findElement(path);
        element.getText();
    }
}
