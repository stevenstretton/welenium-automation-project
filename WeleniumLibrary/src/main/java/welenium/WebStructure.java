package welenium;

import configurations.drivers.WeleniumFirefoxDriver;
import welenium.elements.XpathElementCollector;
import welenium.elements.XpathExpressionBuilder;
import welenium.exceptions.NoElementFoundException;

/**
 * Created by stevenstretton on 14/12/2016.
 */
public class WebStructure {
    private String extractedPath;
    private String htmlSource;

    String getExtractedPath() {
        return extractedPath;
    }

    void getHtmlStructure() {
        htmlSource = WeleniumFirefoxDriver.getFirefoxSource();
    }

    void scanStructure(String keyword, Boolean isSendKeyAndClick) throws NoElementFoundException {
        if (containsValidValue(htmlSource, keyword)) {
            extractedPath = extractPathFromStructure(keyword, isSendKeyAndClick);
        } else {
            throw new NoElementFoundException("The element keyword you have entered" +
                    " is not associated to this webpage. Element: " + keyword);
        }
    }

    void scanStructureForText(String text) {
        extractedPath = extractPathFromStructureForText(text);
    }


    private boolean containsValidValue(String extractableDomSource, String keyword) {
        return extractableDomSource.contains(keyword);
    }

    private String extractPathFromStructure(String keyword, Boolean isSendKeyAndClick) {
        XpathElementCollector xpathElementCollector = new XpathElementCollector();
        xpathElementCollector.getHtmlElements(htmlSource, keyword, isSendKeyAndClick);

        return xpathElementCollector.getGeneratedXpath();
    }

    private String extractPathFromStructureForText(String text) {
        XpathExpressionBuilder xpathExpressionBuilder = new XpathExpressionBuilder();
        xpathExpressionBuilder.createExpressionFromText(text);

        return xpathExpressionBuilder.getGeneratedXpath();
    }


}
