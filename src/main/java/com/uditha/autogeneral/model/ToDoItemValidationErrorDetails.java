package com.uditha.autogeneral.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ToDoItemValidationErrorDetails
 */

public class ToDoItemValidationErrorDetails   {
  @JsonProperty("location")
  private String location = null;

  @JsonProperty("msg")
  private String msg = null;

  @JsonProperty("param")
  private String param = null;

  @JsonProperty("value")
  private String value = null;

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ToDoItemValidationErrorDetails toDoItemValidationErrorDetails = (ToDoItemValidationErrorDetails) o;
    return Objects.equals(this.location, toDoItemValidationErrorDetails.location) &&
        Objects.equals(this.param, toDoItemValidationErrorDetails.param) &&
        Objects.equals(this.msg, toDoItemValidationErrorDetails.msg) &&
        Objects.equals(this.value, toDoItemValidationErrorDetails.value);
  }

   /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")
  public String getLocation() {
    return location;
  }

  /**
   * Get msg
   * @return msg
  **/
  @ApiModelProperty(value = "")


  public String getMsg() {
    return msg;
  }

  /**
   * Get param
   * @return param
  **/
  @ApiModelProperty(value = "")
  public String getParam() {
    return param;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")
  public String getValue() {
    return value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, param, msg, value);
  }

  public ToDoItemValidationErrorDetails location(String location) {
    this.location = location;
    return this;
  }

   public ToDoItemValidationErrorDetails msg(String msg) {
    this.msg = msg;
    return this;
  }

  public ToDoItemValidationErrorDetails param(String param) {
    this.param = param;
    return this;
  }

  public void setLocation(String location) {
    this.location = location;
  }

   public void setMsg(String msg) {
    this.msg = msg;
  }

  public void setParam(String param) {
    this.param = param;
  }


  public void setValue(String value) {
    this.value = value;
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
    sb.append("class ToDoItemValidationErrorDetails {\n");
    
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    param: ").append(toIndentedString(param)).append("\n");
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  public ToDoItemValidationErrorDetails value(String value) {
    this.value = value;
    return this;
  }
}

