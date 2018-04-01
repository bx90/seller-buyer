package sellerbuyer.util.exception;

/**
 * ServerException
 * <p>
 * Indicates an unexpected server-side error that is preventing the server from working correctly.
 * <p>
 * HTTP Status: 500
 *
 * @author Boxiong
 * @date 3/31/18
 *
 */
public class ServerException extends Exception {


    // reduce visibility so that caller must specify message
    protected ServerException() {

        super();
    }


    // reduce visibility so that caller must specify message
    protected ServerException(Throwable cause) {

        super(cause);
    }


    public ServerException(String message) {

        super(message);
    }


    public ServerException(String message, Throwable cause) {

        super(message, cause);
    }
}

