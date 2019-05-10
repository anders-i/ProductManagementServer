package io.swagger.api.impl;

import dk.aiae.client.AuthManagementClient;
import implementation.DataSource;
import implementation.DatabaseController;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.AllLocations;
import io.swagger.model.LocationRequest;
import io.swagger.model.LocationSearchRequest;
import io.swagger.model.ProductArray;
import io.swagger.model.Token;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.sql.Connection;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-10T11:07:46.349Z")
public class LocationApiServiceImpl extends LocationApiService {
    
    public LocationApiServiceImpl() {
        AuthManagementClient.setBasePath("http://127.0.0.1:30000/authenticationManagement");
    }
    
    @Override
    public Response addLocation(LocationRequest body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            new DatabaseController().addLocation(body.getString(), con);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.toString()).build();
        }
    }
    @Override
    public Response deleteLocation(LocationRequest body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            new DatabaseController().deleteLocation(body.getString().trim(), con);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity(e.toString()).build();
        }
    }
    @Override
    public Response getAllLocations(Token body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            AllLocations response = new DatabaseController().getAllLocations(con);
            return Response.ok().entity(response).build();
        } catch (Exception e) {
            return Response.status(400).entity(e.toString()).build();
        }
    }
    @Override
    public Response searchLocation(LocationSearchRequest body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
