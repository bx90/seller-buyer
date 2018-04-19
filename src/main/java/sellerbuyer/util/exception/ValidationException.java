package sellerbuyer.util.exception;

/**
 * ValidationException.java
 * <p>
 * Indicates that expected input value was missing or did not conform to accepted form.
 * <p>
 * HTTP Status: 400
 *
 * @author Boxiong
 * @date 3/31/18
 */
public class ValidationException extends Exception {
    private String errorCode;
    // reduce visibility so that caller must specify message
    protected ValidationException() {

        super();
    }
    // reduce visibility so that caller must specify message
    protected ValidationException(Throwable cause) {

        super(cause);
    }


    public ValidationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ValidationException(String message) {

        super(message);
    }



    public ValidationException(String message, Throwable cause) {

        super(message, cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
