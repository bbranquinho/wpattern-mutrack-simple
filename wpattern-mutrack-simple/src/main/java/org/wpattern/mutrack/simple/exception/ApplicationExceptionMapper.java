package org.wpattern.mutrack.simple.exception;

import static org.wpattern.mutrack.simple.exception.ExceptionConstants.PARAMETER_VALUE_EXCEPTION;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Component
public class ApplicationExceptionMapper extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = Logger.getLogger(ApplicationExceptionMapper.class);

	@ResponseBody
	@ExceptionHandler(SecurityException.class)
	public ResponseEntity<ExceptionBean> handleControllerException(SecurityException exception) {
		LOGGER.error(exception.getMessage(), exception);

		return new ResponseEntity<ExceptionBean>(new ExceptionBean(exception), exception.getHttpStatus());
	}

	@SuppressWarnings("rawtypes")
	@ResponseBody
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionBean> handleControllerException(ConstraintViolationException exception) {
		String[] params = new String[exception.getConstraintViolations().size()];
		int index = 0;

		for (ConstraintViolation constraint : exception.getConstraintViolations()) {
			params[index++] = constraint.getPropertyPath().toString();
		}

		ExceptionBean exceptionBean = new ExceptionBean();

		exceptionBean.setParams(params);
		exceptionBean.setMessage(exception.getConstraintViolations().toString());
		exceptionBean.setServerCode(PARAMETER_VALUE_EXCEPTION.getServerCode());

		return new ResponseEntity<ExceptionBean>(exceptionBean, PARAMETER_VALUE_EXCEPTION.getHttpStatus());
	}

}