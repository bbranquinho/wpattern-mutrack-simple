package org.wpattern.mutrack.simple.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Component
public class ApplicationExceptionMapper extends ResponseEntityExceptionHandler {

	@ResponseBody
	@ExceptionHandler(SecurityException.class)
	public ResponseEntity<Object> handleControllerException(HttpServletRequest req, SecurityException ex) {
		//		ErrorResponse errorResponse = new ErrorResponse(ex);
		//
		//		if(ex instanceof ServiceException) {
		//			errorResponse.setDetails(((ServiceException)ex).getDetails());
		//		}
		//		if(ex instanceof ServiceHttpException) {
		//			return new ResponseEntity<Object>(errorResponse,((ServiceHttpException)ex).getStatus());
		//		} else {
		//			return new ResponseEntity<Object>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		//		}
		return null;
	}

}