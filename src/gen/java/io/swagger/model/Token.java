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
 * Token
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-10T09:44:43.395Z")
public class Token   {
  @JsonProperty("accessToken")
  private String accessToken = null;

  @JsonProperty("expires")
  private String expires = null;

  public Token accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  /**
   * The access token
   * @return accessToken
   **/
  @JsonProperty("accessToken")
  @ApiModelProperty(value = "The access token")
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public Token expires(String expires) {
    this.expires = expires;
    return this;
  }

  /**
   * Date when it expires
   * @return expires
   **/
  @JsonProperty("expires")
  @ApiModelProperty(value = "Date when it expires")
  public String getExpires() {
    return expires;
  }

  public void setExpires(String expires) {
    this.expires = expires;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Token token = (Token) o;
    return Objects.equals(this.accessToken, token.accessToken) &&
        Objects.equals(this.expires, token.expires);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, expires);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    expires: ").append(toIndentedString(expires)).append("\n");
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

