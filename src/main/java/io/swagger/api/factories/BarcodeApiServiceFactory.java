package io.swagger.api.factories;

import io.swagger.api.BarcodeApiService;
import io.swagger.api.impl.BarcodeApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-04-09T12:43:58.390Z")
public class BarcodeApiServiceFactory {
    private final static BarcodeApiService service = new BarcodeApiServiceImpl();

    public static BarcodeApiService getBarcodeApi() {
        return service;
    }
}