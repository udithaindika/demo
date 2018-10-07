package com.uditha.autogeneral.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ToDoItemNotFoundErrorDetails
 */

public class ToDoItemNotFoundErrorDetails {
	@JsonProperty("message")
	private String message = null;

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ToDoItemNotFoundErrorDetails toDoItemNotFoundErrorDetails = (ToDoItemNotFoundErrorDetails) o;
		return Objects.equals(this.message, toDoItemNotFoundErrorDetails.message);
	}

	/**
	 * Get message
	 * 
	 * @return message
	 **/
	@ApiModelProperty(value = "")
	public String getMessage() {
		return message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message);
	}

	public ToDoItemNotFoundErrorDetails message(String message) {
		this.message = message;
		return this;
	}

	public void setMessage(String message) {
		this.message = message;
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
		sb.append("class ToDoItemNotFoundErrorDetails {\n");

		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
