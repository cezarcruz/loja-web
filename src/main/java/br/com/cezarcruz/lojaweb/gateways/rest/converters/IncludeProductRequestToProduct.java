package br.com.cezarcruz.lojaweb.gateways.rest.converters;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeProductRequest;

public class IncludeProductRequestToProduct {

    private IncludeProductRequestToProduct() {}

    public static Product from(final IncludeProductRequest includeProductRequest) {
        return Product.builder()
                .name(includeProductRequest.getName())
                .price(includeProductRequest.getPrice())
                .build();
    }

}
