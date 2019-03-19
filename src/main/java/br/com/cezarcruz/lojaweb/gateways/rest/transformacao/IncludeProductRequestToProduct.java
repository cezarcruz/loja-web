package br.com.cezarcruz.lojaweb.gateways.rest.transformacao;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeProductRequest;

public class IncludeProductRequestToProduct {

    public static Product from(final IncludeProductRequest includeProductRequest) {
        return Product.builder()
                .name(includeProductRequest.getName())
                .price(includeProductRequest.getPrice())
                .build();
    }

}
