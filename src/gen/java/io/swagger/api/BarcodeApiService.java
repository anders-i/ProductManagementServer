package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Barcode;
import io.swagger.model.Token;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-04-20T13:28:13.240Z")
public abstract class BarcodeApiService {
    public abstract Response generateBarcodeLocation(Token body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response generateBarcodeProduct(Token body,SecurityContext securityContext) throws NotFoundException;
}
