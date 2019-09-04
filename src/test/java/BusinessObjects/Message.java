package BusinessObjects;

/**
 * created by Andrei_Korotkov 9/3/2019
 */
public class Message {

    public static final String ADRESSEE = "ankorotkov66@gmail.com";
    public static final String SUBJECT = "autoTest";
    public static final String BODY = "This is autotest letter";

    public static String getAddressee() {
        return ADRESSEE;
    }

    public static String getSubject() {
        return SUBJECT;
    }

    public static String getBody() {
        return BODY;
    }
}
