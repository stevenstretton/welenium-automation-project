package welenium.elements;

import welenium.WeleniumLogger;
import welenium.elements.library.XpathLibrary;

/**
 * Created by stevenstretton on 03/03/2017.
 */
public class XpathAttributeTagFinder {

    private WeleniumLogger weleniumLogger = new WeleniumLogger();
    private String attribute;
    private String collectedAttributeTag;

    public String getXpathAttributeTag(String attribute) {
        this.attribute = attribute;
        findTagAssociateToKeyword();

        return this.collectedAttributeTag;
    }

    private void findTagAssociateToKeyword() {
        switch (attribute) {
            case "id":
                getIdTag();
                break;
            case "name":
                getNameTag();
                break;
            case "placeholder":
                getPlaceholderTag();
                break;
            case "type":
                getTypeTag();
                break;
            default:
                weleniumLogger.outputError("invalid attribute");
                break;
        }
    }

    private void getIdTag() {
        this.collectedAttributeTag = XpathLibrary.XPATH_ID_TAG.getTagName();
    }

    private void getNameTag() {
        this.collectedAttributeTag = XpathLibrary.XPATH_NAME_TAG.getTagName();
    }

    private void getPlaceholderTag() {
        this.collectedAttributeTag = XpathLibrary.XPATH_PLACEHOLDER_TAG.getTagName();
    }

    private void getTypeTag() {
        this.collectedAttributeTag = XpathLibrary.XPATH_TYPE_TAG.getTagName();
    }
}
