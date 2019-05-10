package io.swagger.api.impl;

import dk.aiae.client.AuthManagementClient;
import implementation.DataSource;
import implementation.DatabaseController;
import io.swagger.api.*;
import io.swagger.model.*;

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
import java.sql.Connection;
import java.sql.SQLException;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-08T09:46:34.297Z")
public class ProductsApiServiceImpl extends ProductsApiService {
    
    public ProductsApiServiceImpl() {
        AuthManagementClient.setBasePath("http://127.0.0.1:30000/authenticationManagement");
    }
    
    @Override
    public Response addCategory(CategoryRequest body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            new DatabaseController().addNewCategory(body.getCategory(), con);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.toString()).build();
        }
    }
    @Override
    public Response addProduct(ProductRequest body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            new DatabaseController().createProduct(body.getProduct(), con);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.toString()).build();
        }
    }
    @Override
    public Response deleteProduct(ProductRequest body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            new DatabaseController().deleteProduct(body.getProduct(), con);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.toString()).build();
        }
    }
    @Override
    public Response editLocationOnMultipleProducts(EditListOfProductsRequest body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            new DatabaseController().editLocationOnMultipleProducts(body, con);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.toString()).build();
        }
    }
    @Override
    public Response editProduct(EditProductRequest body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            new DatabaseController().editProduct(body.getEditedProduct(), body.getOldBarcode(), con);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.toString()).build();
        }
    }
    @Override
    public Response getAllCategories(Token body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            AllCategories response = new DatabaseController().getAllCategories(con);
            return Response.ok().entity(response).build();
        } catch (SQLException ex) {
            return Response.status(400).entity(ex.toString()).build();
        }
    }
    @Override
    public Response getAllProducts(Token body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            ProductArray response = new DatabaseController().getAllProducts(con);
            return Response.ok().entity(response).build();
        } catch (SQLException ex) {
            return Response.status(400).entity(ex.toString()).build();
        }
    }
    @Override
    public Response getProduct(GetProductRequest body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            Product response = new DatabaseController().getProduct(1597683728284L, con); // TODO FIX when swagger 0.3 same problem as searchProducts
            return Response.ok().entity(response).build();
        } catch (SQLException ex) {
            return Response.status(400).entity(ex.toString()).build();
        }
    }
    @Override
    public Response searchProducts(SearchRequest body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            System.out.println(body.getSearchString() + " her");
            ProductArray response = new DatabaseController().searchProducts("an", con); // TODO need to be body.getSearchString when swagger 0.3 version of ProductManagement i out
            return Response.ok().entity(response).build();
        } catch (SQLException ex) {
            return Response.status(400).entity(ex.toString()).build();
        }
    }
}
