package com.uditha.autogeneral.api;

import java.lang.annotation.ElementType;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.uditha.autogeneral.model.ToDoItemValidationError;
import com.uditha.autogeneral.model.ToDoItemValidationErrorDetails;

@ControllerAdvice
@RestController
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<ToDoItemValidationError> handleConst(ConstraintViolationException ex,
			WebRequest request) {

		ToDoItemValidationError error = new ToDoItemValidationError();
		error.setName("ValidationError");

		for(ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			ToDoItemValidationErrorDetails errorDetail = new ToDoItemValidationErrorDetails();
			error.addDetailsItem(errorDetail);
			
			errorDetail.setLocation(ElementType.PARAMETER.name());
			errorDetail.setParam(violation.getPropertyPath().toString());
			errorDetail.setMsg(violation.getMessage());
			errorDetail.setValue(String.valueOf(violation.getInvalidValue()));
		}

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}