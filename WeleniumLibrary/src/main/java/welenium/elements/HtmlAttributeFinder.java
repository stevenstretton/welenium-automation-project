package welenium.elements;

import welenium.elements.library.HtmlAttributeLibrary;

import static welenium.elements.library.HtmlAttributeLibrary.*;

/**
 * Created by stevenstretton on 07/02/2017.
 */
public class HtmlAttributeFinder {

    private String htmlElementFromExtractor;
    private String collectedAttribute;
    private final String START_ATTRIBUTE_TAG = "=\"";
    private final String END_ATTRIBUTE_TAG = "\"";

    public String getAttributeFromElement(String htmlElementFromExtractor) {

        this.htmlElementFromExtractor = htmlElementFromExtractor;

        HtmlAttributeLibrary attributeCollection[] = {ID, NAME, PLACEHOLDER, TYPE};

        for (HtmlAttributeLibrary givenAttribute : attributeCollection) {
            if (htmlElementFromExtractor.contains(givenAttribute.getHtmlAttributeName())) {
                callAttributeProcess(givenAttribute.getHtmlAttributeName());
                break;
            }
        }

        return collectedAttribute;
    }

    private void callAttributeProcess(String providedAttribute) {
        if (providedAttribute.equals(ID.getHtmlAttributeName())) {
            processIdAttribute();

        } else if (providedAttribute.equals(NAME.getHtmlAttributeName())) {
            processNameAttribute();

        } else if (providedAttribute.equals(PLACEHOLDER.getHtmlAttributeName())) {
            processPlaceholderAttribute();

        } else if (providedAttribute.equals(TYPE.getHtmlAttributeName())) {
            processTypeAttribute();

        }
    }

    private String processIdAttribute() {
        String[] trimElementLeft = htmlElementFromExtractor.split(ID.getHtmlAttributeName() + START_ATTRIBUTE_TAG);
        String[] trimElementRight = trimElementLeft[1].split(END_ATTRIBUTE_TAG, 2);

        return collectedAttribute = trimElementRight[0];
    }

    private String processNameAttribute() {
        String[] trimElementLeft = htmlElementFromExtractor.split(NAME.getHtmlAttributeName() + START_ATTRIBUTE_TAG);
        String[] trimElementRight = trimElementLeft[1].split(END_ATTRIBUTE_TAG, 2);

        return collectedAttribute = trimElementRight[0];
    }

    private String processPlaceholderAttribute() {
        String[] trimElementLeft = htmlElementFromExtractor.split(PLACEHOLDER.getHtmlAttributeName()
                + START_ATTRIBUTE_TAG);
        String[] trimElementRight = trimElementLeft[1].split(END_ATTRIBUTE_TAG, 2);

        return collectedAttribute = trimElementRight[0];
    }

    private String processTypeAttribute() {
        String[] trimElementLeft = htmlElementFromExtractor.split(TYPE.getHtmlAttributeName() + START_ATTRIBUTE_TAG);
        String[] trimElementRight = trimElementLeft[1].split(END_ATTRIBUTE_TAG, 2);

        return collectedAttribute = trimElementRight[0];
    }

}
