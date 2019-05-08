package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.LocationApiService;
import io.swagger.api.factories.LocationApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.AllLocations;
import io.swagger.model.LocationRequest;
import io.swagger.model.LocationSearchRequest;
import io.swagger.model.ProductArray;
import io.swagger.model.Token;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/location")


@io.swagger.annotations.Api(description = "the location API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-08T09:46:34.297Z")
public class LocationApi  {
   private final LocationApiService delegate;

   public LocationApi(@Context ServletConfig servletContext) {
      LocationApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("LocationApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (LocationApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = LocationApiServiceFactory.getLocationApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/addLocation")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "To add a new location ", response = Void.class, tags={ "location", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response addLocation(@ApiParam(value = "add location to the system" ,required=true) LocationRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addLocation(body,securityContext);
    }
    @DELETE
    @Path("/deleteLocation")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "To delete a location ", response = Void.class, tags={ "location", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response deleteLocation(@ApiParam(value = "delete location in the system" ,required=true) LocationRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteLocation(body,securityContext);
    }
    @GET
    @Path("/getAllLocations")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "To get array of all locations ", response = AllLocations.class, tags={ "location", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = AllLocations.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response getAllLocations(@ApiParam(value = "add product category to the system" ,required=true) Token body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getAllLocations(body,securityContext);
    }
    @DELETE
    @Path("/searchLocation")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "To find/search a location and return array with all products on that location ", response = ProductArray.class, tags={ "location", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = ProductArray.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response searchLocation(@ApiParam(value = "search a location in the system and return all products on that location" ,required=true) LocationSearchRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchLocation(body,securityContext);
    }
}
