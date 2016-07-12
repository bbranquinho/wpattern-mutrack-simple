package org.wpattern.mutrack.simple.exception;

public class ArgumentException extends GenericException {

    private static final long serialVersionUID = 201612070201L;

    public ArgumentException(String message, String... params) {
        super(message, ExceptionConstants.PARAMETER_VALUE_EXCEPTION.getServerCode(),
                ExceptionConstants.PARAMETER_VALUE_EXCEPTION.getHttpCode(), params);
    }
}
