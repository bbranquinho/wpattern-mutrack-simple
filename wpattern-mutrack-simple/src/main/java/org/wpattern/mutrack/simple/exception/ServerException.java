package org.wpattern.mutrack.simple.exception;

import org.springframework.http.HttpStatus;

import static org.wpattern.mutrack.simple.exception.ExceptionConstants.SERVER_EXCEPTION;

public class ServerException extends GenericException {

    public ServerException(String error) {
        super(SERVER_EXCEPTION);
        getExceptionBean().setMessage(String.format(SERVER_EXCEPTION.getMessage(), error));
    }

}
