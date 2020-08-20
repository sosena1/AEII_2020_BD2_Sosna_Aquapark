package pl.bd.aquapark.exception;

public class SneakyException extends RuntimeException {
    public SneakyException() {
        super();
    }

    public SneakyException(String message) {
        super(message);
    }

    public SneakyException(String message, Throwable cause) {
        super(message, cause);
    }

    public SneakyException(Throwable cause) {
        super(cause);
    }
}
