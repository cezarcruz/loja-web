package br.com.cezarcruz.lojaweb.gateways.rest.transformacao;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.gateways.rest.response.ProductResponse;

public class ProductToProductResponse {

    public static ProductResponse from(final Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .id(product.getId())
                .build();
    }

}
