package com.uditha.autogeneral.model;

import java.util.Objects;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ToDoItemAddRequest
 */

public class ToDoItemAddRequest   {
  @JsonProperty("text")
  private String text = null;

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ToDoItemAddRequest toDoItemAddRequest = (ToDoItemAddRequest) o;
    return Objects.equals(this.text, toDoItemAddRequest.text);
  }

   /**
   * Get text
   * @return text
  **/
  @ApiModelProperty(example = "Uulwi ifis halahs gag erh'ongg w'ssh.", value = "")

 @Size(min=1,max=50)
  public String getText() {
    return text;
  }

  @Override
  public int hashCode() {
    return Objects.hash(text);
  }


  public void setText(String text) {
    this.text = text;
  }

  public ToDoItemAddRequest text(String text) {
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
    sb.append("class ToDoItemAddRequest {\n");
    
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}

