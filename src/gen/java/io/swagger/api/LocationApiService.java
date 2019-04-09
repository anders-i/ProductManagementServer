package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.AllLocationsRequest;
import io.swagger.model.Barcode;
import io.swagger.model.ProductArray;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-04-09T12:43:58.390Z")
public abstract class LocationApiService {
    public abstract Response addLocation(String body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteLocation(String body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllLocations(SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchLocation(Barcode body,SecurityContext securityContext) throws NotFoundException;
}
