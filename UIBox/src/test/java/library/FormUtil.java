package library;

/**
 * Created by stevenstretton on 23/03/2017.
 */
public enum FormUtil {

    NAME_STEVEN_STRETTON("Steven Stretton"),
    ADDRESS_SOMEWHERE_ST("123 Somewhere Street"),
    EMAIL_STEVEN("stevenstretton1@email.com"),
    PHONE_LOCAL("0114123456"),
    DATE_2017("01-01-2017"),
    MESSAGE("Hold on Tight!!!");

    private final String formData;

    FormUtil(String formInformation) {
        formData = formInformation;
    }

    public final String getFormData()
    {
        return formData;
    }
}
