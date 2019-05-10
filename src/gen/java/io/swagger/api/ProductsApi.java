package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ProductsApiService;
import io.swagger.api.factories.ProductsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.AllCategories;
import io.swagger.model.AllProductsOnLocationRequest;
import io.swagger.model.CategoryRequest;
import io.swagger.model.EditListOfProductsRequest;
import io.swagger.model.EditProductRequest;
import io.swagger.model.GetProductRequest;
import io.swagger.model.Product;
import io.swagger.model.ProductArray;
import io.swagger.model.ProductRequest;
import io.swagger.model.SearchRequest;
import io.swagger.model.Token;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/products")


@io.swagger.annotations.Api(description = "the products API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-10T09:44:43.395Z")
public class ProductsApi  {
   private final ProductsApiService delegate;

   public ProductsApi(@Context ServletConfig servletContext) {
      ProductsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ProductsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ProductsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ProductsApiServiceFactory.getProductsApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/addCategory")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "To add a new product category ", response = Void.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response addCategory(@ApiParam(value = "add product category to the system" ,required=true) CategoryRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addCategory(body,securityContext);
    }
    @POST
    @Path("/addProduct")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "When you want to add a new product. ", response = Void.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response addProduct(@ApiParam(value = "Add new product to system" ,required=true) ProductRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addProduct(body,securityContext);
    }
    @DELETE
    @Path("/deleteProduct")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "When you want to delete a product. ", response = Void.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response deleteProduct(@ApiParam(value = "delete product from system" ,required=true) ProductRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteProduct(body,securityContext);
    }
    @POST
    @Path("/editLocationOnMultipleProducts")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "When you want to edit a list of products to have a new location. ", response = Void.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response editLocationOnMultipleProducts(@ApiParam(value = "edit list off products to new location in system" ,required=true) EditListOfProductsRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.editLocationOnMultipleProducts(body,securityContext);
    }
    @PUT
    @Path("/editProduct")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "When you want to edit a product. ", response = Void.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response editProduct(@ApiParam(value = "edit product from system" ,required=true) EditProductRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.editProduct(body,securityContext);
    }
    @GET
    @Path("/getAllCategories")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "To get array of all product categories ", response = AllCategories.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = AllCategories.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response getAllCategories(@ApiParam(value = "add product category to the system" ,required=true) Token body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAllCategories(body,securityContext);
    }
    @GET
    @Path("/getAllProducts")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "returns arraylist with all products", notes = "", response = ProductArray.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = ProductArray.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response getAllProducts(@ApiParam(value = "To get array with all products" ,required=true) Token body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAllProducts(body,securityContext);
    }
    @POST
    @Path("/getAllProductsOnLocation")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "returns arraylist with all products from a specific location", notes = "", response = ProductArray.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = ProductArray.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response getAllProductsOnLocation(@ApiParam(value = "To get array with all products on location" ,required=true) AllProductsOnLocationRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAllProductsOnLocation(body,securityContext);
    }
    @POST
    @Path("/getProduct")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "get a single product", response = Product.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Product.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response getProduct(@ApiParam(value = "get product from system" ,required=true) GetProductRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getProduct(body,securityContext);
    }
    @POST
    @Path("/searchProducts")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "When you want to search after products by a search keyword. ", response = ProductArray.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = ProductArray.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response searchProducts(@ApiParam(value = "search products in the system" ,required=true) SearchRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchProducts(body,securityContext);
    }
}
