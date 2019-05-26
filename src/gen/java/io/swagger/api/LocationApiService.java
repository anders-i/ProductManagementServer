package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.AllLocations;
import io.swagger.model.LocationRequest;
import io.swagger.model.LocationSearchRequest;
import io.swagger.model.Token;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-26T10:45:56.712Z")
public abstract class LocationApiService {
    public abstract Response addLocation(LocationRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteLocation(LocationRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllLocations(Token body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchLocation(LocationSearchRequest body,SecurityContext securityContext) throws NotFoundException;
}
