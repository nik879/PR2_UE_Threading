package Threading_FileIO;

public class GenericFileLoaderException extends Exception {
    public GenericFileLoaderException() {
    }

    public GenericFileLoaderException(String message) {
        super(message);
    }

    public GenericFileLoaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericFileLoaderException(Throwable cause) {
        super(cause);
    }

    public GenericFileLoaderException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
