package io.swagger.api.factories;

import io.swagger.api.ProductsApiService;
import io.swagger.api.impl.ProductsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-08T09:46:34.297Z")
public class ProductsApiServiceFactory {
    private final static ProductsApiService service = new ProductsApiServiceImpl();

    public static ProductsApiService getProductsApi() {
        return service;
    }
}
