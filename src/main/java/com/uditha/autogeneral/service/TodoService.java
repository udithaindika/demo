package com.uditha.autogeneral.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.uditha.autogeneral.api.NotFoundException;
import com.uditha.autogeneral.model.ToDoItem;
import com.uditha.autogeneral.model.ToDoItemAddRequest;
import com.uditha.autogeneral.model.ToDoItemUpdateRequest;

@Service
public class TodoService {

	Map<BigDecimal, ToDoItem> todoRepository = new HashMap<>();

	public ToDoItem getTodoItem(BigDecimal id) {
		ToDoItem toDoItem = todoRepository.get(id);
		if (toDoItem == null) {
			throw new NotFoundException(String.format("Item with %n not found", id.intValue()));
		}
		return toDoItem;
	}

	public ToDoItem createTodoItem(ToDoItemAddRequest body) {
		int nextID = todoRepository.size() + 1;

		ToDoItem item = new ToDoItem();
		item.setText(body.getText());
		item.setId(BigDecimal.valueOf(nextID));
		item.setCreatedAt(LocalDateTime.now().toString());
		item.setIsCompleted(Boolean.FALSE);

		todoRepository.put(item.getId(), item);

		return item;
	}
	
	public ToDoItem updateTodoItem(BigDecimal id, ToDoItemUpdateRequest body) {

		ToDoItem toDoItem = getTodoItem(id);
		
		toDoItem.setText(body.getText());
		toDoItem.setIsCompleted(body.getIsCompleted());

		return toDoItem;
	}
}
