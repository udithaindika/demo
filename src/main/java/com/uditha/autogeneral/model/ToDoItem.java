package com.uditha.autogeneral.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ToDoItem
 */

public class ToDoItem   {
  @JsonProperty("createdAt")
  private String createdAt = null;

  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("isCompleted")
  private Boolean isCompleted = null;

  @JsonProperty("text")
  private String text = null;

  public ToDoItem createdAt(String createdAt) {
    this.createdAt = createdAt;
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
    ToDoItem toDoItem = (ToDoItem) o;
    return Objects.equals(this.id, toDoItem.id) &&
        Objects.equals(this.text, toDoItem.text) &&
        Objects.equals(this.isCompleted, toDoItem.isCompleted) &&
        Objects.equals(this.createdAt, toDoItem.createdAt);
  }

  /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(example = "2017-10-13T01:50:58.735Z", value = "")
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "42.0", value = "")
  @Valid
  public BigDecimal getId() {
    return id;
  }

   /**
   * Get isCompleted
   * @return isCompleted
  **/
  @ApiModelProperty(example = "false", value = "")
  public Boolean getIsCompleted() {
    return isCompleted;
  }

  /**
   * Get text
   * @return text
  **/
  @ApiModelProperty(example = "Uulwi ifis halahs gag erh'ongg w'ssh.", value = "")
  public String getText() {
    return text;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text, isCompleted, createdAt);
  }

   public ToDoItem id(BigDecimal id) {
    this.id = id;
    return this;
  }

  public ToDoItem isCompleted(Boolean isCompleted) {
    this.isCompleted = isCompleted;
    return this;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

   public void setId(BigDecimal id) {
    this.id = id;
  }

  public void setIsCompleted(Boolean isCompleted) {
    this.isCompleted = isCompleted;
  }


  public void setText(String text) {
    this.text = text;
  }

  public ToDoItem text(String text) {
    this.text = text;
    return this;
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
    sb.append("class ToDoItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    isCompleted: ").append(toIndentedString(isCompleted)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}

