package welenium.elements.library;

/**
 * Created by stevenstretton on 17/01/2017.
 */
public enum HtmlAttributeLibrary {
    //html area
    HTML("html"),
    BODY("body"),

    //table
    TABLE("table"),
    TR("tr"),
    TD("td"),

    //form
    FORM("form"),
    FIELDSET("fieldset"),
    INPUT("input"),
    LABEL("label"),
    BUTTON("button"),
    TEXTAREA("textarea"),

    //attribute elements
    TAG("<"),
    ID("id"),
    CLASS("class"),
    NAME("name"),
    TYPE("type"),
    PLACEHOLDER("placeholder"),
    H_ONE("h1"),
    FOR("for"),

    ATTRIBUTE_EQUAL("=\"");

    private final String elementName;

    HtmlAttributeLibrary(String htmlName) {
        elementName = htmlName;
    }

    public final String getHtmlAttributeName() {
        return elementName;
    }


}
