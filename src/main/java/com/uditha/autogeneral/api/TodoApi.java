package com.uditha.autogeneral.api;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uditha.autogeneral.model.ToDoItem;
import com.uditha.autogeneral.model.ToDoItemAddRequest;
import com.uditha.autogeneral.model.ToDoItemNotFoundError;
import com.uditha.autogeneral.model.ToDoItemUpdateRequest;
import com.uditha.autogeneral.model.ToDoItemValidationError;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "todo", description = "the todo API")
public interface TodoApi {

    @ApiOperation(value = "Retrieve a specific item by id", notes = "", response = ToDoItem.class, tags={ "todo", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ToDoItem.class),
        @ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class),
        @ApiResponse(code = 404, message = "Not Found Error", response = ToDoItemNotFoundError.class) })
    
    @RequestMapping(value = "/todo/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ToDoItem> todoIdGet(@ApiParam(value = "id",required=true ) @PathVariable("id") BigDecimal id);


    @ApiOperation(value = "Modify an item", notes = "", response = ToDoItem.class, tags={ "todo", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ToDoItem.class),
        @ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class),
        @ApiResponse(code = 404, message = "Not Found Error", response = ToDoItemNotFoundError.class) })
    
    @RequestMapping(value = "/todo/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    ResponseEntity<ToDoItem> todoIdPatch(@ApiParam(value = "id",required=true ) @PathVariable("id") BigDecimal id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody ToDoItemUpdateRequest body);


    @ApiOperation(value = "Create a to do item", notes = "", response = ToDoItem.class, tags={ "todo", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ToDoItem.class),
        @ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class) })
    
    @RequestMapping(value = "/todo",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ToDoItem> todoPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ToDoItemAddRequest body);

}
