package io.swagger.api.factories;

import io.swagger.api.LocationApiService;
import io.swagger.api.impl.LocationApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-10T09:44:43.395Z")
public class LocationApiServiceFactory {
    private final static LocationApiService service = new LocationApiServiceImpl();

    public static LocationApiService getLocationApi() {
        return service;
    }
}
