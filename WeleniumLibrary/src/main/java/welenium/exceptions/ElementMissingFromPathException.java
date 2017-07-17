package welenium.exceptions;

/**
 * Created by stevenstretton on 25/10/2016.
 */
public class ElementMissingFromPathException extends Exception {
    public ElementMissingFromPathException(String message) {
        super("Element is missing from generated Xpath. Produced path: " + message);
    }
}
