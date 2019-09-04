package BusinessObjects;

/**
 * created by Andrei_Korotkov 9/4/2019
 */
public abstract class User {
    public String LOGIN;
    public String PASSWORD;
    public String DOMAIN;

    public String getLOGIN() {
        return LOGIN;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getDOMAIN() {
        return DOMAIN;
    }
}
