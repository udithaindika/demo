package com.uditha.autogeneral.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uditha.autogeneral.model.BalanceTestResult;
import com.uditha.autogeneral.model.ToDoItemValidationError;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "tasks", description = "the tasks API")
public interface TasksApi {

	@ApiOperation(value = "Checks if brackets in a string are balanced", notes = "Brackets in a string are considered to be balanced if the following criteria are met: - For every opening bracket (i.e., **`(`**, **`{`**, or **`[`**), there is a matching closing bracket (i.e., **`)`**, **`}`**, or **`]`**) of the same type (i.e., **`(`** matches **`)`**, **`{`** matches **`}`**, and **`[`** matches **`]`**). An opening bracket must appear before (to the left of) its matching closing bracket. For example, **`]{}[`** is not balanced. - No unmatched braces lie between some pair of matched bracket. For example, **`({[]})`** is balanced, but **`{[}]`** and **`[{)]`** are not balanced.", response = BalanceTestResult.class, tags = {
			"tasks", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = BalanceTestResult.class),
			@ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class) })

	@RequestMapping(value = "/tasks/validateBrackets", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<BalanceTestResult> tasksValidateBracketsGet(
			@NotNull @Size(min = 1, max = 100) @ApiParam(value = "Input string (max length 100)", required = true) @RequestParam(value = "input", required = true) String input);

}
