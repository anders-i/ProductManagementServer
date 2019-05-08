package io.swagger.api.impl;

import dk.aiae.client.AuthManagementClient;
import implementation.DataSource;
import implementation.DatabaseController;
import implementation.TokenConverter;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Barcode;
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
public class BarcodeApiServiceImpl extends BarcodeApiService {
    
    public BarcodeApiServiceImpl() {
        AuthManagementClient.setBasePath("http://127.0.0.1:30000/authenticationManagement");
    }
    
    @Override
    public Response generateBarcodeProduct(Token body, SecurityContext securityContext) throws NotFoundException {
        try{
            AuthManagementClient.getNewInstance().checkAccessToken(TokenConverter.getToken(body));
            try (Connection con = DataSource.getInstance().getConnection()) {
                Barcode response = new DatabaseController().generateBarcodeProduct(con);
                return Response.ok().entity(response).build();
            } catch (SQLException ex) {
                return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.toString())).build();
            }
        } catch (Exception ex) {
            return Response.status(400).entity(ex.toString()).build();
        }
    }
}
