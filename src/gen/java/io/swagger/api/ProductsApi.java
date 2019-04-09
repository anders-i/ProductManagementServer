package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ProductsApiService;
import io.swagger.api.factories.ProductsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.AllCategoriesRequest;
import io.swagger.model.Barcode;
import io.swagger.model.Product;
import io.swagger.model.ProductArray;
import io.swagger.model.SearchRequest;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-04-09T12:43:58.390Z")
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
    public Response addCategory(@ApiParam(value = "add product category to the system" ,required=true) String body
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
    public Response addProduct(@ApiParam(value = "Add new product to system" ,required=true) Product body
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
    public Response deleteProduct(@ApiParam(value = "delete product from system" ,required=true) Barcode body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteProduct(body,securityContext);
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
    public Response editProduct(@ApiParam(value = "edit product from system" ,required=true) Product body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.editProduct(body,securityContext);
    }
    @GET
    @Path("/getAllCategories")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "To get array of all product categories ", response = AllCategoriesRequest.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = AllCategoriesRequest.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response getAllCategories(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAllCategories(securityContext);
    }
    @GET
    @Path("/getProduct")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "When you want to delete a product. ", response = Product.class, tags={ "product", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Product.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response getProduct(@ApiParam(value = "get product from system" ,required=true) Barcode body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getProduct(body,securityContext);
    }
    @GET
    @Path("/searchProducts")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "When you want to search after products by a search a search keyword. ", response = ProductArray.class, tags={ "product", })
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
