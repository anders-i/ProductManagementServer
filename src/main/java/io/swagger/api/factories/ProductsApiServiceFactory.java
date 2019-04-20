package io.swagger.api.factories;

import io.swagger.api.ProductsApiService;
import io.swagger.api.impl.ProductsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-04-20T13:28:13.240Z")
public class ProductsApiServiceFactory {
    private final static ProductsApiService service = new ProductsApiServiceImpl();

    public static ProductsApiService getProductsApi() {
        return service;
    }
}
