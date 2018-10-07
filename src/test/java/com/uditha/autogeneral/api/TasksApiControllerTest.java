package com.uditha.autogeneral.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TasksApiControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testValidateBrackets() throws Exception {

		String input = "{[{{[Test Input]}}]}";

		this.mockMvc.perform(get("/tasks/validateBrackets").param("input", input)).andExpect(status().isOk())
				.andExpect(jsonPath("input").value(input))
				.andExpect(jsonPath("isBalanced").value(Boolean.TRUE.toString()));
	}
	
	@Test
	public void testValidateBracketsInvalid() throws Exception {

		String input = "Test][Input";

		this.mockMvc.perform(get("/tasks/validateBrackets").param("input", input)).andExpect(status().isOk())
				.andExpect(jsonPath("input").value(input))
				.andExpect(jsonPath("isBalanced").value(Boolean.FALSE.toString()));
	}

	@Test
	public void testValidateBracketslongInput() throws Exception {

		String input = "Test  Input Test Input Test Inp sdfsadf Test  Input Test Input Test Inp "
				+ "sdfsadfTest  Input Test Input Test Inp sdfsadfTest  Input Test Input Test Inp "
				+ "sdfsadfTest  Input Test Input Test Inp sdfsadfTest  Input Test Input Test Inp ";

		this.mockMvc.perform(get("/tasks/validateBrackets").param("input", input)).andExpect(status().isBadRequest())
				.andExpect(jsonPath("name").value("ValidationError"));
	}

}
