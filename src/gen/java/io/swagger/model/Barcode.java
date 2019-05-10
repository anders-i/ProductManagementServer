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
import javax.validation.constraints.*;

/**
 * Barcode
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-10T09:44:43.395Z")
public class Barcode   {
  @JsonProperty("barcodeID")
  private Long barcodeID = null;

  public Barcode barcodeID(Long barcodeID) {
    this.barcodeID = barcodeID;
    return this;
  }

  /**
   * The barecode
   * @return barcodeID
   **/
  @JsonProperty("barcodeID")
  @ApiModelProperty(value = "The barecode")
  public Long getBarcodeID() {
    return barcodeID;
  }

  public void setBarcodeID(Long barcodeID) {
    this.barcodeID = barcodeID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Barcode barcode = (Barcode) o;
    return Objects.equals(this.barcodeID, barcode.barcodeID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(barcodeID);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Barcode {\n");
    
    sb.append("    barcodeID: ").append(toIndentedString(barcodeID)).append("\n");
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

