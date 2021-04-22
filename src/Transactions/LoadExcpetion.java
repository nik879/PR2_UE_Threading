package Transactions;

public class LoadExcpetion extends Exception {
    public LoadExcpetion() {
    }

    public LoadExcpetion(String message) {
        super(message);
    }

    public LoadExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public LoadExcpetion(Throwable cause) {
        super(cause);
    }

    public LoadExcpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
