package org.wpattern.mutrack.simple.exception;

import java.util.HashMap;
import java.util.Map;

public enum ExceptionConstants {

	PARAMETER_VALUE_EXCEPTION(400, 4001, "Invalid parameter value [%s]."),

	SECURITY_EXCEPTION(500, 5000, "Error thrown by security issues, find an administrator.");

	private final Integer httpCode;

	private final Integer serverCode;

	private final String message;

	private static final Map<Integer, ExceptionConstants> internalCodeMap;

	static {
		internalCodeMap = new HashMap<Integer, ExceptionConstants>();

		for (ExceptionConstants value : values()) {
			internalCodeMap.put(value.serverCode, value);
		}
	}

	private ExceptionConstants(Integer httpCode, Integer serverCode, String message) {
		this.httpCode = serverCode;
		this.serverCode = serverCode;
		this.message = message;
	}

	public Integer getServerCode() {
		return serverCode;
	}

	public Integer getHttpCode() {
		return httpCode;
	}

	public String getMessage() {
		return message;
	}

	public ExceptionConstants parser(int code) {
		return internalCodeMap.get(code);
	}

}
