package org.wpattern.mutrack.simple.exception;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class GenericException extends RuntimeException {

	private static final long serialVersionUID = 201606062328L;

	private final String message;

	private final Integer serverCode;

	private final Integer httpCode;

	private final String[] params;

	public GenericException(ExceptionConstants exp, String... params) {
		this(exp.getMessage(), exp.getServerCode(), exp.getHttpCode(), params);
	}

	public GenericException(String message, Integer serverCode, Integer httpCode, String... params) {
		super();
		this.message = message;
		this.httpCode = httpCode;
		this.serverCode = serverCode;
		this.params = params;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public Integer getHttpCode() {
		return httpCode;
	}

	public Integer getServerCode() {
		return serverCode;
	}

	public String[] getParams() {
		return params;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
