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
import io.swagger.model.Barcode;
import io.swagger.model.Product;
import io.swagger.model.Token;
import javax.validation.constraints.*;

/**
 * EditProductRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-08T09:46:34.297Z")
public class EditProductRequest   {
  @JsonProperty("editedProduct")
  private Product editedProduct = null;

  @JsonProperty("oldBarcode")
  private Barcode oldBarcode = null;

  @JsonProperty("token")
  private Token token = null;

  public EditProductRequest editedProduct(Product editedProduct) {
    this.editedProduct = editedProduct;
    return this;
  }

  /**
   * Get editedProduct
   * @return editedProduct
   **/
  @JsonProperty("editedProduct")
  @ApiModelProperty(value = "")
  public Product getEditedProduct() {
    return editedProduct;
  }

  public void setEditedProduct(Product editedProduct) {
    this.editedProduct = editedProduct;
  }

  public EditProductRequest oldBarcode(Barcode oldBarcode) {
    this.oldBarcode = oldBarcode;
    return this;
  }

  /**
   * Get oldBarcode
   * @return oldBarcode
   **/
  @JsonProperty("oldBarcode")
  @ApiModelProperty(value = "")
  public Barcode getOldBarcode() {
    return oldBarcode;
  }

  public void setOldBarcode(Barcode oldBarcode) {
    this.oldBarcode = oldBarcode;
  }

  public EditProductRequest token(Token token) {
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
    EditProductRequest editProductRequest = (EditProductRequest) o;
    return Objects.equals(this.editedProduct, editProductRequest.editedProduct) &&
        Objects.equals(this.oldBarcode, editProductRequest.oldBarcode) &&
        Objects.equals(this.token, editProductRequest.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(editedProduct, oldBarcode, token);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EditProductRequest {\n");
    
    sb.append("    editedProduct: ").append(toIndentedString(editedProduct)).append("\n");
    sb.append("    oldBarcode: ").append(toIndentedString(oldBarcode)).append("\n");
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

