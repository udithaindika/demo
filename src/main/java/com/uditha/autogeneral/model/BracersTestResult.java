package com.uditha.autogeneral.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * BracersTestResult
 */

public class BracersTestResult   {
  @JsonProperty("expected")
  private Boolean expected = null;

  @JsonProperty("input")
  private String input = null;

  @JsonProperty("isCorrect")
  private Boolean isCorrect = null;

  @JsonProperty("result")
  private Boolean result = null;

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BracersTestResult bracersTestResult = (BracersTestResult) o;
    return Objects.equals(this.input, bracersTestResult.input) &&
        Objects.equals(this.result, bracersTestResult.result) &&
        Objects.equals(this.expected, bracersTestResult.expected) &&
        Objects.equals(this.isCorrect, bracersTestResult.isCorrect);
  }

   public BracersTestResult expected(Boolean expected) {
    this.expected = expected;
    return this;
  }

  /**
   * Get expected
   * @return expected
  **/
  @ApiModelProperty(value = "")
  public Boolean getExpected() {
    return expected;
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
   * Get isCorrect
   * @return isCorrect
  **/
  @ApiModelProperty(value = "")
  public Boolean getIsCorrect() {
    return isCorrect;
  }

  /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")
  public Boolean getResult() {
    return result;
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, result, expected, isCorrect);
  }

   public BracersTestResult input(String input) {
    this.input = input;
    return this;
  }

  public BracersTestResult isCorrect(Boolean isCorrect) {
    this.isCorrect = isCorrect;
    return this;
  }

  public BracersTestResult result(Boolean result) {
    this.result = result;
    return this;
  }

   public void setExpected(Boolean expected) {
    this.expected = expected;
  }

  public void setInput(String input) {
    this.input = input;
  }


  public void setIsCorrect(Boolean isCorrect) {
    this.isCorrect = isCorrect;
  }

  public void setResult(Boolean result) {
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
    sb.append("class BracersTestResult {\n");
    
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    expected: ").append(toIndentedString(expected)).append("\n");
    sb.append("    isCorrect: ").append(toIndentedString(isCorrect)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}

