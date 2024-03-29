/*
 * Product Management
 * Handles products, location and barcodes
 *
 * OpenAPI spec version: 0.4
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
import io.swagger.model.Barcode;
import io.swagger.model.Token;
import javax.validation.constraints.*;

/**
 * GetProductRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-26T10:45:56.712Z")
public class GetProductRequest   {
  @JsonProperty("product")
  private Barcode product = null;

  @JsonProperty("token")
  private Token token = null;

  public GetProductRequest product(Barcode product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   * @return product
   **/
  @JsonProperty("product")
  @ApiModelProperty(value = "")
  public Barcode getProduct() {
    return product;
  }

  public void setProduct(Barcode product) {
    this.product = product;
  }

  public GetProductRequest token(Token token) {
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
    GetProductRequest getProductRequest = (GetProductRequest) o;
    return Objects.equals(this.product, getProductRequest.product) &&
        Objects.equals(this.token, getProductRequest.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, token);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetProductRequest {\n");
    
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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

