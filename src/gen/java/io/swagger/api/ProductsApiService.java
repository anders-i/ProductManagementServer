package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.AllCategoriesRequest;
import io.swagger.model.Barcode;
import io.swagger.model.Product;
import io.swagger.model.ProductArray;
import io.swagger.model.SearchRequest;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-04-09T12:43:58.390Z")
public abstract class ProductsApiService {
    public abstract Response addCategory(String body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addProduct(Product body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteProduct(Barcode body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response editProduct(Product body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllCategories(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getProduct(Barcode body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchProducts(SearchRequest body,SecurityContext securityContext) throws NotFoundException;
}
