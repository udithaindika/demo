package com.uditha.autogeneral.model;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ToDoTestResult
 */

public class ToDoTestResult   {
  @JsonProperty("input")
  private String input = null;

  @JsonProperty("result")
  private ToDoItem result = null;

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ToDoTestResult toDoTestResult = (ToDoTestResult) o;
    return Objects.equals(this.input, toDoTestResult.input) &&
        Objects.equals(this.result, toDoTestResult.result);
  }

   /**
   * Get input
   * @return input
  **/
  @ApiModelProperty(value = "")
  public String getInput() {
    return input;
  }

  /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")
  @Valid
  public ToDoItem getResult() {
    return result;
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, result);
  }

   public ToDoTestResult input(String input) {
    this.input = input;
    return this;
  }

  public ToDoTestResult result(ToDoItem result) {
    this.result = result;
    return this;
  }


  public void setInput(String input) {
    this.input = input;
  }

  public void setResult(ToDoItem result) {
    this.result = result;
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
    sb.append("class ToDoTestResult {\n");
    
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}

