package io.swagger.api.impl;

import implementation.DataSource;
import implementation.DatabaseController;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.AllCategories;
import io.swagger.model.CategoryRequest;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-04-20T13:28:13.240Z")
public class ProductsApiServiceImpl extends ProductsApiService {
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
            Product p = body.getProduct();
            System.out.println(
                    p.getName() + "\n" +
                    p.getCategory() + "\n" +
                    p.getColor() + "\n" +
                    p.getLocation() + "\n" +
                    p.getAmount() + "\n" +
                    p.getBarcode() + "\n" +
                    p.getMinAmount() + "\n" +
                    p.isMustBeRestock() + "\n" +
                    p.isCanBeRestock() + "\n");
            e.printStackTrace();
            return Response.status(400).entity(e.toString()).build();
        }
    }
    @Override
    public Response deleteProduct(ProductRequest body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response editProduct(ProductRequest body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getAllCategories(Token body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            AllCategories response = new DatabaseController().getAllCategories(con);
            return Response.ok().entity(response).build();
        } catch (SQLException ex) {
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.toString())).build();
        }
    }
    @Override
    public Response getAllProducts(Token body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            ProductArray response = new DatabaseController().getAllProducts(con);
            return Response.ok().entity(response).build();
        } catch (SQLException ex) {
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.toString())).build();
        }
    }
    @Override
    public Response getProduct(ProductRequest body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response searchProducts(SearchRequest body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
