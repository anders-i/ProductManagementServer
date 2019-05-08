package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.AllCategories;
import io.swagger.model.CategoryRequest;
import io.swagger.model.EditListOfProductsRequest;
import io.swagger.model.EditProductRequest;
import io.swagger.model.GetProductRequest;
import io.swagger.model.Product;
import io.swagger.model.ProductArray;
import io.swagger.model.ProductRequest;
import io.swagger.model.SearchRequest;
import io.swagger.model.Token;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-08T09:46:34.297Z")
public abstract class ProductsApiService {
    public abstract Response addCategory(CategoryRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addProduct(ProductRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteProduct(ProductRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response editLocationOnMultipleProducts(EditListOfProductsRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response editProduct(EditProductRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllCategories(Token body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllProducts(Token body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getProduct(GetProductRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchProducts(SearchRequest body,SecurityContext securityContext) throws NotFoundException;
}
