package ar.com.wolox.api.exceptions;

public class MissingRequiredPropertiesException extends RuntimeException {

    public MissingRequiredPropertiesException() {
        super("There are required fields missing");
    }
}
