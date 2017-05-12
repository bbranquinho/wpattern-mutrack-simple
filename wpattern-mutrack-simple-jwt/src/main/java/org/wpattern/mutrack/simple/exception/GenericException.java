package org.wpattern.mutrack.simple.exception;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

public abstract class GenericException extends RuntimeException {

	private static final long serialVersionUID = 201606062328L;

	private final ExceptionBean exceptionBean;

	private final HttpStatus httpStatus;

	public GenericException(ExceptionConstants exp, String... params) {
		this(exp.getMessage(), exp.getServerCode(), exp.getHttpStatus(), params);
	}

	public GenericException(String message, Integer serverCode, HttpStatus httpStatus, String... params) {
		super();
		this.httpStatus = httpStatus;
		this.exceptionBean = new ExceptionBean(message, serverCode, params);
	}

	public ExceptionBean getExceptionBean() {
		return exceptionBean;
	}

	@Override
	public String getMessage() {
		return this.exceptionBean.getMessage();
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public Integer getServerCode() {
		return this.exceptionBean.getServerCode();
	}

	public String[] getParams() {
		return this.exceptionBean.getParams();
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
