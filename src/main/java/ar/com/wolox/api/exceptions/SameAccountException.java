package ar.com.wolox.api.exceptions;

public class SameAccountException extends RuntimeException {

    public SameAccountException(String message) {
        super(message);
    }
}
