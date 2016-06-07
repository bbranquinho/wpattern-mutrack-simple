package org.wpattern.mutrack.simple.exception;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class GenericException extends RuntimeException {

	private static final long serialVersionUID = 201606062328L;

	private String message;

	private Integer code;

	private String[] params;

	public GenericException() {
	}

	public GenericException(ExceptionConstants exp, String... params) {
		this(exp.getMessage(), exp.getCode(), params);
	}

	public GenericException(String message, Integer code, String... params) {
		super();
		this.message = message;
		this.code = code;
		this.params = params;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
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
