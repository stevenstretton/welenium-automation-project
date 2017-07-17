package library;

/**
 * Created by stevenstretton on 23/03/2017.
 */
public enum NavigationUtil {

    NAVIGATE_TO_TEST_A("A"),
    NAVIGATE_TO_TEST_B("B"),
    NAVIGATE_TO_TEST_C("C");

    private final String testPage;

    NavigationUtil(String testString) {
        testPage = testString;
    }

    public final String getTestPage()
    {
        return testPage;
    }

}
