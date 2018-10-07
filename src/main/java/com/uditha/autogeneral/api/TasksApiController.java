package com.uditha.autogeneral.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.uditha.autogeneral.model.BalanceTestResult;

import io.swagger.annotations.ApiParam;

@Controller
public class TasksApiController implements TasksApi {

    @Override
	public ResponseEntity<BalanceTestResult> tasksValidateBracketsGet( @NotNull @Size(min=1,max=100)@ApiParam(value = "Input string (max length 100)", required = true) @RequestParam(value = "input", required = true) String input) {
        // do some magic!
        return new ResponseEntity<BalanceTestResult>(HttpStatus.OK);
    }

}
