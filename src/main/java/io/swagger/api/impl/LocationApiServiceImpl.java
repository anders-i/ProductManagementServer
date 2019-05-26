package io.swagger.api.impl;

import dk.aiae.client.AuthManagementClient;
import implementation.DataSource;
import implementation.DatabaseController;
import implementation.TokenConverter;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.AllLocations;
import io.swagger.model.LocationRequest;
import io.swagger.model.LocationSearchRequest;
import io.swagger.model.Token;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-26T10:45:56.712Z")
public class LocationApiServiceImpl extends LocationApiService {

    public LocationApiServiceImpl() {
        AuthManagementClient.setBasePath("http://127.0.0.1:30000/authenticationManagement");
    }

    @Override
    public Response addLocation(LocationRequest body, SecurityContext securityContext) throws NotFoundException {
        try {
            AuthManagementClient.getNewInstance().checkAccessToken(TokenConverter.getToken(body.getToken()));
            try (Connection con = DataSource.getInstance().getConnection()) {
                new DatabaseController().addLocation(body.getLocation().getName().trim(), con);
                return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
            } catch (Exception e) {
                Logger.getLogger(LocationApiServiceImpl.class.getName()).log(Level.SEVERE, null, e);
                return Response.status(400).entity(e.toString()).build();
            }
        } catch (io.swagger.client.ApiException e) {
            Logger.getLogger(LocationApiServiceImpl.class.getName()).log(Level.SEVERE, null, e);
            return Response.status(400).entity(e.toString()).build();
        }
    }

    @Override
    public Response deleteLocation(LocationRequest body, SecurityContext securityContext) throws NotFoundException {
        try {
            AuthManagementClient.getNewInstance().checkAccessToken(TokenConverter.getToken(body.getToken()));
            try (Connection con = DataSource.getInstance().getConnection()) {
                new DatabaseController().deleteLocation(body.getLocation().getName().trim(), con);
                return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
            } catch (Exception e) {
                Logger.getLogger(LocationApiServiceImpl.class.getName()).log(Level.SEVERE, null, e);
                return Response.status(400).entity(e.toString()).build();
            }
        } catch (io.swagger.client.ApiException e) {
            Logger.getLogger(LocationApiServiceImpl.class.getName()).log(Level.SEVERE, null, e);
            return Response.status(400).entity(e.toString()).build();
        }
    }

    @Override
    public Response getAllLocations(Token body, SecurityContext securityContext) throws NotFoundException {
        try {
            AuthManagementClient.getNewInstance().checkAccessToken(TokenConverter.getToken(body));
            try (Connection con = DataSource.getInstance().getConnection()) {
                AllLocations response = new DatabaseController().getAllLocations(con);
                return Response.ok().entity(response).build();
            } catch (Exception e) {
                Logger.getLogger(LocationApiServiceImpl.class.getName()).log(Level.SEVERE, null, e);
                return Response.status(400).entity(e.toString()).build();
            }
        } catch (io.swagger.client.ApiException e) {
            Logger.getLogger(LocationApiServiceImpl.class.getName()).log(Level.SEVERE, null, e);
            return Response.status(400).entity(e.toString()).build();
        }
    }

    @Override
    public Response searchLocation(LocationSearchRequest body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
