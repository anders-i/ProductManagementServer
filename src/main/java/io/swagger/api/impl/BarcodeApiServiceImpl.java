package io.swagger.api.impl;

import implementation.DataSource;
import implementation.DatabaseController;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-04-20T13:28:13.240Z")
public class BarcodeApiServiceImpl extends BarcodeApiService {

    @Override
    public Response generateBarcodeLocation(Token body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response generateBarcodeProduct(Token body, SecurityContext securityContext) throws NotFoundException {
        try (Connection con = DataSource.getInstance().getConnection()) {
            Barcode response = new DatabaseController().generateBarcodeProduct(con);
            return Response.ok().entity(response).build();
        } catch (SQLException ex) {
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.toString())).build();
        }
    }
}
