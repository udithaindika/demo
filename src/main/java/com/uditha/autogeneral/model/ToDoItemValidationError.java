package com.uditha.autogeneral.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ToDoItemValidationError
 */

public class ToDoItemValidationError {
	@JsonProperty("details")
	private List<ToDoItemValidationErrorDetails> details = null;

	@JsonProperty("name")
	private String name = null;

	public ToDoItemValidationError addDetailsItem(ToDoItemValidationErrorDetails detailsItem) {
		if (this.details == null) {
			this.details = new ArrayList<ToDoItemValidationErrorDetails>();
		}
		this.details.add(detailsItem);
		return this;
	}

	public ToDoItemValidationError details(List<ToDoItemValidationErrorDetails> details) {
		this.details = details;
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ToDoItemValidationError toDoItemValidationError = (ToDoItemValidationError) o;
		return Objects.equals(this.details, toDoItemValidationError.details)
				&& Objects.equals(this.name, toDoItemValidationError.name);
	}

	/**
	 * Get details
	 * 
	 * @return details
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<ToDoItemValidationErrorDetails> getDetails() {
		return details;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(example = "ValidationError", value = "")
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(details, name);
	}

	public ToDoItemValidationError name(String name) {
		this.name = name;
		return this;
	}

	public void setDetails(List<ToDoItemValidationErrorDetails> details) {
		this.details = details;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ToDoItemValidationError {\n");

		sb.append("    details: ").append(toIndentedString(details)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
