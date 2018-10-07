package com.uditha.autogeneral.api;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.uditha.autogeneral.model.ToDoItem;
import com.uditha.autogeneral.model.ToDoItemAddRequest;
import com.uditha.autogeneral.model.ToDoItemUpdateRequest;

import io.swagger.annotations.ApiParam;

@Controller
public class TodoApiController implements TodoApi {

    @Override
	public ResponseEntity<ToDoItem> todoIdGet(@ApiParam(value = "id",required=true ) @PathVariable("id") BigDecimal id) {
        // do some magic!
        return new ResponseEntity<ToDoItem>(HttpStatus.OK);
    }

    @Override
	public ResponseEntity<ToDoItem> todoIdPatch(@ApiParam(value = "id",required=true ) @PathVariable("id") BigDecimal id,
        @ApiParam(value = "" ,required=true )  @Valid @RequestBody ToDoItemUpdateRequest body) {
        // do some magic!
        return new ResponseEntity<ToDoItem>(HttpStatus.OK);
    }

    @Override
	public ResponseEntity<ToDoItem> todoPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ToDoItemAddRequest body) {
        // do some magic!
        return new ResponseEntity<ToDoItem>(HttpStatus.OK);
    }

}
