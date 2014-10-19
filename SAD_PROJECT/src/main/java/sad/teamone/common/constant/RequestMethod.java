package sad.teamone.common.constant;

/**
 * Created by Tuyen on 10/16/2014.
 */
public enum RequestMethod {
    GET ("GET"),
    POST ("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    TRACE("TRACE"),
    OPTIONS("OPTIONS"),
    HEAD("HEAD");

    // Attribute
    private String value;

    // Constructor
    RequestMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
