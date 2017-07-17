package welenium.elements.library;

/**
 * Created by stevenstretton on 21/02/2017.
 */
public enum XpathLibrary {

    XPATH_CONTAINS_OPENING_TAG("//*["),
    XPATH_CONTAINS_QUERY("contains("),
    XPATH_CONTAINS_CLOSING_TAG("')]"),
    XPATH_AND_TAG("') AND ('"),

    XPATH_TYPE_TAG("@type,'"),
    XPATH_ID_TAG("@id,'"),
    XPATH_TEXT_TAG("text(),'"),
    XPATH_NAME_TAG("@name,'"),
    XPATH_PLACEHOLDER_TAG("@placeholder,'");

    private final String tagName;

    XpathLibrary(String htmlName) {
        tagName = htmlName;
    }

    public String getTagName() {
        return tagName;
    }


}
