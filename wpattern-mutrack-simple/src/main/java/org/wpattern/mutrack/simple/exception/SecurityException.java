package org.wpattern.mutrack.simple.exception;

public class SecurityException extends GenericException {

	private static final long serialVersionUID = 201606062325L;

	public SecurityException() {
		super(ExceptionConstants.SECURITY_EXCEPTION);
	}

	public SecurityException(ExceptionConstants exp, String... params) {
		super(exp, params);
	}

	public SecurityException(String message, Integer code, String... params) {
		super(message, code, params);
	}

}
