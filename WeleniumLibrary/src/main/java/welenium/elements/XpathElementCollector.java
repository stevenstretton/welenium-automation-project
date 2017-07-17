package welenium.elements;

import org.springframework.util.StringUtils;
import welenium.elements.library.HtmlAttributeLibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stevenstretton on 17/01/2017.
 */
public class XpathElementCollector {

    private String element;
    private String generatedXpath = "";
    private List<String> elements = new ArrayList<>();

    public void getHtmlElements(String htmlSource, String keyword, Boolean isSendKeyAndClick) {
        this.element = keyword;
        collectAttributes();
        generateXpathElement(htmlSource, isSendKeyAndClick);
    }

    public List<String> getCollectedAttributes() {
        return this.collectAttributes();
    }

    public String getGeneratedXpath() {
        return generatedXpath;
    }

    private List<String> collectAttributes() {
        for (HtmlAttributeLibrary htmlTagLibrary : HtmlAttributeLibrary.values()) {
            elements.add(htmlTagLibrary.getHtmlAttributeName());
        }

        return elements;
    }

    private String[] breakDownStructure(String htmlSource) {
        final String NEW_LINE = "\n";

        int ONE = 1;
        int newLineCount = StringUtils.countOccurrencesOf(htmlSource, NEW_LINE) + ONE;
        int newLine = 0;
        String[] elementPerLine = new String[newLineCount];

        for (String temporaryElement : htmlSource.split(NEW_LINE)) {
            getElementPerLine(elementPerLine, temporaryElement, newLine);
            newLine++;
        }

        return elementPerLine;
    }

    private String getElementPerLine(String[] elementPerLine, String temporaryElement, int newLine) {
        return elementPerLine[newLine] = temporaryElement;
    }

    private void generateXpathElement(String htmlSource, Boolean isSendKeyAndClick) {
        HtmlExtractor htmlExtractor = new HtmlExtractor();

        for (String foundElementInStructure : breakDownStructure(htmlSource)) {

            if (foundElementInStructure.contains(element)) {

                if (isSendKeyAndClick) {

                    if (foundElementInStructure.contains(element) &&
                            !foundElementInStructure.contains(HtmlAttributeLibrary.FOR.getHtmlAttributeName()
                                    + HtmlAttributeLibrary.ATTRIBUTE_EQUAL.getHtmlAttributeName()
                                    + element)
                            ) {

                        if (!foundElementInStructure.contains(HtmlAttributeLibrary.CLASS.getHtmlAttributeName()
                                + HtmlAttributeLibrary.ATTRIBUTE_EQUAL.getHtmlAttributeName()
                                + element)) {
                            processElementToPath(htmlExtractor, foundElementInStructure);
                            break;
                        }
                    }

                } else {
                    processElementToPath(htmlExtractor, foundElementInStructure);
                    break;
                }

            }

        }
    }

    private void processElementToPath(HtmlExtractor htmlExtractor, String foundElementInStructure) {
        String getContentElement = htmlExtractor.getContentHtml(foundElementInStructure);
        String getContentAttribute = htmlExtractor.getAttributesHtml(foundElementInStructure);
        String getContentType = htmlExtractor.getElementType(foundElementInStructure);

        validateXPathElement(getContentElement);
        validateXPathElement(getContentAttribute);

        generateXpathStructure(getContentElement, getContentType, getContentAttribute);
    }


    private boolean validateXPathElement(String collectedElement) {
        boolean doesMatch = false;

        for (String foundElement : elements) {
            if (collectedElement.equals(foundElement)) {
                doesMatch = true;
                break;
            }
        }

        return doesMatch;
    }

    private void generateXpathStructure(String element, String type, String attribute) {
        XpathExpressionBuilder xpathExpressionBuilder = new XpathExpressionBuilder();
        xpathExpressionBuilder.createExpression(element, type, attribute);
        generatedXpath = xpathExpressionBuilder.getGeneratedXpath();
    }


}
