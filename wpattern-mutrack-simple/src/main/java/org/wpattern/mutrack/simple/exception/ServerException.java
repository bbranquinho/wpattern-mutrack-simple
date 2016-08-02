package org.wpattern.mutrack.simple.exception;

import static org.wpattern.mutrack.simple.exception.ExceptionConstants.SERVER_EXCEPTION;

public class ServerException extends GenericException {

	private static final long serialVersionUID = 201608020138L;

	public ServerException(String error) {
		super(SERVER_EXCEPTION);
		getExceptionBean().setMessage(String.format(SERVER_EXCEPTION.getMessage(), error));
	}

}
