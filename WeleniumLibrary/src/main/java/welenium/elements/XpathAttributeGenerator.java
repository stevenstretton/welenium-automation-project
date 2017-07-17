package welenium.elements;

import welenium.elements.library.XpathLibrary;

import static welenium.elements.library.HtmlAttributeLibrary.*;


/**
 * Created by stevenstretton on 23/02/2017.
 */
public class XpathAttributeGenerator {

    private XpathAttributeTagFinder xpathAttributeTagFinder = new XpathAttributeTagFinder();
    private String setAttribute = "";

    public String getAttribute(String element, String keyword, String attribute) {
        typeAllocator(element, keyword, attribute);

        return setAttribute;
    }

    public String getAttributeForText(String text) {
        return setAttribute = getTextAttribute(text);
    }

    private void typeAllocator(String element, String keyword, String attribute) {
        if (element.equals(BUTTON.getHtmlAttributeName())) {
            setAttribute = getButtonAttribute(keyword);

        } else if (element.equals(INPUT.getHtmlAttributeName())) {
            setAttribute = getInputAttribute(keyword, attribute);

        } else if (element.equals(TEXTAREA.getHtmlAttributeName())) {
            setAttribute = getTextAreaAttribute(keyword, attribute);

        } else {
            System.out.println("Attribute not in catalog");
        }
    }

    private String getInputAttribute(String keyword, String attribute) {
        return XpathLibrary.XPATH_CONTAINS_QUERY.getTagName()
                + xpathAttributeTagFinder.getXpathAttributeTag(attribute)
                + keyword;
    }

    private String getTextAreaAttribute(String keyword, String attribute) {
        return XpathLibrary.XPATH_CONTAINS_QUERY.getTagName()
                + xpathAttributeTagFinder.getXpathAttributeTag(attribute)
                + keyword;
    }

    private String getButtonAttribute(String keyword) {
        return XpathLibrary.XPATH_CONTAINS_QUERY.getTagName()
                + XpathLibrary.XPATH_TYPE_TAG.getTagName()
                + keyword;
    }

    private String getTextAttribute(String keyword) {
        return XpathLibrary.XPATH_CONTAINS_QUERY.getTagName()
                + XpathLibrary.XPATH_TEXT_TAG.getTagName()
                + keyword;
    }
}
