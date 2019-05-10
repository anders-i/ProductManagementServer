/*
 * Product Management
 * Handles products, location and barcodes
 *
 * OpenAPI spec version: 0.3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Token;
import javax.validation.constraints.*;

/**
 * CategoryRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-10T09:44:43.395Z")
public class CategoryRequest   {
  @JsonProperty("category")
  private String category = null;

  @JsonProperty("token")
  private Token token = null;

  public CategoryRequest category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  @JsonProperty("category")
  @ApiModelProperty(value = "")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public CategoryRequest token(Token token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   **/
  @JsonProperty("token")
  @ApiModelProperty(value = "")
  public Token getToken() {
    return token;
  }

  public void setToken(Token token) {
    this.token = token;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryRequest categoryRequest = (CategoryRequest) o;
    return Objects.equals(this.category, categoryRequest.category) &&
        Objects.equals(this.token, categoryRequest.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, token);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryRequest {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("}");
    return sb.toString();
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
}

