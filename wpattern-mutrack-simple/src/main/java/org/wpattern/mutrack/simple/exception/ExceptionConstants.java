package org.wpattern.mutrack.simple.exception;

import java.util.HashMap;
import java.util.Map;

public enum ExceptionConstants {

	SECURITY_EXCEPTION(5000, "Error thrown by security issues, find an administrator.");

	private final Integer code;

	private final String message;

	private static final Map<Integer, ExceptionConstants> map;

	static {
		map = new HashMap<Integer, ExceptionConstants>();

		for (ExceptionConstants value : values()) {
			map.put(value.code, value);
		}
	}

	private ExceptionConstants(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public ExceptionConstants parser(int code) {
		return map.get(code);
	}

}
