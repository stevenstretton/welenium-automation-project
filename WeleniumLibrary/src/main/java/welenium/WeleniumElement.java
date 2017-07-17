package welenium;

import welenium.exceptions.ElementMissingFromPathException;
import welenium.exceptions.NoElementFoundException;

/**
 * Created by stevenstretton on 14/12/2016.
 */
public class WeleniumElement extends WebElement
{
    public void writeToPage(String value, String keyword) {
        try {
            findStructureByElementForSendKey(value, keyword);
        } catch (NoElementFoundException | ElementMissingFromPathException e) {
            e.printStackTrace();
        }
    }

    public void readFromPage(String readElement)  {
        try {
            findStructureByElementForRead(readElement);
        } catch (ElementMissingFromPathException e) {
            e.printStackTrace();
        }
    }

    public void selectOnPage(String item)  {
        try {
            findStructureByElementForOnClick(item);
        } catch (NoElementFoundException | ElementMissingFromPathException e) {
            e.printStackTrace();
        }
    }

}
