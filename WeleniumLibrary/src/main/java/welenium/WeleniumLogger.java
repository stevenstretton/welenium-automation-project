package welenium;

/**
 * Created by stevenstretton on 24/02/2017.
 */
public class WeleniumLogger {

    private int pathLineCount = 0;

    public void init() {
        header();
    }

    public void outputInfo(String message) {
        System.out.println("[INFO] " + message);
    }

    public void outputError(String message) {
        System.out.println("[ERROR] " + message);
    }

    void getGeneratedPathOnSendKey(String path) {
        System.out.println("[" + pathLineCount + "] <OnSendKey> ===> " + path);
        pathLineCount++;
    }

    void getGeneratedPathOnClick(String path) {
        System.out.println("[" + pathLineCount + "] <OnClick> =====> " + path);
        pathLineCount++;
    }

    void getGeneratedPathOnTextSearch(String path) {
        System.out.println("[" + pathLineCount + "] <OnTextFind> ==> " + path);
        pathLineCount++;
    }

    public void getTestOutputOnSuccess(String functionName, String className) {
        System.out.println("[" + pathLineCount + "] Test Passed ==> "
                + functionName + " ON " + className);

        pathLineCount++;
    }

    public void getTestOutputOnFail(String functionName, String className, String expected, String actual) {
        System.out.println("[" + pathLineCount + "] Test Failed ==> "
                + functionName + " ON " + className);
        System.out.println(verticalSingleDivider());
        System.out.println("Expected ==> " + expected
                + " || But was ==> " + actual);
        System.out.println(verticalSingleDivider());

        pathLineCount++;
    }

    private void header() {
        System.out.println(verticalDoubleDivider());
        System.out.println(title());
        System.out.println(verticalSingleDivider());
        System.out.println(author());
        System.out.println(verticalDoubleDivider());
        System.getProperty("line.separator");
    }


    private String title() {
        return "__        __   _            _                 \n" + "\\ \\     " +
                " / /__| | ___ _ __ (_)_   _ _ __ ___  \n" +
                " \\ \\ /\\ / / _ \\ |/ _ \\ '_ \\| | | | | '_ ` _ \\ \n" +
                "  \\ V  V /  __/ |  __/ | | | | |_| | | | | | |\n" +
                "   \\_/\\_/ \\___|_|\\___|_| |_|_|\\__,_|_| |_| |_|";
    }

    private String author() {
        return "Developed by Steven Stretton";
    }

    private String verticalSingleDivider() {
        return "-----------------------------------------------------";
    }

    private String verticalDoubleDivider() {
        return "=====================================================";
    }

}
