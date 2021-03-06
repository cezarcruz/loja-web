package br.com.cezarcruz.lojaweb.gateways.rest.converters;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.gateways.rest.response.ProductResponse;

public class ProductToProductResponse {

    private ProductToProductResponse() {}

    public static ProductResponse from(final Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .id(product.getId())
                .build();
    }

}
