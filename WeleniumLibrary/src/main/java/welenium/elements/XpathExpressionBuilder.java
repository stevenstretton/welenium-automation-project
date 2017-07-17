package welenium.elements;

import welenium.elements.library.XpathLibrary;

import java.util.List;

/**
 * Created by stevenstretton on 31/01/2017.
 */
public class XpathExpressionBuilder {

    private String finalisedXpath = "";

    public void createExpression(String element, String type, String attribute) {
        if (isElementValid(element)) {
            finalisedXpath = attributeAllocator(element, type, attribute, false);
        }
    }

    public void createExpressionFromText(String text) {
        finalisedXpath = attributeAllocator(null, text, null, true);
    }

    public String getGeneratedXpath() {
        return finalisedXpath;
    }

    private String attributeAllocator(String element, String type, String attribute, boolean forTextSearch) {
        XpathAttributeGenerator xpathAttributeGenerator = new XpathAttributeGenerator();
        String setAttribute;

        if (forTextSearch) {
            setAttribute = xpathAttributeGenerator.getAttributeForText(type);
        } else {
            setAttribute = xpathAttributeGenerator.getAttribute(element, type, attribute);
        }

        return String.valueOf(
                XpathLibrary.XPATH_CONTAINS_OPENING_TAG.getTagName()) +
                setAttribute +
                XpathLibrary.XPATH_CONTAINS_CLOSING_TAG.getTagName();
    }


    private boolean isElementValid(String element) {
        boolean isConfirmed = false;

        XpathElementCollector xpathElementCollector = new XpathElementCollector();
        List<String> collectedAttributes = xpathElementCollector.getCollectedAttributes();

        for (String collectedAttribute : collectedAttributes) {
            if (collectedAttribute.equals(element)) {
                isConfirmed = true;
                break;
            }
        }

        return isConfirmed;
    }
}
