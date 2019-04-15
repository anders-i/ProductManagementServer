package io.swagger.api.impl;

import implementation.DataSource;
import implementation.DatabaseController;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.AllCategoriesRequest;
import io.swagger.model.Barcode;
import io.swagger.model.Product;
import io.swagger.model.ProductArray;
import io.swagger.model.SearchRequest;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.sql.Connection;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-04-09T12:43:58.390Z")
public class ProductsApiServiceImpl extends ProductsApiService {
    @Override
    public Response addCategory(String body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response addProduct(Product body, SecurityContext securityContext) throws NotFoundException {
        try(Connection con = DataSource.getInstance().getConnection()) {
            new DatabaseController().createProduct(body, con);
              return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        } catch (Exception e) {  
              return Response.status(400).entity(e.toString()).build();
        }
      
    }
    @Override
    public Response deleteProduct(Barcode body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response editProduct(Product body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getAllCategories(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getProduct(Barcode body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response searchProducts(SearchRequest body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
