package codingchallange.exception;

/**
 * Created by Igor on 09.10.2017.
 */
public class UsernameProcessingException extends Exception {
    public UsernameProcessingException() {
    }

    public UsernameProcessingException(String message) {
        super(message);
    }

    public UsernameProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameProcessingException(Throwable cause) {
        super(cause);
    }

    public UsernameProcessingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
