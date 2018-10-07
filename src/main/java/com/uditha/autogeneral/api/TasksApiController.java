package com.uditha.autogeneral.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

import com.uditha.autogeneral.model.BalanceTestResult;
import com.uditha.autogeneral.service.TaskService;

import io.swagger.annotations.ApiParam;

@Controller
@Validated
public class TasksApiController implements TasksApi {

	@Autowired
	private TaskService taskService;

	@Override
	public ResponseEntity<BalanceTestResult> tasksValidateBracketsGet(
			@NotNull @Size(min = 1, max = 100) @ApiParam(value = "Input string (max length 100)", required = true) @RequestParam(value = "input", required = true) String input) {

		BalanceTestResult validateBrackets = taskService.validateBrackets(input);
		return new ResponseEntity<BalanceTestResult>(validateBrackets, HttpStatus.OK);
	}

}
