package welenium.elements;

import static welenium.elements.library.HtmlAttributeLibrary.*;

/**
 * Created by stevenstretton on 31/01/2017.
 */
public class HtmlExtractor {

    String getContentHtml(String htmlIsolatedElement) {
        return findHtmlContent(htmlIsolatedElement);
    }

    String getAttributesHtml(String htmlAttributes) {
        return findHtmlAttributes(htmlAttributes);
    }

    String getElementType(String htmlElementType) {
        return findHtmlElementByType(htmlElementType);
    }

    private String findHtmlContent(String htmlIsolatedElement) {
        String REMOVED_CHAR = "";

        String[] trimElementLeft = htmlIsolatedElement.split("(?=" + TAG.getHtmlAttributeName() + ")");
        String[] trimElementRight = trimElementLeft[1].split(" ", 2);

        return trimElementRight[0].replaceAll(String.valueOf(TAG.getHtmlAttributeName()), REMOVED_CHAR);
    }

    private String findHtmlElementByType(String htmlElementType) {
        HtmlAttributeFinder htmlAttributeFinder = new HtmlAttributeFinder();

        return htmlAttributeFinder.getAttributeFromElement(htmlElementType);
    }

    private String findHtmlAttributes(String htmlAttributes) {
        String foundHtmlAttribute = "";

        if (findHtmlAttributeById(htmlAttributes)) {
            foundHtmlAttribute = ID.getHtmlAttributeName();
        } else if (findHtmlAttributeByName(htmlAttributes)) {
            foundHtmlAttribute = NAME.getHtmlAttributeName();
        } else if (findHtmlAttributeByPlaceholder(htmlAttributes)) {
            foundHtmlAttribute = PLACEHOLDER.getHtmlAttributeName();
        }

        return foundHtmlAttribute;
    }

    private boolean findHtmlAttributeByName(String htmlAttributes) {
        return htmlAttributes.contains(NAME.getHtmlAttributeName());
    }

    private boolean findHtmlAttributeById(String htmlAttributes) {
        return htmlAttributes.contains(ID.getHtmlAttributeName());
    }

    private boolean findHtmlAttributeByPlaceholder(String htmlAttributes) {
        return htmlAttributes.contains(PLACEHOLDER.getHtmlAttributeName());
    }


}
