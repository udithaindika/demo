package com.uditha.autogeneral.api;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uditha.autogeneral.model.ToDoItem;
import com.uditha.autogeneral.model.ToDoItemAddRequest;
import com.uditha.autogeneral.model.ToDoItemUpdateRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TodoApiControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testGetTodo() throws Exception {

		ToDoItemAddRequest request = new ToDoItemAddRequest();
		request.setText("Complete this test");

		MvcResult result = this.mockMvc.perform(
				post("/todo").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
				.andReturn();
		ToDoItem todoItem = objectMapper.readValue(result.getResponse().getContentAsString(), ToDoItem.class);

		this.mockMvc.perform(get("/todo/{id}", todoItem.getId())) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("$.id").isNumber()) //
				.andExpect(jsonPath("$.createdAt").isString()) //
				.andExpect(jsonPath("$.text").value(request.getText()))//
				.andExpect(jsonPath("$.isCompleted").value(Boolean.FALSE));

	}

	@Test
	public void testGetTodoInvalidId() throws Exception {

		ToDoItemAddRequest request = new ToDoItemAddRequest();
		request.setText("Complete this test");

		this.mockMvc.perform(
				post("/todo").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk());

		this.mockMvc.perform(get("/todo/{id}", -1)) //
				.andExpect(status().isNotFound()) //
				.andExpect(jsonPath("$.name").value("NotFoundError")); //

	}

	@Test
	public void testPostTodo() throws Exception {

		ToDoItemAddRequest request = new ToDoItemAddRequest();
		request.setText("Complete this test");

		this.mockMvc
				.perform(post("/todo").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("$.id").isNumber()) //
				.andExpect(jsonPath("$.createdAt").isString()) //
				.andExpect(jsonPath("$.text").value(request.getText()))//
				.andExpect(jsonPath("$.isCompleted").value(Boolean.FALSE));
	}

	@Test
	public void testPostTodoLongText() throws Exception {

		ToDoItemAddRequest request = new ToDoItemAddRequest();
		request.setText("Complete this test!Complete this test!" + "Complete this test!Complete this test!"
				+ "Complete this test!Complete this test!");

		this.mockMvc
				.perform(post("/todo").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest()) //
				.andExpect(jsonPath("$.name").value("ValidationError"));
	}

	@Test
	public void updateToDoItem() throws Exception {

		ToDoItemAddRequest addRequest = new ToDoItemAddRequest();
		addRequest.setText("Complete this test!");

		MvcResult result = this.mockMvc.perform(post("/todo").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(addRequest))).andReturn();

		ToDoItem todoItem = objectMapper.readValue(result.getResponse().getContentAsString(), ToDoItem.class);

		assertEquals(addRequest.getText(), todoItem.getText());
		assertEquals(Boolean.FALSE, todoItem.getIsCompleted());

		ToDoItemUpdateRequest updateRequest = new ToDoItemUpdateRequest();
		updateRequest.setText("Complete this test! Updated");
		updateRequest.setIsCompleted(Boolean.TRUE);

		this.mockMvc
				.perform(patch("/todo/{id}", todoItem.getId()).contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(updateRequest)))
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("$.id").isNumber()) //
				.andExpect(jsonPath("$.createdAt").isString()) //
				.andExpect(jsonPath("$.text").value(updateRequest.getText()))//
				.andExpect(jsonPath("$.isCompleted").value(Boolean.TRUE));

	}

	@Test
	public void updateInvalidToDoItem() throws Exception {

		ToDoItemUpdateRequest updateRequest = new ToDoItemUpdateRequest();
		updateRequest.setText("Complete this test! Updated");
		updateRequest.setIsCompleted(Boolean.TRUE);

		this.mockMvc
				.perform(patch("/todo/{id}", -1).contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(updateRequest)))
				.andExpect(status().isNotFound()) //
				.andExpect(jsonPath("$.name").value("NotFoundError"));
	}

}
