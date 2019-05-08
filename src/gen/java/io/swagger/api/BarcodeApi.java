package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.BarcodeApiService;
import io.swagger.api.factories.BarcodeApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Barcode;
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

@Path("/barcode")


@io.swagger.annotations.Api(description = "the barcode API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-08T09:46:34.297Z")
public class BarcodeApi  {
   private final BarcodeApiService delegate;

   public BarcodeApi(@Context ServletConfig servletContext) {
      BarcodeApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("BarcodeApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (BarcodeApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = BarcodeApiServiceFactory.getBarcodeApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "When you want create a new barcode for a product. ", response = Barcode.class, tags={ "barcode", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Barcode.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    public Response generateBarcodeProduct(@ApiParam(value = "Request and Generate a new barcode for a product" ,required=true) Token body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.generateBarcodeProduct(body,securityContext);
    }
}
