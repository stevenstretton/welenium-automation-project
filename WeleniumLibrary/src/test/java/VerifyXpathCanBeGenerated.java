import org.junit.Test;
import welenium.WeleniumLogger;
import welenium.elements.library.XpathLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stevenstretton on 21/03/2017.
 */
public class VerifyXpathCanBeGenerated {

    private List<String> elements = new ArrayList<>();
    private WeleniumLogger weleniumLogger = new WeleniumLogger();
    private String testClass = this.getClass().getName();

    @Test
    public void verifyXpathCanBeGenerated() {
        weleniumLogger.outputInfo("Welenium Library Test " + testClass);

        this.getHtmlLibraryContent();

        this.validateElements("@type,'");
        this.validateElementSize(9);

    }

    private List<String> getHtmlLibraryContent() {
        for (XpathLibrary xpathLibrary : XpathLibrary.values()) {
            elements.add(xpathLibrary.getTagName());
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
