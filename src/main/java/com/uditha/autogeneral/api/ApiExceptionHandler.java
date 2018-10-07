package com.uditha.autogeneral.api;

import java.lang.annotation.ElementType;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.uditha.autogeneral.model.ToDoItemNotFoundError;
import com.uditha.autogeneral.model.ToDoItemNotFoundErrorDetails;
import com.uditha.autogeneral.model.ToDoItemValidationError;
import com.uditha.autogeneral.model.ToDoItemValidationErrorDetails;

@ControllerAdvice
@RestController
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<ToDoItemValidationError> handleConstraintViolationException(
			ConstraintViolationException ex, WebRequest request) {

		ToDoItemValidationError error = new ToDoItemValidationError();
		error.setName("ValidationError");

		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			ToDoItemValidationErrorDetails errorDetail = new ToDoItemValidationErrorDetails();
			error.addDetailsItem(errorDetail);

			errorDetail.setLocation(ElementType.PARAMETER.name());
			errorDetail.setParam(violation.getPropertyPath().toString());
			errorDetail.setMsg(violation.getMessage());
			errorDetail.setValue(String.valueOf(violation.getInvalidValue()));
		}

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ToDoItemValidationError error = new ToDoItemValidationError();
		error.setName("ValidationError");

		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		for (FieldError fieldError : fieldErrors) {
			ToDoItemValidationErrorDetails errorDetail = new ToDoItemValidationErrorDetails();
			error.addDetailsItem(errorDetail);

			errorDetail.setLocation(ElementType.FIELD.name());
			errorDetail.setParam(fieldError.getField());
			errorDetail.setMsg(fieldError.getDefaultMessage());
			errorDetail.setValue(String.valueOf(fieldError.getRejectedValue()));
		}

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ToDoItemNotFoundError> handleNotFoundException(NotFoundException ex,
			WebRequest request) {

		ToDoItemNotFoundError error = new ToDoItemNotFoundError();
		error.setName("NotFoundError");

		ToDoItemNotFoundErrorDetails errorDetail = new ToDoItemNotFoundErrorDetails();
		errorDetail.setMessage(ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}