package welenium;

import welenium.exceptions.ElementMissingFromPathException;
import welenium.exceptions.NoElementFoundException;

/**
 * Created by stevenstretton on 25/10/2016.
 */
public class WebElement {
    private static WebStructure structure = new WebStructure();
    private static VerifyElementFound verify = new VerifyElementFound();

    public void collectElement() {
        structure.getHtmlStructure();
    }

    void findStructureByElementForSendKey(String value, String elementName)
            throws NoElementFoundException, ElementMissingFromPathException {
        structure.scanStructure(elementName, true);
        verify.processElementVerificationOnSendKey(value, structure.getExtractedPath());
    }

    void findStructureByElementForOnClick(String elementName)
            throws NoElementFoundException, ElementMissingFromPathException {
        structure.scanStructure(elementName, true);
        verify.processElementVerificationOnClick(structure.getExtractedPath());
    }

    void findStructureByElementForRead(String value) throws ElementMissingFromPathException {
        structure.scanStructureForText(value);
        verify.processElementVerificationOnRead(structure.getExtractedPath());
    }

}
