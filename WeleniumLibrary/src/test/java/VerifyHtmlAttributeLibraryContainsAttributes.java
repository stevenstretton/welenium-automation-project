import org.junit.Test;
import welenium.WeleniumLogger;
import welenium.elements.library.HtmlAttributeLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stevenstretton on 21/03/2017.
 */
public class VerifyHtmlAttributeLibraryContainsAttributes {

    private List<String> elements = new ArrayList<String>();
    private WeleniumLogger weleniumLogger = new WeleniumLogger();
    private String testClass = this.getClass().getName();

    @Test
    public void verifyHtmlAttributeLibraryContainsAttributes() {
        weleniumLogger.outputInfo("Welenium Library Test " + testClass);

        this.getHtmlLibraryContent();

        this.validateElements("id");
        this.validateElementSize(20);

    }

    private List<String> getHtmlLibraryContent() {
        for (HtmlAttributeLibrary htmlTagLibrary : HtmlAttributeLibrary.values()) {
            elements.add(htmlTagLibrary.getHtmlAttributeName());
        }

        return elements;
    }

    private void validateElements(String element) {
        String currentMethod = "validateElements";

        if (elements.contains(element)) {
            weleniumLogger.getTestOutputOnSuccess(currentMethod, testClass);
        } else {
            weleniumLogger.getTestOutputOnFail(currentMethod, testClass,
                    element, Arrays.toString(elements.toArray()));
        }
    }

    private void validateElementSize(int size) {
        String currentMethod = "validateElementSize";

        if (elements.size() == size) {
            weleniumLogger.getTestOutputOnSuccess(currentMethod, testClass);
        } else {
            weleniumLogger.getTestOutputOnFail(currentMethod, testClass,
                    String.valueOf(size), String.valueOf(elements.size()));
        }
    }

}
